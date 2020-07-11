package com.example.hireme.Fragments;


import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.TextView;

import com.example.hireme.Dashboard;
import com.example.hireme.Posts;
import com.example.hireme.R;
import com.example.hireme.SignActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class DashboardFragment extends Fragment {

    View view;
    TextView textView;
    CardView cv1, cv2,cv3,cv4,cv5;




    public DashboardFragment() {
        // Required empty public constructor


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_dashboard, container, false);

        textView = view.findViewById(R.id.dashboardTxt);
        textView.setText("I Need Help With..");

        cv1 = view.findViewById(R.id.gardening);
        cv2 = view.findViewById(R.id.cleaning);
        cv3 = view.findViewById(R.id.shopping);
        cv4 = view.findViewById(R.id.handy);
        cv5 = view.findViewById(R.id.gen_help);

        cv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DashboardFragment.this, Posts.class);
                startActivity(intent);
            }
        });

        cv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DashboardFragment.this, Posts.class);
                startActivity(intent);
            }
        });

        cv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DashboardFragment.this, Posts.class);
                startActivity(intent);
            }
        });

        cv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DashboardFragment.this, Posts.class);
                startActivity(intent);
            }
        });

        cv5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DashboardFragment.this, Posts.class);
                startActivity(intent);
            }
        });



        return view;
    }

}
