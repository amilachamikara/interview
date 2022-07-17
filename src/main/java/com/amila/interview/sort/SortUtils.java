package com.amila.interview.sort;

public class SortUtils
{
    private SortUtils()
    {
    }

    public static void swap( int[] array, int a, int b )
    {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
