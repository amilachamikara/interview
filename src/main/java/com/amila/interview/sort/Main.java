package com.amila.interview.sort;

import java.util.Arrays;

public class Main
{
    public static void main( String[] args )
    {

        int[] worst = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
        int[] best = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

        int[] array = worst;


        Class<? extends IntegerSortingAlgorithm>[] algorithms = new Class[] {
//                SelectionSort.class,
//                BubbleSort.class,
//                InsertionSort.class,
//                MergeSort.class,
                QuickSort.class
        };

        for( Class<? extends IntegerSortingAlgorithm> algorithm : algorithms )
        {

            try
            {
                System.out.println( "========================================" );
                IntegerSortingAlgorithm instance = algorithm.newInstance();
                System.out.println( "Algorithm: " + instance.name() );
                System.out.println( "Input: " + Arrays.toString( array ) );

                int itr = instance.sort( array );

                System.out.printf( "Output: %s\nIterations: %d\n", Arrays.toString( array ), itr );
                System.out.println( "========================================" );
            }
            catch( Exception e )
            {
                e.printStackTrace();
            }
        }
    }
}
