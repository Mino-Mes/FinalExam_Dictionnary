package com.example.finalexam_dictionnary.data;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.finalexam_dictionnary.controller.AppController;
import com.example.finalexam_dictionnary.model.Word;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class WordBank {
    ArrayList<Word> wordArrayList = new ArrayList<>();
    final private String URL = "https://my-json-server.typicode.com/cgerard321/dictionary/dictionary/";
    AppController ac = new AppController();

    public List<Word> getWords(final WordInterface callback) {
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(
                Request.Method.GET,
                URL,
                null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try {
                            for (int i = 0; i < response.length(); i++) {
                                JSONObject word = response.getJSONObject(i);
                                Word w = new Word();
                                w.setWord(word.getString("word"));
                                w.setPos(word.getString("pos"));
                                w.setDefinition(word.getString("definition"));
                                w.setFrench(word.getString("french"));
                                wordArrayList.add(w);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        if (null != callback) {
                            callback.processFinished(wordArrayList);
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        ac.getInstance().addToRequestQueue(jsonArrayRequest);

        return wordArrayList;
    }
}


