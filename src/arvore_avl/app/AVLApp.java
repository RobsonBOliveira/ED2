package arvore_avl.app;

import arvore_avl.ArvoreAVL;

public class AVLApp{
    public static void main(String[] args) {
        ArvoreAVL avl = new ArvoreAVL();
        avl.insert(40, "quarenta");
        avl.insert(30, "trinta");
        avl.insert(10, "dez");
        avl.insert(5, "cinco");
        avl.insert(8, "oito");

        avl.inOrder();
    }
}