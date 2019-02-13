package com.example.psychic_app_hw_guzman_fribel.database;

//this is where things can start to go wrong and you can confuse yourself further. We have to think about what data is relevant so we can model our data classes as best we can. What data does your database need? How can you identify the appropriate data and how can you create your database to be easier to use? Since a choice can be either right or wrong, a guess should just consist of one value. If we're not gonna use anything else then we don't need any other information about the option chosen.
public class GuessModel {
    private int guess;

    public GuessModel(int guess) {
        this.guess = guess;
    }

    public int guess() {
        return guess;
    }
}

