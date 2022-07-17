package com.amila.interview;

public class CaesarCipher
{
    public static void main( String[] args )
    {
        String input = "There's-a";
        int k = 3;

        System.out.println( cipher( input, k ) );
    }

    public static String cipher(String input, int k)
    {
        byte[] outputArr = new byte[input.length()];

        int i = 0;
        for( byte b : input.getBytes() )
        {
            byte n = b;

            if( Character.isAlphabetic( b ) )
            {
                if( Character.isUpperCase( b ) )
                {
                    n = ( byte ) (((b - 65 + k)%26) + 65);
                }
                else
                {
                    n = ( byte ) (((b - 97 + k)%26) + 97);
                }
            }
            outputArr[i++] = n;
        }
        return new String(outputArr);
    }
}
