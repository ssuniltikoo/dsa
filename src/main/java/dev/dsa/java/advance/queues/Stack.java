//package dev.dsa.java.advance.queues;
///*
//Implement a First In First Out (FIFO) queue using stacks only.
//
//The implemented queue should support all the functions of a normal queue (push, peek, pop, and empty).
//
//Implement the UserQueue class:
//
//void push(int X) : Pushes element X to the back of the queue.
//int pop() : Removes the element from the front of the queue and returns it.
//int peek() : Returns the element at the front of the queue.
//boolean empty() : Returns true if the queue is empty, false otherwise.
//NOTES:
//
//You must use only standard operations of a stack, which means only push to top, peek/pop from top, size, and is empty operations are valid.
//Depending on your language, the stack may not be supported natively. You may simulate a stack using a list or deque (double-ended queue) as long as you use only a stack's standard operations.
//
//
//
// */
//
//public class Stack {
//
//    public static void main(String[] args) {
//
//    }
//
//}
//
// class UserQueue {
//    /** Initialize your data structure here. */
//    static Stack<Integer> queue;
//    static Stack<Integer> reverse;
//    static int countQ =-1;
//    static   int countR =-1;
//    UserQueue() {
//        queue = new Stack();
//
//        reverse = new Stack();
//
//    }
//
//    /** Push element X to the back of queue. */
//    static void push(int X) {
//        queue.push(X);
//        countQ++;
//
//    }
//
//    /** Removes the element from in front of queue and returns that element. */
//    static int pop() {
//        while(countQ!=-1){
//            reverse.push(queue.pop());
//            countQ--;
//            countR++;
//        }
//        int output = reverse.pop();
//        countR--;
//        while(countR!=-1){
//            queue.push(reverse.pop());
//            countQ++;
//            countR--;
//        }
//        return output;
//    }
//
//    /** Get the front element of the queue. */
//    static int peek() {
//        while(countQ!=-1){
//            reverse.push(queue.pop());
//            countQ--;
//            countR++;
//        }
//        int output = reverse.peek();
//
//        while(countR!=-1){
//            queue.push(reverse.pop());
//            countQ++;
//            countR--;
//        }
//        return output;
//    }
//
//    /** Returns whether the queue is empty. */
//    static boolean empty() {
//        if(countQ==-1)
//            return true;
//        else
//            return false;
//    }
//}
//
///**
// * Your UserQueue object will be instantiated and called as such:
// * UserQueue obj = new UserQueue();
// * obj.push(X);
// * int param2 = obj.pop();
// * int param3 = obj.peek();
// * boolean param4 = obj.empty();
// */
