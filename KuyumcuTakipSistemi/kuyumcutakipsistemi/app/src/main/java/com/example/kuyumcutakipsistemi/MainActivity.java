package com.example.kuyumcutakipsistemi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnGiris;
    EditText username,password;
    Button giris;
    veri_tabani_baglanti db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username=(EditText) findViewById(R.id.editTextUser);
        password=(EditText)findViewById(R.id.editTextPass);
        giris=(Button) findViewById(R.id.btnGiris);
        db=new veri_tabani_baglanti(this);
        giris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user=username.getText().toString();
                String pass=password.getText().toString();
                if(user.equals("") || pass.equals(""))
                    Toast.makeText(MainActivity.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                else{
                    Boolean checkuserpassword=db.checkusernamepassword(user,pass);
                    if(checkuserpassword==true){
                        Toast.makeText(MainActivity.this, "Sign in succesfully", Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(getApplicationContext(),MenuActivity.class);
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(MainActivity.this, "Invalid credentials",
                                Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
       /*btnGiris=(Button)findViewById(R.id.btnGiris);
        btnGiris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getBaseContext(), MenuActivity.class);
                startActivity(intent);
            }
        });*/
    }
}

