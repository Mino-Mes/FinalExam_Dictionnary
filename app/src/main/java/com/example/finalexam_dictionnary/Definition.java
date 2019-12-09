package com.example.finalexam_dictionnary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.finalexam_dictionnary.model.Word;
import com.google.gson.Gson;

public class Definition extends AppCompatActivity {

    private TextView wordTV;
    private TextView definitionTV;
    private TextView posTV;
    private Word w;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_definition);
        wordTV=findViewById(R.id.NameWord);
        definitionTV=findViewById(R.id.wordDefinition);
        posTV=findViewById(R.id.wordPos);

        Bundle bundle=getIntent().getExtras();

        if(bundle !=null)
        {
            Gson gson= new Gson();
            String wordAsString =bundle.getString("wordAsString");
            w=gson.fromJson(wordAsString,Word.class);

            wordTV.setText(w.getWord());
            posTV.setText(w.getPos());
            definitionTV.setText(w.getDefinition());
        }

    }
}
