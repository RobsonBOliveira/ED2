package arvore_binaria;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ArvoreBinaria {
    private Node root;

    public ArvoreBinaria() {
        this.root = null;
    }

    public ArvoreBinaria(Node root) {
        this.root = root;
    }

    public void preOrder() {
        this.preOrder(this.root);
    }

    private void preOrder(Node tree) {
        if(tree != null) {
            System.out.print(tree.key + " ");
            preOrder(tree.left);
            preOrder(tree.right);
        }
    }

    public void inOrder() {
        this.inOrder(this.root);
    }

    private void inOrder(Node tree) {
        if(tree != null) {
            inOrder(tree.left);
            System.out.print(tree.key + " ");
            inOrder(tree.right);
        }
    }

    public void posOrder() {
        this.posOrder(this.root);
    }

    private void posOrder(Node tree) {
        if(tree != null) {
            posOrder(tree.left);
            posOrder(tree.right);
            System.out.print(tree.key + " ");
        }
    }

    public void inLevel() {
        this.inLevel(this.root);
    }

    private void inLevel(Node tree) {
        Node current = null;
        if(tree != null) {
            Queue<Node> queue = new LinkedList<>();
            queue.add(tree);
            while(!queue.isEmpty()) {
                current = queue.remove();
                System.out.print(current.key + " ");
                if(current.left != null) {
                    queue.add(current.left);
                }
                if(current.right != null) {
                    queue.add(current.right);
                }
            }
        }
    }

    public void inOrderIterative() {
        this.inOrderIterative(this.root);
    }

    private void inOrderIterative(Node tree) {
        if(tree == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        Node current = tree;

        while(current != null || !stack.isEmpty()) {
            //percorre a esquerda
            while(current != null) {
                stack.push(current);
                current = current.left;
            }

            //imprime o valor
            current = stack.pop();
            System.out.print(current.key + " ");

            //percorre a direita
            current = current.right;
        }
    }

    private int height(Node tree) {
        int a, b;
        if(tree == null) {
            return -1;
        }
        a = height(tree.left);
        b = height(tree.right);

        if(a > b){
            return a+1;
        } else {
            return b+1;
        }
    }

    public int height() {
        return this.height(this.root);
    }

    private Node insert(Node tree, int key){
        if(tree == null) {
            return new Node(key);
        }

        if(key < tree.key) {
            tree.left = insert(tree.left, key);
        } else if(key > tree.key) {
            tree.right = insert(tree.right, key);
        }

        return tree;
    }

    public void insert(int key) {
        this.root = this.insert(this.root, key);
    }

    private Node search(Node tree, int key){
        if(tree == null) {
            return null;
        }

        if(key < tree.key) {
            return search(tree.left, key);
        } else if(key > tree.key) {
            return search(tree.right, key);
        } else {
            return tree;
        }
    }

    public Node search(int key) {
        return this.search(this.root, key);
    }
}
