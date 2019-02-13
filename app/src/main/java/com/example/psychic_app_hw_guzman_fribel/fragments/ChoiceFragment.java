package com.example.psychic_app_hw_guzman_fribel.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.psychic_app_hw_guzman_fribel.NavigationInterface;
import com.example.psychic_app_hw_guzman_fribel.R;
import com.example.psychic_app_hw_guzman_fribel.database.GuessDatabaseHelper;

import java.util.List;
import java.util.Random;

public class ChoiceFragment extends Fragment implements View.OnClickListener {
    private static NavigationInterface listener;
    private static List<Integer> photos;
    //be more specific so you can identify things later on
    private ImageView imageView;
    private ImageView imageView2;
    private ImageView imageView3;
    private ImageView imageView4;
    private int userChoice;
    private int cpuChoice;


    public ChoiceFragment() {

    }

    public static ChoiceFragment newInstance(List<Integer> listOfDrawables) {
        ChoiceFragment fragment = new ChoiceFragment();
        photos = listOfDrawables;
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //get a random choice
        cpuChoice = new Random().nextInt(photos.size() - 1);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_choice, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        imageView = view.findViewById(R.id.image1);
        imageView2 = view.findViewById(R.id.image2);
        imageView3 = view.findViewById(R.id.image3);
        imageView4 = view.findViewById(R.id.image4);

        imageView.setImageDrawable(getResources().getDrawable(photos.get(0)));
        imageView2.setImageDrawable(getResources().getDrawable(photos.get(1)));
        imageView3.setImageDrawable(getResources().getDrawable(photos.get(2)));
        imageView4.setImageDrawable(getResources().getDrawable(photos.get(3)));

        imageView.setOnClickListener(this);
        imageView2.setOnClickListener(this);
        imageView3.setOnClickListener(this);
        imageView4.setOnClickListener(this);
    }

    //nice
    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof NavigationInterface) {
            listener = (NavigationInterface) context;
        } else {
            throw new RuntimeException(context.toString()
                    + "Parent must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.image1:
                //assign the user's choice
                userChoice = 0;
                break;
            case R.id.image2:
                userChoice = 1;
                break;
            case R.id.image3:
                userChoice = 2;
                break;
            case R.id.image4:
                userChoice = 3;
                break;
        }
        //pass both choices to the ResultFragment
        listener.showResultFragment(cpuChoice, userChoice);
    }
}