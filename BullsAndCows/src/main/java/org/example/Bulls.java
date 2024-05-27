package org.example;

import java.util.Arrays;
import java.util.Random;

public class Bulls {
    private final int length;
    private int[] bulls;
    public int[] getBulls(){
        return bulls;
    }

    private final boolean isUnique;

    public Bulls(int length, boolean isUnique){
        this.length = length;
        this.isUnique = isUnique;
        generateBulls();
    }

    public Bulls(int[] bulls, boolean isUnique){
        length = bulls.length;
        this.isUnique = isUnique;
        this.bulls = bulls;
    }

    private void generateBulls(){
        Random random = new Random();
        bulls = new int[length];
        for(int i = 0; i < length; i++){
            int nextInt = random.nextInt(10);
            if(isUnique){
                while(true){
                    int finalNextInt = nextInt;
                    boolean b = Arrays.stream(bulls).anyMatch(x -> x == finalNextInt);
                    if(b)
                        nextInt = random.nextInt(10);
                    else
                        break;
                }
            }
            bulls[i] = nextInt;
        }
    }
}
