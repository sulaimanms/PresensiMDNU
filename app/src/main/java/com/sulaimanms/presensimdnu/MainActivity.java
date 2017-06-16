package com.sulaimanms.presensimdnu;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.sulaimanms.presensimdnu.Api.User;
import com.sulaimanms.presensimdnu.face.Login;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private Button btnlogin;
    private EditText edtNIP, edtPass;
    private String user, pass;
    private ProgressDialog progress;
    // Alert Dialog Manager
    AlertDialogManager alert = new AlertDialogManager();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progress = new ProgressDialog(MainActivity.this);
        progress.setMessage("Loading...");

        btnlogin = (Button)findViewById(R.id.login);
        edtNIP = (EditText)findViewById(R.id.nip);
        edtPass = (EditText)findViewById(R.id.password);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user = edtNIP.getText().toString();
                pass = edtPass.getText().toString();
                login();
            }
        });
    }

    private void login(){
        final Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("http://sia-md-demo.azurewebsites.net/api/v2/login_api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        final Login logins = retrofit.create(Login.class);
        Call<User> call = logins.login(user,pass);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                Boolean status = response.body().getStatus();
                if(status == true){
                    progress.show();
                    String user_id = response.body().getData().getUserId();
                    String nama = response.body().getData().getNama();
                    String role= response.body().getData().getRole();
                    String last_activity = response.body().getData().getLastActivity();

                    Handler mHandler = new Handler();

                    Runnable mStartActivityTask= new Runnable() {
                        public void run() {
                            startActivity(new Intent(MainActivity.this,Main2Activity.class));
                        }
                    };
                    mHandler.postDelayed(mStartActivityTask, 50);
                }
                else{
                    edtNIP.setText("");
                    edtPass.setText("");
                    alert.showAlertDialog(MainActivity.this, "Username/Password Salah", false);
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                edtNIP.setText("");
                edtPass.setText("");
                alert.showAlertDialog(MainActivity.this, "Tidak ada koneksi internet", false);
            }
        });
    }
}
