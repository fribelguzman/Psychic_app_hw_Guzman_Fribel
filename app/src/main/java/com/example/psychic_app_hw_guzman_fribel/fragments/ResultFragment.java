package com.example.psychic_app_hw_guzman_fribel.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.psychic_app_hw_guzman_fribel.NavigationInterface;
import com.example.psychic_app_hw_guzman_fribel.R;
import com.example.psychic_app_hw_guzman_fribel.database.GuessDatabaseHelper;
import com.example.psychic_app_hw_guzman_fribel.database.GuessModel;


public class ResultFragment extends Fragment {
    private static int cpuChoice;
    private static int userChoice;
    private GuessDatabaseHelper guessDatabase;

    public ResultFragment() {

    }

    public static ResultFragment newInstance(int randomChoice, int usersChoice) {
        ResultFragment fragment = new ResultFragment();
        Bundle arguments = new Bundle();
        //add these choices to the arguments for our fragment
        arguments.putInt("user_choice", usersChoice);
        arguments.putInt("cpu_choice", randomChoice);
        fragment.setArguments(arguments);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            //get the choices from the arguments bundle
            userChoice = getArguments().getInt("user_choice");
            cpuChoice = getArguments().getInt("cpu_choice");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_result, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //compare the choices
        if (userChoice == cpuChoice) {
            //if it's right we add a new GuessModel object with a value of 1 for correct
            guessDatabase.addChoice(new GuessModel(1));
            //set the textview text by using String arguments in your string.xml value
            ((TextView) view.findViewById(R.id.result_text)).setText(getString(R.string.result_text, guessDatabase.calculatePercentage(), " % right!"));
        } else {
            //if it's wrong we add a new GuessModel object with a value of 0 for wrong
            guessDatabase.addChoice(new GuessModel(0));
            ((TextView) view.findViewById(R.id.result_text)).setText(getString(R.string.result_text, guessDatabase.calculatePercentage() , " % wrong!"));
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        //get an instance of your Database with this context
        guessDatabase = GuessDatabaseHelper.getInstance(context);
    }
}
