package com.amila.interview.array;

import java.util.HashMap;
import java.util.Map;

public class OddOccurrences
{
    public static void main( String[] args )
    {
        int[] array = { 9, 3, 9, 3, 9, 7, 9 };


        int odd = findOddOccurredValue( array );

        System.out.println( odd );
    }

    private static int findOddOccurredValue( int[] array )
    {
        Map<Integer, Integer> map = new HashMap<>();

        for( int a : array )
        {
            if( !map.containsKey( a ) )
            {
                map.put( a, 1 );
            }
            else
            {
                map.put( a, map.get( a ) + 1 );
            }
        }
        int output = 0;

        for( Integer key : map.keySet() )
        {
            if( map.get( key ) % 2 != 0 )
            {
                output = key;
                break;
            }
        }
        return output;
    }


}
