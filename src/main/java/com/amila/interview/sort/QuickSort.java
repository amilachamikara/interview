package com.amila.interview.sort;

import java.util.Arrays;

public class QuickSort implements IntegerSortingAlgorithm
{
    @Override
    public int sort( int[] array )
    {
        int pivot = 0;
        quickSort( array, pivot, 0, array.length - 1 );


        String[] parts = "".split( " " );


        return 0;
    }

    private void quickSort( int[] array, int pivot, int l, int h )
    {
        if( l >= h )
            return;

        int pivotValue = array[pivot];

        int i = l;
        int j = h;

        while( i < j )
        {
            while( array[i] <= pivotValue && i < h )
            {
                i++;
            }
            while( array[j] > pivotValue && j > l )
            {
                j--;
            }
            if( i < j )
                SortUtils.swap( array, i, j );
        }
        SortUtils.swap( array, l, j );
        array[j] = pivotValue;

        System.out.println( "Pivot = " + pivotValue );
        System.out.println( Arrays.toString( array ) );

        quickSort( array, l, l, j );
        quickSort( array, j + 1, j + 1, h );

    }

    @Override
    public String name()
    {
        return "Quick Sort";
    }
}
