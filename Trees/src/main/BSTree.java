/*
 * Copyright (C) 2024 HoangPhong. All Rights Reserved.
 */
package main;

import java.util.ArrayList;

public class BSTree {

    Node root;

    public BSTree() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void clear() {
        root = null;
    }

    public Node searchById(Node p, int xId) {
        if (p == null) {
            return null;
        }
        if (xId == p.info.id) {
            return p;
        }
        if (xId < p.info.id) {
            return searchById(p.left, xId);
        }
        return searchById(p.right, xId);
    }

    public void insert(Student x) {
        if (isEmpty()) {
            root = new Node(x);
            return;
        }
        Node p = root;
        while (p != null) {
            if (x.id == p.info.id) {
                System.out.println("Node already exist!");
                return;
            }
            if (x.id < p.info.id) {
                if (p.left == null) {
                    p.left = new Node(x);
                    return;
                }
                p = p.left;
            } else {
                if (p.right == null) {
                    p.right = new Node(x);
                    return;
                }
                p = p.right;
            }
        }
    }

    public void insertMany(int[] id, String[] name, int[] age) {
        for (int i = 0; i < id.length; i++) {
            insert(new Student(id[i], name[i], age[i]));
        }
    }

    public void visit(Node p) {
        System.out.println(p.info);
    }

    public void breadth(Node p) {
        if (p == null) {
            return;
        }
        MyQueue q = new MyQueue();
        q.enqueue(p);
        Node r;
        while (!q.isEmpty()) {
            r = q.dequeue();
            visit(r);
            if (r.left != null) {
                q.enqueue(r.left);
            }
            if (r.right != null) {
                q.enqueue(r.right);
            }
        }
    }

    public void preOder(Node p) {
        if (p == null) {
            return;
        }
        visit(p);
        preOder(p.left);
        preOder(p.right);
    }

    public void inOder(Node p) {
        if (p == null) {
            return;
        }
        inOder(p.left);
        visit(p);
        inOder(p.right);
    }

    public void postOder(Node p) {
        if (p == null) {
            return;
        }
        postOder(p.left);
        postOder(p.right);
        visit(p);
    }

    public void delByCopy(int id) {
        Node p = root;
        Node f = null;

        while (p != null) {
            if (p.info.id == id) {
                break;
            }
            f = p;
            if (id < p.info.id) {
                p = p.left;
            } else {
                p = p.right;
            }
        }

        if (p == null) {
            System.err.println("Not found!");
            return;
        }

        if (p.left != null && p.right != null) {
            Node x = p.left;
            Node fx = null;

            while (x.right != null) {
                fx = x;
                x = x.right;
            }
            p.info = x.info;
            if (fx != null) {
                fx.right = x.left;
            } else {
                p.left = x.left;
            }
        } else {
            if (p.left != null) {
                if (f == null) {
                    root = p.left;
                    return;
                }

                if (f.left == p) {
                    f.left = p.left;
                } else {
                    f.right = p.left;
                }
                return;
            }

            if (p.right != null) {
                if (f == null) {
                    root = p.right;
                    return;
                }

                if (f.left == p) {
                    f.left = p.right;
                } else {
                    f.right = p.right;
                }
                return;
            }

            if (f == null) {
                root = null;
                return;
            }
            if (f.left == p) {
                f.left = null;
            } else {
                f.right = null;
            }
        }
    }

    /* =========================================================== */

    public void inOder(ArrayList<Student> t, Node p) {
        if (p == null) {
            return;
        }
        inOder(t, p.left);
        t.add(p.info);
        inOder(t, p.right);
    }

    public void balance(ArrayList<Student> t, int i, int j) {
        if (i > j)
            return;
        int k = (i + j) / 2;
        Student x = t.get(k);
        insert(x);
        balance(t, i, k - 1);
        balance(t, k + 1, j);
    }

    public void balance() {
        ArrayList<Student> t = new ArrayList<>();
        inOder(t, root);
        clear();

        int n = t.size();
        balance(t, 0, n - 1);
    }

    public Node rightRotate(Node p) {
        Node q = p.left;
        if (p == null || p.left == null)
            return null;
        p.left = q.right;
        q.right = p;
        return q;
    }

    public Node leftRotate(Node p) {
        Node q = p.right;
        if (p == null || p.right == null)
            return null;
        p.right = q.left;
        q.left = p;
        return q;
    }

    public int highBSTree(Node p){
        if (p == null)
            return 0;
        if (p.left == null && p.right == null)
            return 1;
        int max = Math.max(highBSTree(p.left), highBSTree(p.right));
        return max + 1;
    }

    public int countNode(Node p){
        if (p == null)
            return 0;
        return countNode(p.left) + countNode(p.right) + 1;
    }
}
