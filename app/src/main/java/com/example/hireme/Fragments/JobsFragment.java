package com.example.hireme.Fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.hireme.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class JobsFragment extends Fragment {

    View view;
    TextView textView;


    public JobsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_jobs, container, false);

        textView = view.findViewById(R.id.jobTxt);
        textView.setText("Jobs Fragment");

        return view;
    }

}
