package com.backspace.teenpatti.utilities;

import android.content.Context;
import android.widget.Toast;

import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

/**
 * Created by Backspace on 11/18/2016.
 */
public class RandomGenerator {
    public static Set<Integer> generated;
    private static final int NUMBER_NEDDED=12;
    private static final int MAX=52;
    private static Context context;

    public RandomGenerator(Context context) {
        this.context = context;

    }

    public static int getRandomIndex(){
        int number=0;
        if(!generated.isEmpty()){
            number=generated.iterator().next();
            generated.remove(generated.iterator().next());
        }
        return number;
    }
    public static void generate(){
        Random rng = new Random(); // Ideally just create one instance globally
        // Note: use LinkedHashSet to maintain insertion order
        generated = new LinkedHashSet<Integer>();
        while(generated.size() < NUMBER_NEDDED){
            Integer next = rng.nextInt(MAX);
            // As we're adding to a set, this will automatically do a containment check
            generated.add(next);
        }
    }

}

