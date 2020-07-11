package com.example.hireme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    DatabaseHelper db;

    EditText e1, e2, e3, e4, e5, e6;

    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        db = new DatabaseHelper(this);

        e1 = (EditText) findViewById(R.id.Name);
        e2 = (EditText) findViewById(R.id.Email);
        e3 = (EditText) findViewById(R.id.Phone);
        e4 = (EditText) findViewById(R.id.Address);
        e5 = (EditText) findViewById(R.id.password);
        e6 = (EditText) findViewById(R.id.password1);
        btn = (Button) findViewById(R.id.reg);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1 = e1.getText().toString();
                String s2 = e2.getText().toString();
                String s3 = e3.getText().toString();
                String s4 = e4.getText().toString();
                String s5 = e5.getText().toString();
                String s6 = e6.getText().toString();
                if (s1.equals("") || s2.equals("") || s3.equals("") || s4.equals("") || s5.equals("") || s6.equals("")) {
                    Toast.makeText(getApplicationContext(), "Fields are empty", Toast.LENGTH_SHORT).show();
                } else {
                    if (s5.equals(s6)) {
                        Boolean chkemail = db.chkemail(s2);
                        if (chkemail == true) {
                            Boolean insert = db.addUser(s1, s2, s3, s4, s5);
                            if (insert == true) {
                                Toast.makeText(getApplicationContext(), "Registered Successfully", Toast.LENGTH_SHORT).show();
                                Intent moveToLogin = new Intent(Register.this, SignActivity.class);
                                startActivity(moveToLogin);
                            }

                        } else {
                            Toast.makeText(getApplicationContext(), "Email already exists", Toast.LENGTH_SHORT).show();
                        }

                    }
                    Toast.makeText(getApplicationContext(), "Passwords do not match", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
