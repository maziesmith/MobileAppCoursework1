package com.example.thamashi.coursework1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainMenu extends AppCompatActivity {
    Boolean save = false;


    Button btnNew,btnContinue, btnAbout,btnEx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnNew = (Button)findViewById(R.id.buttonNewGame);
        btnContinue = (Button)findViewById(R.id.buttonContinue);
        btnAbout = (Button)findViewById(R.id.buttonAbt);
        btnEx = (Button)findViewById(R.id.buttonExit);


        btnNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent newGame = new Intent(MainMenu.this,difficultyLevels.class);
                startActivity(newGame);
            }
        });

        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cont = new Intent(MainMenu.this,gameScreen.class);
                startActivity(cont);

            }
        });

        btnAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent abt = new Intent(MainMenu.this,gameRulesUI.class);
                startActivity(abt);
            }
        });

        btnEx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
