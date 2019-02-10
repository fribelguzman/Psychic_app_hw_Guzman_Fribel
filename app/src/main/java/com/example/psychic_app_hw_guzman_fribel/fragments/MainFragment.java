package com.example.psychic_app_hw_guzman_fribel.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.example.psychic_app_hw_guzman_fribel.NavigationInterface;
import com.example.psychic_app_hw_guzman_fribel.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MainFragment extends Fragment implements AdapterView.OnItemSelectedListener {
    private View rootView;
    private Spinner spinner;
    private List<Integer> photos;
    private Button submit;
    private static NavigationInterface mListener;
    private int selectedPosition;

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
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        submit = rootView.findViewById(R.id.submit_button);
        spinner = rootView.findViewById(R.id.spinner_theme);
        setSpinner();

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (selectedPosition) {
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
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_main, container, false);
        return rootView;
    }

    private void setSpinner() {
        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(rootView.getContext(), R.array.theme_array, android.R.layout.simple_spinner_dropdown_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        selectedPosition = position;
    }


    @Override
    public void onNothingSelected(AdapterView<?> parent) {
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
}