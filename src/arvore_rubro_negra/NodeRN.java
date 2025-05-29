package arvore_rubro_negra;

public class NodeRN {
    int key;
    int color;
    NodeRN dad;
    NodeRN left, right;

    NodeRN(int k, int c) {
        key = k;
        color = c;
        dad = left = right = null;
    }
}
