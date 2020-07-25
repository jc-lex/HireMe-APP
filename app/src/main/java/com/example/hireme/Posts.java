package com.example.hireme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.hireme.Fragments.DashboardFragment;

public class Posts extends AppCompatActivity {
    EditText et;

    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posts);
        Intent i = getIntent();
        final int skill_set = i.getIntExtra("skill_set", 1);
        et = findViewById(R.id.ed_Text);

        btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String location = et.getText().toString();

                Intent intent = new Intent(Posts.this, Display.class);
                intent.putExtra("location", location);
                intent.putExtra("skill_set", skill_set);

                startActivity(intent);
            }
        });
    }
}
