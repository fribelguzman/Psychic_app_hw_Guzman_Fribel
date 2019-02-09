package com.example.psychic_app_hw_guzman_fribel;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MainFragment extends Fragment implements AdapterView.OnItemSelectedListener {
    private View rootView;
    private Spinner spinner;
    private List<Integer> photos;

    private NavigationInterface mListener;

    public MainFragment() {

    }

    public static MainFragment newInstance() {
        MainFragment fragment = new MainFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



        rootView = inflater.inflate(R.layout.fragment_main, container, false);

        spinner = rootView.findViewById(R.id.theme_spinner);


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(),
                R.array.theme_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);


        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        return rootView;


    }


    public void onButtonPressed(Uri uri) {

    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof NavigationInterface) {
            mListener = (NavigationInterface) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (position) {

            case 0:
                photos = Arrays.asList(R.drawable.dali1, R.drawable.dali2, R.drawable.dali3, R.drawable.dali4);
                mListener.showChoiceFragment(photos);

                break;

            case 1:
                photos = Arrays.asList(R.drawable.kush1, R.drawable.kush2, R.drawable.kush3, R.drawable.kush4);
                mListener.showChoiceFragment(photos);
                break;

            case 2:
                photos = Arrays.asList(R.drawable.loli1, R.drawable.loli2, R.drawable.loli3, R.drawable.loli4);
                mListener.showChoiceFragment(photos);
                break;

        }


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


}



