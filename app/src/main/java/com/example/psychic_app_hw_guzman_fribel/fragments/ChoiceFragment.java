package com.example.psychic_app_hw_guzman_fribel.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.psychic_app_hw_guzman_fribel.NavigationInterface;
import com.example.psychic_app_hw_guzman_fribel.R;

import java.util.List;


public class ChoiceFragment extends Fragment {
    private View rootView;

    private static List<Integer> photos;
    private ImageView image1;
    private ImageView image2;
    private ImageView image3;
    private ImageView image4;


    private NavigationInterface mListener;

    public ChoiceFragment() {

    }

    public static ChoiceFragment newInstance(List<Integer> listOfDrawables) {
        ChoiceFragment fragment = new ChoiceFragment();

        photos = listOfDrawables;



        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

            image1 = rootView.findViewById(R.id.image1);
            image2 = rootView.findViewById(R.id.image2);
            image3 = rootView.findViewById(R.id.image3);
            image4 = rootView.findViewById(R.id.image4);

            image1.setImageDrawable(getResources().getDrawable(photos.get(0)));
            image2.setImageDrawable(getResources().getDrawable(photos.get(1)));
            image3.setImageDrawable(getResources().getDrawable(photos.get(2)));
            image1.setImageDrawable(getResources().getDrawable(photos.get(0)));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_main, container, false);
        return rootView;
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
