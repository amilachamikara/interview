package com.amila.interview.array;

import java.util.Arrays;

public class Rotate
{
    public static void main( String[] args )
    {
        int[] array = { 3, 2, 1, 6, 9 };
        int k = 3;

        System.out.println( Arrays.toString( array ) + ", k=" + k );

        rotate( array, k );

        System.out.println( Arrays.toString( array ) );
    }

    private static void rotate( int[] array, int k )
    {
        while( k > 0 )
        {
            int temp = 0;
            for( int i = array.length - 1; i > 0; i-- )
            {
                if( i == array.length - 1 )
                {
                    temp = array[i];
                }
                array[i] = array[i - 1];
                if( i == 1 )
                {
                    array[0] = temp;
                }
            }
            k--;
        }

    }
}
