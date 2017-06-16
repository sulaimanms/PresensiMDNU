package com.sulaimanms.presensimdnu;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.sulaimanms.presensimdnu.Api.HasilPresensi;
import com.sulaimanms.presensimdnu.Api.Kirim;
import com.sulaimanms.presensimdnu.Api.Presensi;
import com.sulaimanms.presensimdnu.face.Attend;
import com.sulaimanms.presensimdnu.face.Kelas;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Handler;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.content.ContentValues.TAG;

public class Main3Activity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Presensi> presensis;
    private Adapter adapter;
    private Button btnPresensi;
    private ArrayList<Kirim> listPresensi;
    private ProgressDialog progress;
    private int buttCounter = 0;
    private RadioGroup radioGroup;
    AlertDialogManager alert = new AlertDialogManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        initViews();
        //progress bar
        progress = new ProgressDialog(Main3Activity.this);
        progress.setMessage("sedang mengirim");

        btnPresensi = (Button)findViewById(R.id.btn_presensi);
        btnPresensi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    limitPresensi();
                }catch (Exception e){
                    Toast.makeText(Main3Activity.this, "Ada Kesalahan", Toast.LENGTH_SHORT).show();
                }

            }
        });

        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
    }

    private void limitPresensi(){
        if (this.buttCounter <= 2) {

            try {
                kirimData();


                /*Thread thread = new Thread( new Runnable() {
                    @Override
                    public void run() {
                        try
                        {
                            Thread.sleep(2000);
                            Intent intent = new Intent(Main3Activity.this, Main2Activity.class);
                            startActivity(intent);
                        }
                        catch (Exception e) {
                            e.printStackTrace();
                        }
                        finally {
                            finish();
                        }
                    }
                });

                thread.start();*/
            }catch (Exception e){
                Toast.makeText(Main3Activity.this, "Tunggu Sebentar...", Toast.LENGTH_SHORT).show();
            }
            this.buttCounter++;
        }else btnPresensi.setClickable(false);
    }

    private void initViews(){
        recyclerView = (RecyclerView)findViewById(R.id.card_recycler_view);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        presensis = new ArrayList<>();
        loadKelas();
    }

    private void loadKelas(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://sia-md-demo.azurewebsites.net/api/v2/presensi_api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Kelas request = retrofit.create(Kelas.class);
        Call<List<Presensi>> call = request.getRepos(getIntent().getStringExtra("kelas").toString().trim());
        call.enqueue(new Callback<List<Presensi>>() {
            @Override
            public void onResponse(Call<List<Presensi>> call, Response<List<Presensi>> response) {
                if (response.isSuccessful()) {
                    presensis = response.body();
                    adapter = new Adapter(presensis);
                    recyclerView.setAdapter(adapter);
                }else {
                    Log.d(TAG, "gakada");
                }
            }

            @Override
            public void onFailure(Call<List<Presensi>> call, Throwable t) {
                Log.d("Error",t.getMessage());
            }
        });
    }

    private void kirimData() {
        //inisialisasi tanggal
        final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        final String date = sdf.format(new Date());

        listPresensi = new ArrayList<>();
        for (int i=0; i<adapter.answer.size(); i++){
            Kirim kirim = new Kirim();
            kirim.setTglPresensi(date);
            kirim.setNipUstad("Ustad");
            kirim.setKdKelas(getIntent().getStringExtra("kelas").toString().trim());
            kirim.setKeterangan(adapter.answer.get(i).toString().trim());
            kirim.setNis(presensis.get(i).getNis().toString().trim());

            listPresensi.add(kirim);
        }
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://sia-md-demo.azurewebsites.net/api/v2/presensi_api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Attend client = retrofit.create(Attend.class);
        Call<HasilPresensi> call1 = client.kirimData(listPresensi);
        call1.enqueue(new Callback<HasilPresensi>() {

            @Override
            public void onResponse(Call<HasilPresensi> call, Response<HasilPresensi> response) {
                if (response.isSuccessful()){
                    progress.show();
                    alert.showAlertDialog(Main3Activity.this, "Presensi Berhasil", false);
                    //Toast.makeText(Main3Activity.this, response.body().getDetail().toString().trim(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<HasilPresensi> call, Throwable t) {

            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
