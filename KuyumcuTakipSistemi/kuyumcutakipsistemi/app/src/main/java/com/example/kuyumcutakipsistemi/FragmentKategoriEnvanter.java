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




public class FragmentKategoriEnvanter extends Fragment {

    View view;
    ListView listView;
    veri_tabani_baglanti db;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_kategori_envanter, container, false);

        listView = (ListView) view.findViewById(R.id.listView_Kategori);


        db = new veri_tabani_baglanti(getActivity());

        String[] values_kategori = new String[9];

        ArrayAdapter<String> adapter_kategori = new ArrayAdapter<>(view.getContext(), android.R.layout.simple_list_item_1, android.R.id.text1, values_kategori);


        listView.setAdapter(adapter_kategori);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Cursor liste = db.getdata_kategori();
                    if (liste.getCount() == 0) {
                        Toast.makeText(getActivity(), "Kayit bulunamadi.", Toast.LENGTH_SHORT).show();
                    }
                    StringBuffer stringBuffer = new StringBuffer();
                    while (liste.moveToNext()) {
                        stringBuffer.append("Ürün id:" + liste.getString(0) + "\n");
                        stringBuffer.append("Kategori Tipi:" + liste.getString(1) + "\n");
                        stringBuffer.append("Ürün Listesi:" + liste.getString(2) + "\n");


                    }

                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setCancelable(true);
                    builder.setTitle("KATEGORİLER");
                    builder.setMessage(stringBuffer.toString());
                    builder.show();
                }


            }

        });


        return view;
    }}