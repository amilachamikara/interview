package com.amila.interview.factorial;

public class Main
{
    public static void main( String[] args )
    {
        System.out.println(factorial( 4 ));
    }

    static long factorial( int n )
    {
        if( n == 1 )
        {
            return 1;
        }
        else
        {
            return n * factorial( n-1 );
        }
    }
}
