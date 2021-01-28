package com.ybs.ex1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class InstructionsActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btnStartPlay2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructions);
        btnStartPlay2=findViewById(R.id.btnStartPlay2ID);
        btnStartPlay2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.btnStartPlay2ID) {
            Intent i = new Intent(InstructionsActivity.this, GameActivity.class);
            startActivity(i);
        }
    }
}
