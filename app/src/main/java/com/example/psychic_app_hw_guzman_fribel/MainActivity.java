package com.example.psychic_app_hw_guzman_fribel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.psychic_app_hw_guzman_fribel.fragments.ChoiceFragment;
import com.example.psychic_app_hw_guzman_fribel.fragments.MainFragment;

import java.util.List;

public class MainActivity extends AppCompatActivity implements NavigationInterface {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainFragment mainFragment = MainFragment.newInstance();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.main_container, mainFragment)
                .addToBackStack("next")
                .commit();
    }

    @Override
    public void showChoiceFragment(List<Integer> listOfDrawables) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.main_container, ChoiceFragment.newInstance(listOfDrawables))
                .addToBackStack("choice")
                .commit();


    }

    @Override
    public void showResultFragment(int choice, int correct) {

    }
}
