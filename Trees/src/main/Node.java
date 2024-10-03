/*
 * Copyright (C) 2024 HoangPhong. All Rights Reserved.
 */
package main;

public class Node {

    Student info;
    Node left, right;

    public Node() {
    }
    
    public Node(Student info, Node left, Node right) {
        this.info = info;
        this.left = left;
        this.right = right;
    }

    public Node(Student info) {
        this.info = info;
        left = right = null;
    }

}
