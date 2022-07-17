package com.amila.interview.graph;

import java.util.List;
import java.util.Map;
import java.util.Stack;

public class DepthFirstTraversal
{
    public static void main( String[] args )
    {
        Map<Character,List<Character>> graph = GraphUtil.getAcyclicSampleGraph();

        depthFirstItr(graph, 'a');
    }

    private static void depthFirstRec( Map<Character,List<Character>> graph, char startNode )
    {
        System.out.println(startNode);
        graph.get( startNode ).forEach( n -> depthFirstRec( graph, n ));
    }

    private static void depthFirstItr( Map<Character,List<Character>> graph, char startNode )
    {
        Stack<Character> stack = new Stack<>();
        stack.add( startNode );

        while( stack.size() > 0 )
        {
            char current = stack.pop();
            System.out.println(current);

            if( graph.get( current ) != null )
                graph.get( current ).forEach( stack::push );
        }
    }
}
