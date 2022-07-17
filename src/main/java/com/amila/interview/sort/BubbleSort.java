package com.amila.interview.sort;

import java.util.Arrays;

/**
 * Compare and swap
 *
 * Worst case:
 * Time Complexity: O(N^2)
 * Space Complexity: O(1)
 */
public class BubbleSort implements IntegerSortingAlgorithm
{
    public int sort( int[] array )
    {
        int iterations = 0;
        for( int i = 0; i < array.length; i++ )
        {
            boolean swap = false;
            for( int j = 0; j < array.length - ( i + 1 ); j++ )
            {
                if( array[j] > array[j + 1] )
                {
                    SortUtils.swap( array, j, j + 1 );
                    swap = true;
                }
                iterations++;
            }
            System.out.println( Arrays.toString( array ) );
            if( !swap )
            {
                System.out.println("Stop the algorithm: No inner swaps found");
                break;
            }
        }
        return iterations;
    }

    @Override
    public String name()
    {
        return "Bubble Sort";
    }
}
