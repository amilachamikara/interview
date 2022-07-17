package com.amila.interview.graph;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

public class BreadthFirstTraversal
{
    public static void main( String[] args )
    {
        Map<Character,List<Character>> graph = GraphUtil.getAcyclicSampleGraph();

        breadthFirstItr(graph, 'a');
    }

    private static void breadthFirstItr( Map<Character,List<Character>> graph, char startNode )
    {
        Queue<Character> queue = new ConcurrentLinkedQueue<>();
        queue.add( startNode );

        while( queue.size() > 0 )
        {
            char current = queue.poll();
            System.out.println(current);

            if( graph.get( current ) != null )
                queue.addAll( graph.get( current ) );
        }
    }
}
