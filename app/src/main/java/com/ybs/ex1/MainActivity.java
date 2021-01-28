package com.ybs.ex1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnStartPlay;
    private Button btnInstruction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnStartPlay=findViewById(R.id.btnStartPlayID);
        btnInstruction=findViewById(R.id.btnInstructionID);
        btnStartPlay.setOnClickListener(this);
        btnInstruction.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnStartPlayID:
                Intent start=new Intent(MainActivity.this,GameActivity.class);
                startActivity(start);
                break;
            case R.id.btnInstructionID:
                Intent inst=new Intent(MainActivity.this,InstructionsActivity.class);
                startActivity(inst);
                break;
        }
    }
}
