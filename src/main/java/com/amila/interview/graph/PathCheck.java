package com.amila.interview.graph;

import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class PathCheck
{
    public static void main( String[] args )
    {
        Map<Character,List<Character>> graph = GraphUtil.getCyclicSampleGraph();
        System.out.println( "Has Path: " + hasPathItr( graph, 'h', 'j' ) );
    }

    private static boolean hasPathRec( Map<String,List<String>> graph, String source, String target )
    {
        if( source.equals( target ) ) return true;

        for( String neighbor : graph.get( source ) )
            if ( hasPathRec( graph, neighbor, target ) )
                return true;

        return false;
    }

    private static boolean hasPathItr( Map<Character,List<Character>> graph, char source, char target )
    {
        Queue<Character> queue = new ConcurrentLinkedQueue<>();
        queue.add( source );

        while( queue.size() > 0 )
        {
            char current = queue.poll();
            if( current == target ) return true;
            queue.addAll( graph.get( current ) );
        }
        return false;
    }


}
