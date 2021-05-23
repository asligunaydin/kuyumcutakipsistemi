package com.example.kuyumcutakipsistemi;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class FragmentSaatEnvanter extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_saat_envanter, container, false);

        // Veritabanındaki "Urun_listesi_saat" tablosunu listeleyen kodu yazman yeterli olur.
    }
}