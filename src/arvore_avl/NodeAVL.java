package arvore_avl;

public class NodeAVL {
    int key;
    String value;
    NodeAVL left, right;
    int nodeHeight;


    public NodeAVL(int key) {
        this.key = key;
        left = null;
        right = null;
    }

    public NodeAVL(int key, NodeAVL left, NodeAVL right) {
        this.key = key;
        this.left = left;
        this.right = right;
    }

    public NodeAVL(int key, String value) {
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return key;
    }
}
