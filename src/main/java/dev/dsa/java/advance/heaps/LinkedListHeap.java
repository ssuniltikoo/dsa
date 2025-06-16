package dev.dsa.java.advance.heaps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

/*
Given a list containing head pointers of N sorted linked lists.
Merge these given sorted linked lists and return them as one sorted list.


 */
public class LinkedListHeap {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(97);
        ListNode l2 = new ListNode(10);
        ListNode l3 = new ListNode(20);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(11);
        ListNode l6 = new ListNode(13);
        ListNode l7 = new ListNode(3);
        ListNode l8 = new ListNode(18);
        ListNode l9 = new ListNode(49);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;
        l7.next = l8;
        l8.next = l9;
        l9.next = null;
        ArrayList<ListNode> dta  = new ArrayList<ListNode>();
        dta.add(l1);
        dta.add(l2);
        dta.add(l3);
        dta.add(l4);
        dta.add(l5);
        dta.add(l6);
        dta.add(l7);
        dta.add(l8);
        dta.add(l9);
        SolutionHeap    solutionHeap = new SolutionHeap();
        ListNode node = solutionHeap.mergeKLists(dta);
        ListNode head = node;
        while(node.next!=null) {
            System.out.println(node.val);
            node = node.next;
        }
        //System.out.println(solutionHeap.mergeKLists(dta));
    }
}

//        * Definition for singly-linked list.
class ListNode {
     public int val;
     public ListNode next;
     ListNode(int x) { val = x; next = null; }
 }

 class SolutionHeap {
    public ListNode mergeKLists(ArrayList<ListNode> a) {

        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>((x,y) -> x.val - y.val );

        for(ListNode node : a) {
            priorityQueue.add(node);
        }

        ListNode ans = new ListNode(-1);

        ListNode temp = ans;
        while(!priorityQueue.isEmpty()) {
            ListNode node = priorityQueue.poll();
            temp.next=node;
            if(node.next != null) {
                node=node.next;
               // priorityQueue.add(node);
            }

            temp=temp.next;
        }
        return ans.next;
    }
 }

