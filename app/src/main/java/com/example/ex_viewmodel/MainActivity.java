package com.example.ex_viewmodel;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView viewScore;
    TextView viewReset;
    TextView view;
    CustomModel model;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        view = findViewById(R.id.txt_view);

        viewReset=findViewById(R.id.reset_score);
        viewScore=findViewById(R.id.add_score);


        /**
         * It should be noted that we did not set the data in viewscore.Observer will taken care of that
         */
        //   view.setText(model.getData().toString());

        viewScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addScore();
            }
        });
        viewReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetScore();
            }
        });

        model=new ViewModelProvider(this).get(CustomModel.class);
        //Below codes are implemented while using LiveDta
        //not require when are implementing ViewModel only
        model.getData().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                view.setText(String.valueOf(integer));
            }
        });



    }

    private void resetScore() {
        model.resetScore();
        // we don setText again in this resetScore as Observer will taken care of it
      //  view.setText(model.getData().toString());
    }

    private void addScore() {
      model.addScore();
   //   view.setText(model.getData().toString());

    }
}