package com.amila.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class SumOfTwo
{
    public static void main( String[] args )
    {
        int[] array = { 4, 3, 1, 5, 6, 2, 9, 7, 8 };

        int sum = 14;

        HashSet<Integer> set = new HashSet<>();
        List<int[]> output = new ArrayList<>();

        for( int n : array )
        {
            if( set.contains( sum - n ) )
            {
                output.add( new int[] { n, sum - n } );
            }
            set.add( n );
        }

        output.forEach( ints -> System.out.println( Arrays.toString( ints ) ) );

    }
}
