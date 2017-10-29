package hw6;

import hw6.Trees.*;
import java.util.Iterator;

public class DemoTaskOne {

    private Tree binaryTree;
    private Tree ternaryTree;
    private Client client;

    public void launch() {
        initTrees();
        //task one:
        printBinaryWidth();
        printBinaryDepth();
        printTernaryWidth();
        printTernaryDepth();
        //task two:
        clientHandle();
    }

    private void printBinaryWidth() {
        Iterator binaryWidth = binaryTree.iterator(Tree.IteratorType.WIDTH);
        System.out.println("Обход двоичного дерева в ширину:");
        while (binaryWidth.hasNext()) {
            TreeNode node = (TreeNode) binaryWidth.next();
            node.print();
        }
    }

    private void printBinaryDepth() {
        Iterator binaryDepth = binaryTree.iterator(Tree.IteratorType.DEPTH);
        System.out.println("\n\nОбход двоичного дерева в глубину:");
        while (binaryDepth.hasNext()) {
            TreeNode node = (TreeNode) binaryDepth.next();
            node.print();
        }
    }

    private void printTernaryWidth() {
        Iterator ternaryWidth = ternaryTree.iterator(Tree.IteratorType.WIDTH);
        System.out.println("\n\nОбход троичного дерева в ширину:");
        while (ternaryWidth.hasNext()) {
            TreeNode node = (TreeNode) ternaryWidth.next();
            node.print();
        }
    }

    private void printTernaryDepth() {
        Iterator ternaryDepth = ternaryTree.iterator(Tree.IteratorType.DEPTH);
        System.out.println("\n\nОбход троичного дерева в глубину:");
        while (ternaryDepth.hasNext()) {
            TreeNode node = (TreeNode) ternaryDepth.next();
            node.print();
        }
    }

    private void clientHandle() {
        System.err.println("\n\nОбработка дерева клиентом:");
        client = new Client();
        client.handle(binaryTree,
                node -> System.out.println("branch found!"),
                node -> System.out.println("leaf found!"));
    }

    private void initTrees() {
        initBinary();
        initTernary();
    }

    private void initBinary() {
        BinaryTreeNode nodeOne = new BinaryTreeNode(1);             //       1
        BinaryTreeNode nodeTwo = new BinaryTreeNode(2);             //`     / \
        BinaryTreeNode nodeThree = new BinaryTreeNode(3);           //     2   3
        BinaryTreeNode nodeFour = new BinaryTreeNode(4);            //    /     \
        BinaryTreeNode nodeFive = new BinaryTreeNode(5);            //   4       5
        nodeOne.addLeft(nodeTwo);
        nodeOne.addRight(nodeThree);
        nodeTwo.addLeft(nodeFour);
        nodeThree.addRight(nodeFive);
        binaryTree = new BinaryTree(nodeOne);
    }

    private void initTernary() {                                     //(да простят меня боги)
        TernaryTreeNode nodeOne = new TernaryTreeNode(1);            //      1
        TernaryTreeNode nodeTwo = new TernaryTreeNode(2);            //    / | \
        TernaryTreeNode nodeThree = new TernaryTreeNode(3);          //   2  3  4
        TernaryTreeNode nodeFour = new TernaryTreeNode(4);           //  /   |   \
        TernaryTreeNode nodeFive = new TernaryTreeNode(5);           // 5    6    7
        TernaryTreeNode nodeSix = new TernaryTreeNode(6);
        TernaryTreeNode nodeSeven = new TernaryTreeNode(7);
        nodeOne.addLeft(nodeTwo);
        nodeOne.addBottom(nodeThree);
        nodeOne.addRight(nodeFour);
        nodeTwo.addLeft(nodeFive);
        nodeThree.addBottom(nodeSix);
        nodeFour.addRight(nodeSeven);
        ternaryTree = new TernaryTree(nodeOne);
    }

}
