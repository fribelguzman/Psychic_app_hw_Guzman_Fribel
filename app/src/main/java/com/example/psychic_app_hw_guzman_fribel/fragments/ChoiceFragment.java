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

import com.example.psychic_app_hw_guzman_fribel.NavigationInterface;
import com.example.psychic_app_hw_guzman_fribel.R;

import java.util.ArrayList;
import java.util.List;


public class ChoiceFragment extends Fragment {
    private View rootView;

    private static List<Integer> photos;
    private ImageView image1;
    private ImageView image2;
    private ImageView image3;
    private ImageView image4;

    private static List<ImageView> images;
    private static NavigationInterface mListener;

    public ChoiceFragment() {

    }

    public static ChoiceFragment newInstance(List<Integer> listOfDrawables) {
        ChoiceFragment fragment = new ChoiceFragment();
        photos = listOfDrawables;
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_choice, container, false);
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        image1 = rootView.findViewById(R.id.image1);
        image2 = rootView.findViewById(R.id.image2);
        image3 = rootView.findViewById(R.id.image3);
        image4 = rootView.findViewById(R.id.image4);

        image1.setImageDrawable(getResources().getDrawable(photos.get(0)));
        image2.setImageDrawable(getResources().getDrawable(photos.get(1)));
        image3.setImageDrawable(getResources().getDrawable(photos.get(2)));
        image4.setImageDrawable(getResources().getDrawable(photos.get(3)));

        images= new ArrayList<>();
       images.add(image1);
        images.add(image2);
        images.add(image3);
        images.add(image4);

rootView.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        mListener.showResultFragment();
    }
});

}

            @Override
            public void onDetach() {
                super.onDetach();
                mListener = null;
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
}