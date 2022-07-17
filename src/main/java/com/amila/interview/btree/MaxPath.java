package com.amila.interview.btree;

public class MaxPath
{
    public static void main( String[] args )
    {
        Node root = TreeUtil.getSampleTree();

        System.out.println( "Max Path Sum = " + maxPathSum( root ) );
    }

    private static int maxPathSum( Node root )
    {
        if( root == null )
        {
            return Integer.MIN_VALUE;
        }
        if( root.left == null && root.right == null )
        {
            return root.data;
        }

        return root.data + Math.max( maxPathSum( root.left ), maxPathSum( root.right ) );
    }
}
