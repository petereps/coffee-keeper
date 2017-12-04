package com.example.peter.coffeejournal;

import android.animation.ObjectAnimator;
import android.app.Fragment;
import android.content.Intent;
import android.os.CountDownTimer;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.text.DecimalFormat;

public class BrewRecipeActivity extends AppCompatActivity implements BrewRecipeFragment.SendBrew {

    private BrewRecipe br;
    DBOperator db;
    private int waterUnits = 16;
    TextView waterWeightTv, coffeeWeightTv, grindTv, strengthTv, textTimer, stepTv;
    CountDownTimer countDownTimer;
    ProgressBar barTimer;
    Button startButton;
    int bloomMinutes, bloomSeconds, brewSeconds;
    boolean brewFinished;

    private SectionsPageAdapter mSectionsPageAdapter;
    private ViewPager mViewPager;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String name = "Test";
        name = getIntent().getExtras().getString("Brew Name");
        ActionBar ab = getSupportActionBar();
        ab.setTitle(name);
        ab.setElevation(0);
        setContentView(R.layout.activity_brew_recipe);
        mSectionsPageAdapter = new SectionsPageAdapter(getSupportFragmentManager());
        mViewPager = findViewById(R.id.container2);
        setupViewPager(mViewPager);

        TabLayout tabLayout = findViewById(R.id.tabs2);
        tabLayout.setupWithViewPager(mViewPager);


    }


    public void updateView(){

    }


    private void setupViewPager(ViewPager viewPager){
        SectionsPageAdapter adapter = new SectionsPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new BrewRecipeFragment(), "Recipe");
        adapter.addFragment(new BrewNotesFragment(), "Notes" );
        viewPager.setAdapter(adapter);
    }

    public void update(){
        Intent intent = getIntent();
        finish();
        startActivity(intent);
    }

    @Override
    public void sendBrewRecipe(BrewRecipe brew) {
        String notes = brew.getNotes();
        BrewNotesFragment bn = (BrewNotesFragment) getSupportFragmentManager().getFragments().get(1);
        bn.setNotes(notes);
    }
}
