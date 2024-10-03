/*
 * Copyright (C) 2024 HoangPhong. All Rights Reserved.
 */

package main;

import java.util.LinkedList;

public class MyQueue {
    LinkedList<Node> qu;

    public MyQueue() {
        qu = new LinkedList();
    }
    
    void clear(){
        qu.clear();
    }
    
    boolean isEmpty(){
        return qu.isEmpty();
    }
    
    void enqueue(Node s){
        qu.addLast(s);
    }
    
    Node dequeue(){
        if (isEmpty())
            return null;
        return qu.removeFirst();
    }
    
    Node front(){
        if (isEmpty())
            return null;
        return qu.getFirst();
    }
    
    Integer size(){
        return qu.size();
    }
}
