package com.amila.interview.btree;

import java.util.Stack;

public class InOrderSuccessor
{
    public static void main( String[] args )
    {
        Node root = TreeUtil.getBST();

        Stack<Integer> stack = new Stack<>();

        Node output = findInOrderSuccessor( root, stack, 9 );
        System.out.println( output.data );

        System.out.println( findInOrderSuccessor( root.left ).data );
    }

    static Node findInOrderSuccessor( Node root, Stack<Integer> stack, int target )
    {
        if( root == null )
        {
            return null;
        }
        Node left = findInOrderSuccessor( root.left, stack, target );
        if( stack.size() > 0 && stack.peek() == target )
        {
            stack.push( root.data );
            return root;
        }
        stack.push( root.data );

        Node right = findInOrderSuccessor( root.right, stack, target );

        return left == null ? right : left;
    }


    static Node findInOrderSuccessor( Node input )
    {
        if( input == null ) return null;

        if( input.right != null )
        {
            return getLeftMost(input.right);
        }
        else {
            Node parent = input.parent;
            Node child = input;

            while( parent.right == child )
            {
                if( parent.parent == null ) return null;
                child = parent;
                parent = parent.parent;
            }
            return parent;
        }
    }

    private static Node getLeftMost( Node node )
    {
        if( node.left == null )
        {
            return node;
        }
        return getLeftMost( node.left );
    }
}
