package com.amila.interview.btree;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class TreeContains
{
    public static void main( String[] args )
    {
        Node root = TreeUtil.getSampleTree();

        System.out.println( containsItr( root, 10 ));
        System.out.println( containsItr( root, 50 ));
    }

    public static boolean containsRec( Node root, int target )
    {
        if( root == null )
            return false;
        if( root.data == target )
            return true;
        return containsRec( root.left, target ) || containsRec( root.right, target );
    }

    public static boolean containsItr( Node root, int target )
    {
        Queue<Node> queue = new ConcurrentLinkedQueue<>();
        queue.add( root );
        while( queue.size() > 0 )
        {
            Node current = queue.poll();
            if( current.data == target )
            {
                return true;
            }
            if( current.left != null ) queue.add( current.left );
            if( current.right != null ) queue.add( current.right );
        }
        return false;
    }
}
