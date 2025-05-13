package arvore_binaria.app;

import arvore_binaria.ArvoreBinaria;
import arvore_binaria.Node;

public class ABBMain {
    public static void main(String[] args) {
        ArvoreBinaria arvore = new ArvoreBinaria();

        arvore.insert(10);
        arvore.insert(6);
        arvore.insert(50);
        arvore.insert(3);
        arvore.insert(8);
        arvore.insert(32);
        arvore.insert(75);
        arvore.insert(2);
        arvore.insert(4);
        arvore.insert(31);
        arvore.insert(35);
        arvore.insert(70);
        arvore.insert(77);
        arvore.insert(33);
        arvore.insert(36);
        arvore.insert(68);
        arvore.insert(74);

        arvore.inOrder();

    }
}
