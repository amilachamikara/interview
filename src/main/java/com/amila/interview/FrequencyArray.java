package com.amila.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class FrequencyArray
{
    public static void main( String[] args )
    {
        System.out.println( countingSort( Arrays.asList( 1, 1, 3, 2, 1 ) ) );
    }

    public static List<Integer> countingSort( List<Integer> arr )
    {
        arr = Arrays.stream( "63 54 17 78 43 70 32 97 16 94 74 18 60 61 35 83 13 56 75 52 70 12 24 37 17 0 16 64 34 81 82 24 69 2 30 61 83 37 97 16 70 53 0 61 12 17 97 67 33 30 49 70 11 40 67 94 84 60 35 58 19 81 16 14 68 46 42 81 75 87 13 84 33 34 14 96 7 59 17 98 79 47 71 75 8 27 73 66 64 12 29 35 80 78 80 6 5 24 49 82".split( " " ) )
                .map( Integer::parseInt ).collect( Collectors.toList());


        int max = Integer.MIN_VALUE;

        for( int i : arr )
        {
            if( i > max )
            {
                max = i;
            }
        }

        List<Integer> fq = new ArrayList<>( Collections.nCopies( max+1, 0 ) );

        for( int i = 0; i < arr.size(); i++ )
        {
            fq.set( arr.get( i ), fq.get( arr.get( i ) ) == 0 ? 1 : fq.get( arr.get( i ) ) + 1 );
        }
        return fq;
    }
}
