package com.amila.interview.matrix;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Islands
{
    public static void main( String[] args )
    {
        int[][] matrix = new int[][] {
                { 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 1, 1, 0 },
                { 0, 0, 0, 0, 0, 1, 1, 0 },
                { 0, 0, 0, 1, 0, 0, 0, 0 },
                { 0, 0, 1, 1, 1, 0, 0, 0 },
                { 0, 0, 0, 1, 0, 0, 0, 0 },
                { 1, 1, 0, 0, 0, 0, 1, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0 },
        };


        int count = countIslands( matrix );
        System.out.println( "Island count = " + count );
    }

    private static int countIslands( int[][] matrix )
    {
        final int ROWS = matrix.length;
        final int COLS = matrix[0].length;

        boolean[][] visited = new boolean[ROWS][COLS];

        int count = 0;

        for( int r = 0; r < ROWS; r++ )
        {
            for( int c = 0; c < COLS; c++ )
            {
                if( matrix[r][c] == 1 && !visited[r][c] )
                {
                    breadthFirstScan( matrix, r, c, visited );
                    count++;
                }
            }
        }

        return count;
    }

    private static void depthFirstScan( int[][] matrix, int r, int c, boolean[][] visited )
    {
        int[] NR = { -1, -1, -1, 0, 0, 1, 1, 1 };
        int[] NC = { -1, 0, 1, -1, 1, -1, 0, 1 };

        visited[r][c] = true;

        for( int n = 0; n < 8; n++ )
        {
            if( isSafe( matrix, r + NR[n], c + NC[n], visited ) )
            {
                depthFirstScan( matrix, r + NR[n], c + NC[n], visited );
            }
        }

    }

    private static void breadthFirstScan( int[][] matrix, int r, int c, boolean[][] visited )
    {
        int[] NR = { -1, -1, -1, 0, 0, 1, 1, 1 };
        int[] NC = { -1, 0, 1, -1, 1, -1, 0, 1 };

        visited[r][c] = true;

        Queue<int[]> queue = new ConcurrentLinkedQueue<>();
        queue.add( new int[] { r, c } );

        while( queue.size() > 0 )
        {
            int[] cell = queue.poll();
            visited[cell[0]][cell[1]] = true;

            for( int n = 0; n < 8; n++ )
            {
                if( isSafe( matrix, cell[0] + NR[n], cell[1] + NC[n], visited ) )
                {
                    queue.add( new int[] { cell[0] + NR[n], cell[1] + NC[n] } );
                }
            }
        }

    }

    private static boolean isSafe( int[][] matrix, int row, int col, boolean[][] visited )
    {
        final int ROWS = matrix.length;
        final int COLS = matrix[0].length;

        return ( row < ROWS ) && ( row >= 0 ) && ( col < COLS ) && ( col >= 0 ) && ( matrix[row][col] == 1 ) && !visited[row][col];
    }


}
