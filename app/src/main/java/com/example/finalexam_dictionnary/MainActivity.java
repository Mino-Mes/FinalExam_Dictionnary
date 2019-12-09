package com.example.finalexam_dictionnary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.finalexam_dictionnary.adapter.RecyclerViewAdapter;
import com.example.finalexam_dictionnary.data.WordBank;
import com.example.finalexam_dictionnary.data.WordInterface;
import com.example.finalexam_dictionnary.model.Word;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

   private RecyclerView rv;
   private RecyclerViewAdapter rva;
   private List<Word> wordList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wordList=new WordBank().getWords(new WordInterface() {
            @Override
            public void processFinished(ArrayList<Word> wordArrayList) {
                rv=findViewById(R.id.recyclerView);
                rv.setHasFixedSize(true);
                rv.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                rva=new RecyclerViewAdapter(MainActivity.this,wordList);
                rv.setAdapter(rva);

                rva.setOnItemClickListener(new RecyclerViewAdapter.onButtonClickListener() {
                    @Override
                    public void onClickDefinition(int position) {
                        Word w= wordList.get(position);
                        Gson gson = new Gson();
                        String wordAsString=gson.toJson(w);

                        Intent intent= new Intent(MainActivity.this, Definition.class);
                        intent.putExtra("wordAsString",wordAsString);
                        startActivity(intent);
                    }

                    @Override
                    public void onClickTranslate(int position) {
                        Word w= wordList.get(position);
                        Gson gson = new Gson();
                        String wordAsString=gson.toJson(w);

                        Intent intent= new Intent(MainActivity.this, French.class);
                        intent.putExtra("wordAsString",wordAsString);
                        startActivity(intent);
                    }
                });
            }
        });
    }
}
