package com.amila.interview.ll;

import java.util.ArrayList;
import java.util.List;

public class LLMain1
{
    public static void main( String[] args )
    {
        Node head1 = new Node(   4, new Node( 8, new Node( 15, new Node( 19, null ) ) ) );
        Node head2 = new Node(  7, new Node( 9, new Node( 10, new Node( 16, null ) ) ) );


        printLL( "Head1", head1 );
        printLL( "Head2", head2 );
        System.out.println("===========================");


        Node mergedHead = null;

        if( head1.data <= head2.data )
        {
            mergedHead = head1;
            head1 = head1.next;
        }
        else
        {
            mergedHead = head2;
            head2 = head2.next;
        }

        Node mergedTail = mergedHead;

        while( head1!=null && head2!=null )
        {
            Node temp = null;

            if( head1.data <= head2.data )
            {
                temp = head1;
                head1 = head1.next;
            }
            else
            {
                temp = head2;
                head2 = head2.next;
            }
            mergedTail.next = temp;
            mergedTail = temp;
        }

        if (head1 != null) {
            mergedTail.next = head1;
        } else if (head2 != null) {
            mergedTail.next = head2;
        }


        printLL( "HeadM", mergedHead );
        printLL( "Head1", head1 );
        printLL( "Head2", head2 );
    }

    public static void printLL(String name, Node head)
    {
        List<Integer> temp = new ArrayList<>();
        for( Node i = head;  i != null ; i = i.next )
        {
            temp.add( i.data );
        }
        System.out.printf( "%s-->%s%n", name, temp);
    }
}
