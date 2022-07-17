package com.amila.interview.btree;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class TreeMin
{
    public static void main( String[] args )
    {
        Node root = TreeUtil.getSampleTree();

        System.out.println("Min = " +  minItr(root));
        System.out.println("Min = " +  minRec(root));
    }

    private static int minRec( Node root )
    {
        if( root == null )
        {
            return Integer.MAX_VALUE;
        }

        return Math.min(root.data, Math.min( minRec( root.left ), minRec( root.right ) ));
    }

    private static int minItr( Node root )
    {
        int min = Integer.MAX_VALUE;
        Queue<Node> queue = new ConcurrentLinkedQueue<>();
        queue.add( root );

        while( queue.size() > 0 )
        {
            Node current = queue.poll();
            if (current.data < min)
            {
                min = current.data;
            }
            if( current.left != null ) queue.add( current.left );
            if( current.right != null ) queue.add( current.right );
        }

        return min;
    }
}
