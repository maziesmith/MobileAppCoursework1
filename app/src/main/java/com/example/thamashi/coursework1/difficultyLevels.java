package com.example.thamashi.coursework1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class difficultyLevels extends AppCompatActivity {

    Button novice,easy,medium,guru;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        novice = (Button)findViewById(R.id.btnNovice);
        easy = (Button)findViewById(R.id.btnEasy);
        medium = (Button)findViewById(R.id.btnMedium);
        guru = (Button)findViewById(R.id.btnGuru);

        Intent i = this.getIntent();

        novice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent game = new Intent(difficultyLevels.this,gameScreen.class);
                game.putExtra("levelname","NOVICE");
                startActivity(game);

            }
        });

        easy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent game2 = new Intent(difficultyLevels.this,gameScreen.class);
                game2.putExtra("levelname","EASY");
                startActivity(game2);

            }
        });

        medium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent game3 = new Intent(difficultyLevels.this,gameScreen.class);
                game3.putExtra("levelname","MEDIUM");
                startActivity(game3);

            }
        });

        guru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent game4 = new Intent(difficultyLevels.this,gameScreen.class);
                game4.putExtra("levelname","GURU");
                startActivity(game4);

            }
        });


    }
}
