package com.example.finalexam_dictionnary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.finalexam_dictionnary.model.Word;
import com.google.gson.Gson;

public class French extends AppCompatActivity {

    private TextView englishWordTV;
    private TextView frenchWordTV;
    private Word w;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_french);

        englishWordTV = findViewById(R.id.englishWord);
        frenchWordTV = findViewById(R.id.frenchWord);

        Bundle bundle = getIntent().getExtras();

        if (bundle != null) {
            Gson gson = new Gson();
            String wordAsString = bundle.getString("wordAsString");
            w = gson.fromJson(wordAsString, Word.class);

            englishWordTV.setText(w.getWord());
            frenchWordTV.setText(w.getFrench());
        }
    }
}
