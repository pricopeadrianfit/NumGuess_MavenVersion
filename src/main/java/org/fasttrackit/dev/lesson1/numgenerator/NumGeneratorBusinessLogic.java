package org.fasttrackit.dev.lesson1.numgenerator;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by condor on 29/11/14.
 * FastTrackIT, 2015
 */


/* didactic purposes

Some items are intentionally not optimized or not coded in the right way

FastTrackIT 2015

*/

public class NumGeneratorBusinessLogic {

    private static final int MAX_NUMBER = 6;

    private boolean isFirstTime = true;
    private boolean successfulGuess;
    private int numberOfGuesses;
    private int generatedNumber;
    private String hint;
    long start;
    long finish;
    double elapsedTime;
    SimpleDateFormat sdf;
    String serverTime;

    public NumGeneratorBusinessLogic(){
        resetNumberGenerator();
    }

    public boolean getSuccessfulGuess(){
        return successfulGuess;
    }

    public String getHint(){
        return hint;
    }

    public double getElapsedTime(){
        return elapsedTime;
    }

    public int getNumGuesses(){
        return numberOfGuesses;
    }

    public String getServerTime() {
        return serverTime;

    }

    public boolean isFirstTime(){
        return isFirstTime;
    }

    public void resetNumberGenerator(){
        isFirstTime = true;
        numberOfGuesses = 0;
        long start =0;
        long finish;
        hint = "";
        elapsedTime=0;


    }

    public boolean determineGuess(int guessNumber ){
        if (isFirstTime) {
            generatedNumber = NumGenerator.generate(MAX_NUMBER);
            System.out.println("gennr:"+generatedNumber);
            isFirstTime = false;
          start=System.currentTimeMillis();
        }
        numberOfGuesses++;


    if (guessNumber == generatedNumber) {
        hint = "";
        successfulGuess = true;
        finish = System.currentTimeMillis();
        elapsedTime = (finish - start) / 1000;

        Calendar cal = Calendar.getInstance();
        sdf = new SimpleDateFormat("HH:mm");
       serverTime= sdf.format(cal.getTime());

    } else if (guessNumber < generatedNumber) {
        hint = "higher";
        successfulGuess = false;
    } else if (guessNumber > generatedNumber) {
        hint = "lower";
        successfulGuess = false;
    }
    return successfulGuess;

    }

}