package com.example.peter.coffeejournal;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;

import java.util.ArrayList;


public class BrewFragment extends Fragment {


    private OnFragmentInteractionListener mListener;
    private FloatingActionButton addBrewButton;
    private GridView gv;
    private DBOperator mDBOperator;
    private BrewAdapter ba;
    private ArrayList<BrewRecipe> brewRecipeArrayList;

    public BrewFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static BrewFragment newInstance(String param1, String param2) {
        BrewFragment fragment = new BrewFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_brew, container, false);
        gv = (GridView) rootView.findViewById(R.id.brew_grid_view);
        mDBOperator = new DBOperator(this.getContext());
        brewRecipeArrayList = mDBOperator.getBrewRecipes();
        ba = new BrewAdapter(rootView.getContext(), brewRecipeArrayList);
        gv.setAdapter(ba);
        return rootView;


    }



    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
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

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }



}
