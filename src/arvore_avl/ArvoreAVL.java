package arvore_avl;

import arvore_binaria.Node;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ArvoreAVL {
    private NodeAVL root;

    public ArvoreAVL() {
        this.root = null;
    }

    public ArvoreAVL(NodeAVL root) {
        this.root = root;
    }

    public void insert( int key, String value){
        this.root = insert(this.root, key, value);
    }

    private int greater(int a, int b){
        return a > b ? a : b;
    }

    private int getBF(NodeAVL tree){
        if(tree == null){
            return 0;
        }
        return height(tree.left) - height(tree.right);
    }

    private int height(NodeAVL tree){
        if(tree == null){
            return -1;
        }

        return tree.nodeHeight;
    }

    public NodeAVL insert(NodeAVL tree, int key,  String value) {
        /* 1. Inserção em uma ABB normal */
        if(tree == null){
            tree = new NodeAVL(key, value);
        }

        if(key < tree.key){
            tree.left = insert(tree.left, key, value);
        } else if(key > tree.key){
            tree.right = insert(tree.right, key, value);
        } else {
            return tree;
        }

        /* 2. Atualiza altura do ancestral (pai) do nó inserido */

        tree.nodeHeight = 1 + greater(height(tree.left), height(tree.right));

        /* 3. Obtenha o fator de balanceamento deste nó ancestral para verificar se ele se tornou desbalanceado */

        int bf = getBF(tree);
        int bfSubLeftTree = getBF(tree.left);
        int bfSubRightTree = getBF(tree.left);

        if(bf > 1 && bfSubRightTree >= 0){
            return RDS(tree);
        }
        if(bf < -1 && bfSubLeftTree <=0){
            return RES(tree);
        }
        if(bf > 1 && bfSubRightTree < 0){
            tree.left = RES(tree.left);
            return RDS(tree);
        }
        if(bf < -1 && bfSubLeftTree > 0){
            tree.right = RDS(tree.right);
            return RES(tree);
        }

        return tree;
    }

    private NodeAVL RDS(NodeAVL y){
        NodeAVL x = y.left;
        NodeAVL z = x.right;

        x.right = y;
        y.left = z;

        y.nodeHeight = 1 + greater(height(y.left), height(y.right));
        x.nodeHeight = 1 + greater(height(x.left), height(x.right));

        //nova raiz
        return x;
    }

    private NodeAVL RES(NodeAVL x){
        NodeAVL y = x.right;
        NodeAVL z = y.left;

        y.left = x;
        x.right = z;

        y.nodeHeight = 1 + greater(height(y.left), height(y.right));
        x.nodeHeight = 1 + greater(height(x.left), height(x.right));

        //nova raiz
        return y;
    }

    public void inOrder() {
        this.inOrder(this.root);
    }

    private void inOrder(NodeAVL tree) {
        if(tree != null) {
            inOrder(tree.left);
            System.out.print(tree.key + " ");
            inOrder(tree.right);
        }
    }
}
