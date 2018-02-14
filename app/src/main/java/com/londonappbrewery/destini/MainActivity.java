package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    private TextView mStory;
    private Button mButtonTop;
    private Button mButtonBottom;

    // Will hold the possible paths
    private HashMap<Integer, Level> mPath;

    // Holds the current story id
    private int mCurrentStory;

    // Holds all the possible endings
    private ArrayList<Integer> endings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        mStory = (TextView) findViewById(R.id.storyTextView);
        mButtonTop = (Button) findViewById(R.id.buttonTop);
        mButtonBottom = (Button) findViewById(R.id.buttonBottom);

        mCurrentStory = R.string.T1_Story;
        mPath = new HashMap<Integer, Level>();

        // Create and populate the array for the endings
        endings = new ArrayList<Integer>(3);
        endings.add(R.string.T4_End);
        endings.add(R.string.T5_End);
        endings.add(R.string.T6_End);

        // Level T1
        mPath.put(
            R.string.T1_Story,
            new Level(R.string.T1_Ans1, R.string.T1_Ans2, R.string.T3_Story, R.string.T2_Story)
        );

        // Level T2
        mPath.put(
            R.string.T2_Story,
            new Level(R.string.T2_Ans1, R.string.T2_Ans2, R.string.T3_Story, R.string.T4_End)
        );

        // Level T3
        mPath.put(
            R.string.T3_Story,
            new Level(R.string.T3_Ans1, R.string.T3_Ans2, R.string.T6_End, R.string.T5_End)
        );

        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        mButtonTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCurrentStory = mPath.get(mCurrentStory).getPath1();
                changeLevel(mPath.get(mCurrentStory));
            }
        });

        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        mButtonBottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCurrentStory = mPath.get(mCurrentStory).getPath2();
                changeLevel(mPath.get(mCurrentStory));
            }
        });

    }

    private void changeLevel(Level level) {
        mStory.setText(mCurrentStory);
        // If the current story is one of the endings then
        // hide the buttons
        if (endings.contains(mCurrentStory)) {
            mButtonTop.setVisibility(View.GONE);
            mButtonBottom.setVisibility(View.GONE);
        } else {
            mButtonTop.setText(level.getAns1());
            mButtonBottom.setText(level.getAns2());
        }
    }
}
