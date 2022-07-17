package com.amila.interview.graph;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LargestComponent
{
    public static void main( String[] args )
    {
        Map<Character,List<Character>> graph = GraphUtil.edgesToGraph( new char[][] {
                { '0', '1' },
                { '0', '5' },
                { '0', '8' },
                { '5', '8' },
                { '2', '3' },
                { '2', '4' },
                { '3', '4' }
        } );

        System.out.println( "Largest Component Size = " + sizeOfLargestComponent( graph ) );

    }

    private static int sizeOfLargestComponent( Map<Character,List<Character>> graph )
    {
        int maxSize = 0;

        Set<Character> visited = new HashSet<>();

        for( Character node : graph.keySet() )
        {
            int size = getSize( graph, node, visited );
            if( size > maxSize ) maxSize = size;
        }

        return maxSize;
    }

    private static int getSize( Map<Character,List<Character>> graph, Character node, Set<Character> visited )
    {
        if( visited.contains( node ) ) return 0;
        visited.add( node );

        int size = 1;

        for( Character neighbor : graph.get( node ) )
        {
            size += getSize( graph, neighbor, visited );
        }

        return size;
    }
}
