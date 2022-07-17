package com.amila.interview.btree;

public class LowestCommonAncestor
{
    public static void main( String[] args )
    {
        Node root = TreeUtil.getSampleTree();

        int n1 = 10;
        int n2 = 30;

        Node lca = lca( root, n1, n2 );
        int d1 = distance( lca, n1, 0 );
        int d2 = distance( lca, n2, 0 );
        System.out.println( "LCA = " + lca.data );
        System.out.println( "Distance = " + ( d1 + d2 ) );
    }

    private static int distance( Node root, int value, int dist )
    {
        if( root == null )
            return -1;

        if( root.data == value )
        {
            return dist;
        }

        int ld = distance( root.left, value, dist + 1 );

        return ld != -1 ? ld : distance( root.right, value, dist + 1 );
    }

    private static Node lca( Node root, int n1, int n2 )
    {
        if( root == null )
            return null;

        if( root.data == n1 || root.data == n2 )
            return root;

        Node left = lca( root.left, n1, n2 );
        Node right = lca( root.right, n1, n2 );

        if( left == null )
            return right;
        if( right == null )
            return left;

        return root;
    }

}
