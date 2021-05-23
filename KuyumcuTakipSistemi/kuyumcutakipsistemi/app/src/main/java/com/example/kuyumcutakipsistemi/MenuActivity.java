package com.example.kuyumcutakipsistemi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {
    Button envanter,perakende,musteri,cikis;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        envanter=(Button)findViewById(R.id.btnEnvanter);
        perakende=(Button)findViewById(R.id.btnPerakende);
        musteri=(Button)findViewById(R.id.btnMusteri);
        cikis=(Button)findViewById(R.id.btnCikis);

        perakende.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getBaseContext(), PerakendeActivity.class);
                startActivity(intent);
            }
        });
        envanter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getBaseContext(), EnvanterActivity.class);
                startActivity(intent);
            }
        });
        musteri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), MusteriActivity.class);
                startActivity(intent);
            }
        });

        cikis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }

}