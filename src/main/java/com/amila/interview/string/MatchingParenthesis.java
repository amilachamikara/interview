package com.amila.interview.string;

import java.util.Stack;

public class MatchingParenthesis
{
    public static void main( String[] args )
    {
        String input = "()(()))";
        System.out.println( validate( input ) );
    }

    private static boolean validate( String s )
    {
        Stack<Character> stack = new Stack<>();

        for( char c : s.toCharArray() )
        {
            if( c == '(' )
            {
                stack.push( c );
            }
            if( c == ')' && !stack.isEmpty() )
            {
                return false;
            }
            else if( c == ')' )
            {
                stack.pop();
            }
        }

        return stack.isEmpty();
    }


}
