package com.amila.interview.btree;

public class TreeUtil
{
    private TreeUtil()
    {
    }

    /**
     *                       1
     *
     *               5                8
     *
     *                   12       10     20
     *
     *                                       30
     *
     */
    public static Node getSampleTree()
    {
        Node root = Node.of( 1 );
        root.left = Node.of( 5 );
        root.left.right = Node.of( 12 );
        root.right = Node.of( 8 );
        root.right.left = Node.of( 10 );
        root.right.right = Node.of( 20 );
        root.right.right.right = Node.of( 30 );
        return root;
    }

    public static Node getBST()
    {
        Node root = Node.of( 20 );
        root.left = Node.of( 9 );
        root.left.parent = root;
        root.left.left = Node.of( 5 );
        root.left.left.parent = root.left;
        root.left.right = Node.of( 12 );
        root.left.right.parent = root.left;
        root.left.right.left = Node.of( 11 );
        root.left.right.left.parent = root.left.right;
        root.left.right.right = Node.of( 14 );
        root.left.right.right.parent = root.left.right;
        root.right = Node.of( 25 );
        root.right.parent = root;
        return root;
    }
}
