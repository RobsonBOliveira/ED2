package arvore_binaria;

public class Node {
    int key;
    Node left, right;

    public Node(int key) {
        this.key = key;
        left = null;
        right = null;
    }

    public Node(int key, Node left, Node right) {
        this.key = key;
        this.left = left;
        this.right = right;
    }

    public int getKey() {
        return key;
    }
}
