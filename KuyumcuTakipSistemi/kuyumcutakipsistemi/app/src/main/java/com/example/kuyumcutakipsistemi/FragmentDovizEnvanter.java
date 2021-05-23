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


public class FragmentDovizEnvanter extends Fragment {
    View view;
    ListView listView;
    veri_tabani_baglanti db;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view= inflater.inflate(R.layout.fragment_doviz_envanter, container, false);


        listView=(ListView) view.findViewById(R.id.listView_Doviz);

        db=new veri_tabani_baglanti(getActivity());

        String[] values_doviz=new String[9];

        ArrayAdapter<String> adapter_doviz=new ArrayAdapter<>(view.getContext(),android.R.layout.simple_list_item_1 ,android.R.id.text1,values_doviz);


        listView.setAdapter(adapter_doviz);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    Cursor liste=db.getdata_doviz();
                    if(liste.getCount()==0){
                        Toast.makeText(getActivity(), "Kayit bulunamadi.", Toast.LENGTH_SHORT).show();
                    }
                    StringBuffer stringBuffer=new StringBuffer();
                    while(liste.moveToNext()){
                        stringBuffer.append("Ürün ad:"+liste.getString(0)+"\n");
                        stringBuffer.append("Para Birimi:"+liste.getString(1)+"\n");
                        stringBuffer.append("Maliyet Fiyatı:"+liste.getString(2)+"\n");
                        stringBuffer.append("Alış Fiyatı:"+liste.getString(3)+"\n\n");
                        stringBuffer.append("Satış Fiyatı:"+liste.getString(4)+"\n");
                        stringBuffer.append("Stok:"+liste.getString(5)+"\n");


                    }

                    AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
                    builder.setCancelable(true);
                    builder.setTitle("DOVİZLER");
                    builder.setMessage(stringBuffer.toString());
                    builder.show();
                }




            }

        });




        return view;
    }
}