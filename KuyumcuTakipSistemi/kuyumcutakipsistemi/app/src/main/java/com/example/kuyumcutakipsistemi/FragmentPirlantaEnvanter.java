package com.example.kuyumcutakipsistemi;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FragmentPirlantaEnvanter extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_pirlanta_envanter, container, false);
        // Veritabanındaki "Urun_listesi_pirlanta" tablosunu listeleyen kodu yazman yeterli olur.
    }
}