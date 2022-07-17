package com.amila.interview.string;

import java.util.Arrays;

public class Main
{
    public static void main( String[] args )
    {
        String input = "**|***|*|**|***|";

        char[] array = input.toCharArray();
        int [] flags = new int[array.length];

        boolean started = false;

        int masterCounter = 0;
        int counter = 0;

        int i = 0;
        for( char c : array )
        {
            if( c == '|' )
            {
                started = true;
                masterCounter += counter;
                counter = 0;
            }
            if( started && c == '*' )
            {
                flags[i] = 1;
                counter++;
            }
//            flags[i] = masterCounter;
            i++;
        }

        System.out.println(Arrays.toString( array ));
        System.out.println(Arrays.toString( flags ));

    }
}
