package com.example.products3.async;

import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.products3.R;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProgressFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProgressFragment extends DialogFragment {

    public ProgressFragment() {
        // Required empty public constructor
    }


    public static ProgressFragment newInstance() {
        return new ProgressFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_progress, container, false);
    }
}
