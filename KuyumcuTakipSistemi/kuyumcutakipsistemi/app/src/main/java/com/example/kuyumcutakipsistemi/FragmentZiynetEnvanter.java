package com.example.kuyumcutakipsistemi;

import android.app.AlertDialog;
import android.database.Cursor;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


public class FragmentZiynetEnvanter extends Fragment {


    View view;
    ListView listView;
    veri_tabani_baglanti db;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view =inflater.inflate(R.layout.fragment_ziynet_envanter, container, false);

        listView=(ListView)view.findViewById(R.id.listView_Ziynet);


        String[] values_ziynet=new String[9];

        ArrayAdapter<String> adapter_ziynet=new ArrayAdapter<>(view.getContext(),android.R.layout.simple_list_item_1 ,android.R.id.text1,values_ziynet);


        listView.setAdapter(adapter_ziynet);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    Cursor liste=db.getdata_ziynet();
                    if(liste.getCount()==0){
                        Toast.makeText(getActivity(), "Kayit bulunamadi.", Toast.LENGTH_SHORT).show();
                    }
                    StringBuffer stringBuffer=new StringBuffer();
                    while(liste.moveToNext()){
                        stringBuffer.append("Ürün ad:"+liste.getString(0)+"\n");
                        stringBuffer.append("Has Milyem:"+liste.getString(1)+"\n");
                        stringBuffer.append("Gram Maliyet Milyem:"+liste.getString(2)+"\n");
                        stringBuffer.append("Adet Maliyet Milyem:"+liste.getString(3)+"\n\n");
                        stringBuffer.append("Alis Milyem:"+liste.getString(4)+"\n");
                        stringBuffer.append("Satis Milyem:"+liste.getString(5)+"\n");
                        stringBuffer.append("Adetli İşçilik:"+liste.getString(6)+"\n");
                        stringBuffer.append("Gram Stok:"+liste.getString(7)+"\n\n");
                        stringBuffer.append("Adet Stok:"+liste.getString(8)+"\n\n");


                    }

                    AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
                    builder.setCancelable(true);
                    builder.setTitle("ALTINLAR");
                    builder.setMessage(stringBuffer.toString());
                    builder.show();
                }




            }

        });





        return view;
    }
}