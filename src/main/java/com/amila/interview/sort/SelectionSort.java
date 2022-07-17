package com.amila.interview.sort;

import java.util.Arrays;

/**
 *
 * Find minimum from unvisited values and put in current location and move forward
 *
 * Worst Case:
 * Time Complexity = O(N^2)
 * Space Complexity = O(1)
 * <p>
 * Best Case:
 * Time Complexity = O(N)
 */
public class SelectionSort implements IntegerSortingAlgorithm
{
    public int sort( int[] input )
    {
        int iterations = 0;

        for( int i = 0; i < input.length; i++ )
        {
            System.out.println( Arrays.toString( input ) );
            int minIndex = i;
            for( int j = i + 1; j < input.length; j++ )
            {
                if( input[j] < input[minIndex] )
                    minIndex = j;
                iterations++;
            }
            shift( input, i, minIndex );
        }
        return iterations;
    }

    @Override
    public String name()
    {
        return "Selection Sort";
    }

    /**
     * Not Stable
     */
    private static void swap( int[] array, int a, int b )
    {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    /**
     * Stable
     */
    private static void shift( int[] array, int currentIndex, int minIndex )
    {
        int temp = array[minIndex];
        while( minIndex > currentIndex )
        {
            array[minIndex] = array[minIndex - 1];
            minIndex--;
        }
        array[currentIndex] = temp;
    }
}
