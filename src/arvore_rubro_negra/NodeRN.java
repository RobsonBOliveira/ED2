package arvore_rubro_negra;

public class NodeRN {
    int key;
    int color;
    NodeRN dad;
    NodeRN left, right;

    NodeRN(int k) {
        key = k;
        color = 1;
        dad = left = right = null;
    }

    NodeRN() {
        key = 0;
        color = 0;
        dad = left = right = null;
    }

}
