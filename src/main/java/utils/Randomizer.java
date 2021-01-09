package utils;

import java.util.Random;

public class Randomizer {
    private Random r = new Random();
    public int[] giveRandom(int low,int high,int count)
    {

        int[] a=new int[count];
        for(int i = 0; i < a.length; i++)
        {
            a[i] = r.nextInt(high-low) + low;
        }
        return a;
    }
}
