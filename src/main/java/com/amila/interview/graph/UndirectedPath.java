package com.amila.interview.graph;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class UndirectedPath
{
    public static void main( String[] args )
    {
        Map<Character,List<Character>> graph = GraphUtil.edgesToGraph( new char[][] {
                { 'i', 'j' },
                { 'k', 'i' },
                { 'm', 'k' },
                { 'k', 'l' },
                { 'o', 'n' }
        } );

        System.out.println( graph );

        Set<Character> visited = new HashSet<>();

        System.out.println( "Has path: " + hasPath( graph, visited, 'i', 'm' ) );

    }

    private static boolean hasPath( Map<Character,List<Character>> graph, Set<Character> visited, char source, char target )
    {
        visited.add( source );
        if( source == target )
            return true;
        for( Character neighbor : graph.get( source ) )
        {
            if( visited.contains( neighbor ) )
                continue;
            if( hasPath( graph, visited, neighbor, target ) )
                return true;
        }
        return false;
    }
}
