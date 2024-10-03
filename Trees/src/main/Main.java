package main;

public class Main{
    public static void main(String[] args) {
        BSTree tree = new BSTree();
        int[] id = {50, 40, 60, 30, 45, 20, 35};
        String[] name = {"Phong", "Bao", "Kieu", "Huan", "Minh", "hhh", "dsdsa"};
        int[] age = {20, 18, 22, 17, 13, 23, 13};
        
        tree.insertMany(id, name, age);
        

        System.out.println("\nBreadth First:");
        tree.breadth(tree.root);
        System.out.println(tree.countNode(tree.root));
    }
}