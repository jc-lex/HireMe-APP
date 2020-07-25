package com.example.hireme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Tasker extends AppCompatActivity {

    SQLiteDatabase db;
    EditText e1, e2, e3, e4, e5, e6;
    Button btn;
    SQLiteOpenHelper openHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasker);


        e1 = findViewById(R.id.nombre);
        e2 = findViewById(R.id.mail);
        e3 = findViewById(R.id.telly);
        e4 = findViewById(R.id.ghetto);
        e5 = findViewById(R.id.skill);
        e6 = findViewById(R.id.rate);
        btn = findViewById(R.id.reg1);
        openHelper= new DatabaseHelper2(this);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = e1.getText().toString();
                String email = e2.getText().toString();
                String telephone = e3.getText().toString();
                String address = e4.getText().toString();
                String skills = e5.getText().toString();
                String fee = e6.getText().toString();
                db = openHelper.getWritableDatabase();
                insertData(name, email,telephone,address, skills, fee);
                Toast.makeText(getApplicationContext(), "Registered Successfully", Toast.LENGTH_SHORT).show();


            }



        });
    }
    public void insertData(String name, String email, String telephone, String address, String skills, String fee){
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper2.COLS_1, name);
        contentValues.put(DatabaseHelper2.COLS_2, email);
        contentValues.put(DatabaseHelper2.COLS_3, telephone);
        contentValues.put(DatabaseHelper2.COLS_4, address);
        contentValues.put(DatabaseHelper2.COLS_5, skills);
        contentValues.put(DatabaseHelper2.COLS_6, fee);
        long id = db.insert(DatabaseHelper2.TABLE_NAME, null, contentValues);


    }
}