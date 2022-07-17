package com.amila.interview.matrix;

import java.util.Arrays;

public class MatrixUtils
{
    private MatrixUtils()
    {
    }

    public static void print( int[][] matrix )
    {
        for( int[] row : matrix )
        {
            System.out.println( Arrays.toString(row));
        }
    }
}
