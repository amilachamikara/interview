package com.amila.interview.btree;

class Node
{
    public int data;
    public Node left;
    public Node right;
    public Node parent;

    public Node( int data )
    {
        this.data = data;
    }

    public Node( int data, Node left, Node right )
    {
        this( data );
        this.left = left;
        this.right = right;
    }

    public static Node of( int data, Node left, Node right )
    {
        return new Node( data, left, right );
    }

    public static Node of( int data )
    {
        return of( data, null, null );
    }
}
