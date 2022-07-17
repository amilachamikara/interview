package com.amila.interview;

public class MissingNumber
{
    public static void main( String[] args )
    {
        System.out.println(missingNumber( new int[] { 3, 7, 1, 2, 8, 4, 5} ));
    }

    public static int missingNumber(int[] arr)
    {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int tot = 0;

        for( int i : arr )
        {
            if( i> max )
            {
                max = i;
            }
            if( i < min )
            {
                min = i;
            }
            tot+=i;
        }

        int expRangeTotal = (arr.length + 1)/2 * (max+min);

        return expRangeTotal-tot;
    }
}
