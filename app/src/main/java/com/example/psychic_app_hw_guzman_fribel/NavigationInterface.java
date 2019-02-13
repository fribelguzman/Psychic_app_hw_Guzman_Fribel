package com.example.psychic_app_hw_guzman_fribel;

import java.util.List;

public interface NavigationInterface {
    void showChoiceFragment(List<Integer> listOfDrawables);
    //add these parameters to pass over to the MainActivity
    void showResultFragment(int cpuChoice, int userChoice);
}
