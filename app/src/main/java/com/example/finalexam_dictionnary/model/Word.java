package com.example.finalexam_dictionnary.model;

public class Word {
    private String word;
    private String pos;
    private String definition;
    private String french;

    public Word(String word, String pos, String definition, String french) {
        this.word = word;
        this.pos = pos;
        this.definition = definition;
        this.french = french;
    }

    public Word() {
    }


    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public String getFrench() {
        return french;
    }

    public void setFrench(String french) {
        this.french = french;
    }
}
