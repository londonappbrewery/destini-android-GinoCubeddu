package com.londonappbrewery.destini;

/**
 * Created by Gino on 14/02/2018.
 */

public class Level {
    // Variables to hold the id's for the answers
    private int mAns1;
    private int mAns2;

    // Variables to hold the id's for the next level/path
    private int mPath1;
    private int mPath2;

    // Constructor
    public Level(int ans1, int ans2, int path1, int path2) {
        mAns1 = ans1;
        mAns2 = ans2;
        mPath1 = path1;
        mPath2 = path2;
    }

    // Returns the ID for the first answer
    public int getAns1() {
        return mAns1;
    }

    // Returns the ID for the second answer
    public int getAns2() {
        return mAns2;
    }

    // Returns the ID for the path to which the first answer leads
    public int getPath1() {
        return mPath1;
    }

    // Returns the ID for the path to which the second answer leads
    public int getPath2() {
        return mPath2;
    }
}
