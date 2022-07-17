package com.amila.interview.graph;

import java.util.*;

public class GraphUtil
{
    private GraphUtil()
    {
    }

    public static Map<Character,List<Character>> getAcyclicSampleGraph()
    {
        Map<Character,List<Character>> graph = new HashMap<>();
        graph.put( 'a', Arrays.asList( 'c', 'b' ) );
        graph.put( 'b', Collections.singletonList( 'd' ) );
        graph.put( 'c', Collections.singletonList( 'e' ) );
        graph.put( 'd', Collections.singletonList( 'f' ) );
        graph.put( 'e', Collections.emptyList() );
        graph.put( 'f', Collections.emptyList() );
        return graph;
    }

    /**
     * f ---- > g ---- > h
     * |      ^
     * |    /
     * v  /
     * i <---- j
     * |
     * |
     * v
     * k
     *
     * @return
     */
    public static Map<Character,List<Character>> getCyclicSampleGraph()
    {
        Map<Character,List<Character>> graph = new HashMap<>();
        graph.put( 'f', Arrays.asList( 'g', 'i' ) );
        graph.put( 'g', Collections.singletonList( 'h' ) );
        graph.put( 'i', Arrays.asList( 'g', 'k' ) );
        graph.put( 'j', Collections.singletonList( 'i' ) );
        graph.put( 'k', Collections.emptyList() );
        graph.put( 'h', Collections.emptyList() );
        return graph;
    }


    public static Map<Character,List<Character>> edgesToGraph( char[][] edges )
    {
        Map<Character,List<Character>> graph = new HashMap<>();

        for( char[] edge : edges )
        {
            if( !graph.containsKey( edge[0] ) )
            {
                graph.put( edge[0], new ArrayList<>() );
            }
            graph.get( edge[0] ).add( edge[1] );

            if( !graph.containsKey( edge[1] ) )
            {
                graph.put( edge[1], new ArrayList<>() );
            }
            graph.get( edge[1] ).add( edge[0] );

        }
        return graph;
    }
}
