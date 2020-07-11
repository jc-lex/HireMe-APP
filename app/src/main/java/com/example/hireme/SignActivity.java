package com.example.hireme;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hireme.Fragments.DashboardFragment;

public class SignActivity extends AppCompatActivity {
    public Button button;

    TextView textView;
    EditText e1,e2;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign);

        db = new DatabaseHelper(this);
        e1 = (EditText)findViewById(R.id.et_Email);
        e2 = (EditText)findViewById(R.id.et_password);

        textView= (TextView)findViewById(R.id.Register);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignActivity.this, Register.class);
                startActivity(intent);
            }
        });

        button = findViewById(R.id.btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = e1.getText().toString();
                String password = e2.getText().toString();
                Boolean chkemailpassword = db.emailpassword(email, password);
                if(chkemailpassword==true){
                Intent intent = new Intent(SignActivity.this, Dashboard.class);
                startActivity(intent);}
                else{
                Toast.makeText(getApplicationContext(), "Wrong email or password", Toast.LENGTH_SHORT).show();}

            }
        });


    }
}
