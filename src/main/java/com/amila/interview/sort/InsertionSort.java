package com.amila.interview.sort;

import java.util.Arrays;

/**
 * Worst Case: O(N^2)
 * Time Complexity: O(1)
 */
public class InsertionSort implements IntegerSortingAlgorithm
{

    @Override
    public int sort( int[] array )
    {
        int iterations = 0;

        for( int i = 0; i < array.length - 1; i++ )
        {
            System.out.println( Arrays.toString( array ) );
            int j = i + 1;
            int key = array[j];

            while( j > 0 && array[j - 1] > key )
            {
                array[j] = array[j - 1];
                j--;
            }
            array[j] = key;

            iterations++;
        }

        return iterations;
    }

    @Override
    public String name()
    {
        return "Insertion Sort";
    }
}
