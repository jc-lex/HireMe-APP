package com.example.hireme;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class Display extends AppCompatActivity {
    RecyclerView recyclerView;
    DatabaseHelper2 db;
    ArrayList<String> name , email, telephone, address, skill, rate;
    String location;
    int skill_set;

    CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        Intent i = getIntent();
        location = i.getStringExtra("location");
        skill_set = i.getIntExtra("skill_set", 1);

        recyclerView = findViewById(R.id.recyclerView);

        db= new DatabaseHelper2(Display.this);
        name = new ArrayList<>();
        email = new ArrayList<>();
        telephone = new ArrayList<>();
        address = new ArrayList<>();
        skill = new ArrayList<>();
        rate = new ArrayList<>();

        storeDataInArrays();
        customAdapter = new CustomAdapter(Display.this, name, email,telephone, address, skill, rate);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(Display.this));
        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this, recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                Toast.makeText(getApplicationContext(), "A Notification Has Been Sent To The Tasker", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongItemClick(View view, int position) {

            }
        }));
    }
    void storeDataInArrays(){
        Cursor cursor = db.readAllData(location, skill_set);
        if (cursor.getCount() == 0){
            Toast.makeText(this, "no data", Toast.LENGTH_SHORT).show();

        }else {
            while(cursor.moveToNext()){
                name.add(cursor.getString(0));
                email.add(cursor.getString(1));
                telephone.add(cursor.getString(2));
                address.add(cursor.getString(3));
                skill.add(cursor.getString(4));
                rate.add(cursor.getString(5));

            }
        }

    }
}
