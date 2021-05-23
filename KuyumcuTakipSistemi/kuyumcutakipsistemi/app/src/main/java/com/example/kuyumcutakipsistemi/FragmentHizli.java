package com.example.kuyumcutakipsistemi;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import androidx.fragment.app.Fragment;
import com.example.kuyumcutakipsistemi.R;

public class FragmentHizli extends Fragment {
    ListView altin,doviz;
    View myView;

    EditText editText_urun;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        myView= inflater.inflate(R.layout.fragment_hizli,container,false);

        altin=(ListView) myView.findViewById(R.id.listView_Altin);
        doviz=(ListView) myView.findViewById(R.id.listView_Doviz);
        editText_urun=(EditText) myView.findViewById(R.id.editText_urun);

        String[] values_doviz=new String[4];
        values_doviz[0]="HAS ALTIN";
        values_doviz[1]="DOLAR";
        values_doviz[2]="EURO";
        values_doviz[3]="STERLİN";

        String[] values_altin=new String[12];
        values_altin[0]="ÇEYREK";
        values_altin[1]="YARIM";
        values_altin[2]="ZİYNET LİRA";
        values_altin[3]="ATA LİRA";
        values_altin[4]="ZİYNET İKİBUÇUKLUK";
        values_altin[5]="YENİ ÇEYREK";
        values_altin[6]="YENİ YARIM";
        values_altin[7]="YENİ ZİYNET LİRA";
        values_altin[8]="ATA ÇEYREK";
        values_altin[9]="ATA YARIM";
        values_altin[10]="ATA İKİBUÇUKLUK";
        values_altin[11]="REŞAT ÇEYREK";

        ArrayAdapter<String> adapter_doviz=new ArrayAdapter<>(myView.getContext(),android.R.layout.simple_list_item_1 ,android.R.id.text1,values_doviz);
        ArrayAdapter<String> adapter_altin=new ArrayAdapter<>(myView.getContext(),android.R.layout.simple_list_item_2 ,android.R.id.text2,values_altin);

        altin.setAdapter(adapter_altin);
        doviz.setAdapter(adapter_doviz);

        altin.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    editText_urun.setText("ÇEYREK");
                }
                else if(position==1){
                    editText_urun.setText("YARIM");
                }
                else if(position==2){
                    editText_urun.setText("ZİYNET LİRA");
                }
                else if(position==3){
                    editText_urun.setText("ATA LİRA");
                }
                else if(position==4){
                    editText_urun.setText("ZİYNET İKİBUÇUKLUK");
                }
                else if(position==5){
                    editText_urun.setText("YENİ ÇEYREK");
                }
                else if(position==6){
                    editText_urun.setText("YENİ YARIM");
                }
                else if(position==7){
                    editText_urun.setText("YENİ ZİYNET LİRA");
                }
                else if(position==8){
                    editText_urun.setText("ATA ÇEYREK");
                }
                else if(position==9){
                    editText_urun.setText("ATA YARIM");
                }
                else if(position==10){
                    editText_urun.setText("ATA İKİBUÇUKLUK");
                }
                else{
                    editText_urun.setText("REŞAT ÇEYREK");
                }

            }
        });


        doviz.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    editText_urun.setText("HAS ALTIN");
                }
                else if(position==1){
                    editText_urun.setText("DOLAR");
                }
                else if(position==2){
                    editText_urun.setText("EURO");
                }
                else{
                    editText_urun.setText("STERLİN");
                }
            }
        });


        return myView;

    }
}
