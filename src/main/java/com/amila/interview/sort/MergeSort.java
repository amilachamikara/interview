package com.amila.interview.sort;

import java.util.Arrays;

/**
 * Worst Case:
 * Time Complexity: O(NlogN)
 * Space Complexity: O(N)
 */
public class MergeSort implements IntegerSortingAlgorithm
{
    @Override
    public int sort( int[] array )
    {
        int iterations = 0;

        divideAndMerge( array, 0, array.length - 1 );


        return iterations;
    }

    private static void divideAndMerge( int[] array, int l, int r )
    {
        if( l < r )
        {
            int m = l + ( r - l ) / 2;
            divideAndMerge( array, l, m );
            divideAndMerge( array, m + 1, r );
            merge( array, l, m, r );
        }
    }

    private static void merge( int[] array, int l, int m, int r )
    {
        int[] L = Arrays.copyOfRange( array, l, m + 1 );
        int[] R = Arrays.copyOfRange( array, m + 1, r + 1 );

        int x = 0, y = 0;
        int i = l;
        while( x < L.length && y < R.length )
        {
            if( L[x] < R[y] )
            {
                array[i] = L[x];
                x++;
            }
            else
            {
                array[i] = R[y];
                y++;
            }
            i++;
        }

        while( x < L.length )
        {
            array[i] = L[x];
            i++;
            x++;
        }
        while( y < R.length )
        {
            array[i] = L[y];
            i++;
            y++;
        }
    }


    @Override
    public String name()
    {
        return "Merge Sort";
    }
}
