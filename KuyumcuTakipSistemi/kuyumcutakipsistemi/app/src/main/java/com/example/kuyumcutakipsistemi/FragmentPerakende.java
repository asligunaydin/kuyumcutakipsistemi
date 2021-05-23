package com.example.kuyumcutakipsistemi;


import android.app.AlertDialog;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.app.FragmentManager;
import androidx.annotation.Nullable;

import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FragmentPerakende extends Fragment {

    EditText ad,soyad,telefon,tc;
    Button kayit,listele;
    View myView;
    veri_tabani_baglanti db;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        myView=inflater.inflate(R.layout.fragment_perakende, container, false);


        ad=(EditText)myView.findViewById(R.id.editText_adet);
        soyad=(EditText)myView.findViewById(R.id.editText_alis);
        telefon=(EditText)myView.findViewById(R.id.editText_tutar);
        tc=(EditText)myView.findViewById(R.id.editText_tutar2);
        kayit=(Button) myView.findViewById(R.id.button7);
        listele=(Button)myView.findViewById(R.id.btnIslemYap);

        db=new veri_tabani_baglanti(getActivity());

        kayit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ad_txt=ad.getText().toString();
                String soyad_txt=soyad.getText().toString();
                String telefon_txt=telefon.getText().toString();
                String tc_txt=tc.getText().toString();
                Boolean kontrol=db.insertMüsteri(ad_txt,soyad_txt,telefon_txt,tc_txt);

                if(kontrol==true){
                    Toast.makeText(getActivity(), "Müşteri kayit edilmiştir.", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getActivity(), "Müşteri kayit edilemedi.", Toast.LENGTH_SHORT).show();
                }

            }
        });
        listele.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tc_no=tc.getText().toString();
                Cursor liste=db.getdata(tc_no);
                if(liste.getCount()==0){
                    Toast.makeText(getActivity(), "Kayit bulunamadi.", Toast.LENGTH_SHORT).show();
                }

                StringBuffer stringBuffer=new StringBuffer();
                while(liste.moveToNext()){
                    stringBuffer.append("AD:"+liste.getString(0)+"\n");
                    stringBuffer.append("SOYAD:"+liste.getString(1)+"\n");
                    stringBuffer.append("TC NO:"+liste.getString(2)+"\n");
                    stringBuffer.append("TELEFON:"+liste.getString(3)+"\n\n");
                }

                AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
                builder.setCancelable(true);
                builder.setTitle("MÜŞTERİLER");
                builder.setMessage(stringBuffer.toString());
                builder.show();


            }
        });

        return myView;
    }



}
