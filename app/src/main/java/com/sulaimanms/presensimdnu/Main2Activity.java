package com.sulaimanms.presensimdnu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;

public class Main2Activity extends AppCompatActivity {

    private Button satuA, duaA, tigaA, empatA, satuW, duaW, satuU, duaU;
    Button kk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        satuA = (Button)findViewById(R.id.awl_1);
        duaA = (Button)findViewById(R.id.awl_2);
        tigaA = (Button)findViewById(R.id.awl_3);
        empatA = (Button)findViewById(R.id.awl_4);
        satuW = (Button)findViewById(R.id.wustho_1);
        duaW = (Button)findViewById(R.id.wustho_2);
        satuU = (Button)findViewById(R.id.ulya_1);
        duaU = (Button)findViewById(R.id.ulya_2);

        satuA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Main2Activity.this, Main3Activity.class);
                intent.putExtra("kelas", "1Aa");
                startActivity(intent);
            }
        });
        duaA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Main2Activity.this, Main3Activity.class);
                intent.putExtra("kelas", "2Aa");
                startActivity(intent);
            }
        });
        tigaA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Main2Activity.this, Main3Activity.class);
                intent.putExtra("kelas", "3Aa");
                startActivity(intent);
            }
        });
        empatA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Main2Activity.this, Main3Activity.class);
                intent.putExtra("kelas", "4Aa");
                startActivity(intent);
            }
        });
        satuW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Main2Activity.this, Main3Activity.class);
                intent.putExtra("kelas", "1Wa");
                startActivity(intent);
            }
        });
        duaW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Main2Activity.this, Main3Activity.class);
                intent.putExtra("kelas", "2Wa");
                startActivity(intent);
            }
        });
        satuU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Main2Activity.this, Main3Activity.class);
                intent.putExtra("kelas", "1Ua");
                startActivity(intent);
            }
        });
        duaU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Main2Activity.this, Main3Activity.class);
                intent.putExtra("kelas", "2Ua");
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
