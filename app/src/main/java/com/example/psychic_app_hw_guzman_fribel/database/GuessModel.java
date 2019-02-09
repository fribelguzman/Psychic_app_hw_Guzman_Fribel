package com.example.psychic_app_hw_guzman_fribel.database;

public class GuessModel {
    private String chosen;
    private int guessedRight;
    private int guessedWrong;

    public String getchosen() {
        return chosen;
    }

    public void setchosen(String chosen) {
        this.chosen = chosen;
    }

    public int getGuessedRight() {
        return guessedRight;
    }

    public void setGuessedRight(int guessesRight) {
        this.guessedRight = guessedRight;
    }

    public int getGuessedWrong() {
        return guessedWrong;
    }

    public void setGuessedWrong(int guessedWrong) {
        this.guessedWrong = guessedWrong;
    }
}

