package com.amila.interview.btree;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class TreeSum
{
    public static void main( String[] args )
    {
        Node root = TreeUtil.getSampleTree();

        System.out.println( "Sum = " + sumRec( root ) );
        System.out.println( "Sum = " + sumItr( root ) );
    }

    private static long sumItr( Node root )
    {
        if( root == null )
            return 0;
        long total = 0;
        Queue<Node> queue = new ConcurrentLinkedQueue<>();
        queue.add( root );
        while( queue.size() > 0 )
        {
            Node current = queue.poll();
            total += current.data;

            if( current.left != null )
                queue.add( current.left );
            if( current.right != null )
                queue.add( current.right );
        }
        return total;
    }

    private static long sumRec( Node root )
    {
        if( root == null )
            return 0;
        return root.data + sumRec( root.left ) + sumRec( root.right );
    }


}
