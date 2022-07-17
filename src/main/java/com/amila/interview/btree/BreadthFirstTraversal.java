package com.amila.interview.btree;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class BreadthFirstTraversal
{
    public static void main( String[] args )
    {
        Node root = TreeUtil.getSampleTree();

        iterativeBreadthFirst( root );
    }

    /**
     * Stack can be used for iterative depth first traversal
     *
     * @param node
     */
    static void iterativeBreadthFirst( Node node )
    {
        List<Integer> output = new ArrayList<>();
        Queue<Node> queue = new ConcurrentLinkedQueue<>();
        queue.add( node );

        while( queue.size() > 0 )
        {
            Node current = queue.poll();
            output.add( current.data );

            if( current.left != null )
            {
                queue.add( current.left );
            }
            if( current.right != null )
            {
                queue.add( current.right );
            }
        }
        System.out.println(output);
    }
}
