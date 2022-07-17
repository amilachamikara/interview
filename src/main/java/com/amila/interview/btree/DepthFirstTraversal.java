package com.amila.interview.btree;

import java.util.Stack;

public class DepthFirstTraversal
{
    public static void main( String[] args )
    {
        Node root = TreeUtil.getSampleTree();

//        iterativeDepthFirst( root );
//
//        System.out.println();

        recursiveDepthFirst( root );
    }

    /**
     * Stack can be used for iterative depth first traversal
     * @param node
     */
    static void iterativeDepthFirst( Node node )
    {
        Stack<Node> stack = new Stack<>();
        stack.push( node );

        while( stack.size() > 0 )
        {
            Node current = stack.pop();
            System.out.print( current.data + " " );

            if( current.right != null )
            {
                stack.push( current.right );
            }
            if( current.left != null )
            {
                stack.push( current.left );
            }
        }
    }

    static void recursiveDepthFirst( Node node )
    {
        if( node == null )
        {
            return;
        }
        recursiveDepthFirst( node.left );
        recursiveDepthFirst( node.right );
        System.out.print( node.data + " " );
    }
}
