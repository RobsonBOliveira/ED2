package arvore_binaria.app;

import arvore_binaria.ArvoreBinaria;
import arvore_binaria.Node;

public class ABBMain {
    public static void main(String[] args) {
        ArvoreBinaria arvore = new ArvoreBinaria();

        arvore.insert(4);
        arvore.insert(3);
        arvore.insert(5);
        arvore.insert(2);
        arvore.insert(1);
        arvore.insert(6);
        arvore.insert(7);

        Node temp = arvore.search(6);
        if(temp != null) {
            System.out.println("O elemento " + temp.getKey() + " está na árvore!");
        } else {
            System.out.println("O elemento não está na árvore!");
        }
    }
}
