package com.amila.interview.graph;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ConnectedComponents
{
    public static void main( String[] args )
    {
        Map<Character,List<Character>> graph = GraphUtil.edgesToGraph( new char[][] {
                {'1', '2'},
                {'3', '3'},
                {'6', '4'},
                {'6', '5'},
                {'6', '7'},
                {'6', '8'},
        } );
        System.out.println("Connected Components Count = " + countConnectedComponents(graph));
    }

    private static int countConnectedComponents( Map<Character,List<Character>> graph )
    {
        int count = 0;

        Set<Character> visited = new HashSet<>();

        for( Character node : graph.keySet() )
        {
            if( exploreRec(node, graph, visited) )
            {
                count++;
            }
        }

        return count;
    }

    private static boolean exploreItr( Character node, Map<Character,List<Character>> graph, Set<Character> visited )
    {
        boolean isComponent = false;

        Queue<Character> queue = new ConcurrentLinkedQueue<>();
        queue.add( node );
        while( queue.size() > 0 )
        {
            char current = queue.poll();
            if( visited.contains( current ) )
            {
                continue;
            }
            else
            {
                visited.add( current );
                isComponent = true;
            }
            if( graph.get( current ) != null )
                queue.addAll( graph.get( current ) );
        }

        return isComponent;
    }

    private static boolean exploreRec( Character node, Map<Character,List<Character>> graph, Set<Character> visited )
    {
        if( visited.contains( node ) ) return false;

        visited.add( node );

        for( char neighbor : graph.get( node ) )
        {
            exploreRec( neighbor, graph, visited );
        }

        return true;
    }
}
