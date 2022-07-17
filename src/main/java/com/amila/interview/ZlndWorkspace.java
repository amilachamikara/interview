package com.amila.interview;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ZlndWorkspace
{
    public static void main( String[] args )
    {
//        int[] array = { 1, 3, 2, 1, 2, 1, 5, 3, 3, 4, 2 };
//        int[] array = { 5, 8 };
//        String[] array = { "039", "4", "14", "32", "34", "7" };
        String[] array = { "801234567", "180234567", "0", "189234567", "891234567", "98", "9" };
//        System.out.println( solution( array ) );
//        System.out.println("1".toCharArray()[0] == '1');
        System.out.println( solution( array ) );
    }

    static int solution( int[] A )
    {
        int strokes = 0;

        while( true )
        {
            int count = 0;
            int edits = 0;
            for( int i = 0; i < A.length - 1; i++ )
            {
                if( A[i] == 0 && A[i + 1] > 0 )
                {
                    count++;
                }
                if( A[i] != 0 )
                {
                    edits++;
                    A[i] -= 1;
                }
                if( count == 0 && edits > 0 )
                {
                    count++;
                }
                if( i == A.length - 2 && A[A.length - 1] != 0 )
                {
                    edits++;
                    A[A.length - 1] -= 1;
                }
            }

            if( edits == 0 )
            {
                break;
            }
            strokes += count;


        }
        if( strokes > 1000000000 )
        {
            return -1;
        }
        return strokes;
    }

    static int solution( String[] E )
    {

        Map<Integer,Set<Integer>> map = new HashMap<>();

        int empNo = 0;
        for( String e : E )
        {
            for( int i = 0; i < e.length(); i++ )
            {
                int day = Integer.parseInt( Character.toString( e.charAt( i ) ) );
                if( !map.containsKey( day ) )
                {
                    map.put( day, new HashSet<>() );
                }
                map.get( day ).add( empNo );
            }
            empNo++;
        }

        int max = 0;

        for( Map.Entry<Integer,Set<Integer>> i : map.entrySet() )
        {
            for( Map.Entry<Integer,Set<Integer>> j : map.entrySet() )
            {
                if( !i.getKey().equals( j.getKey() ) )
                {
                    Set<Integer> temp = new HashSet<>();
                    temp.addAll( i.getValue() );
                    temp.addAll( j.getValue() );
                    if( temp.size() > max )
                    {
                        max= temp.size();
                    }
                }
            }
        }

        return max;
    }
}
