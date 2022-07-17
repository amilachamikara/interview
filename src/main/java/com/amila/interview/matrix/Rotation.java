package com.amila.interview.matrix;

public class Rotation
{
    public static void main( String[] args )
    {
        final int[][] matrix = {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 }
        };

        System.out.println( "Input:" );
        MatrixUtils.print( matrix );

        rotate90( matrix );

        System.out.println( "Output:" );
        MatrixUtils.print( matrix );

    }

    private static void rotate90( int[][] M )
    {
        final int SIZE = M.length;

        for( int r = 0; r < SIZE / 2; r++ )
        {
            for( int c = r; c < SIZE - r - 1; c++ )
            {
                int temp = M[r][c];

                M[r][c] = M[SIZE - c - 1][r];
                M[SIZE - c - 1][r] = M[SIZE - r - 1][SIZE - c - 1];
                M[SIZE - r - 1][SIZE - c - 1] = M[c][SIZE - r - 1];
                M[c][SIZE - r - 1] = temp;
            }
        }

    }
}
