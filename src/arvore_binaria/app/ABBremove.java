package arvore_binaria.app;

import arvore_binaria.ArvoreBinaria;

public class ABBremove {
    public static void main(String[] args) {
        ArvoreBinaria arvore = new ArvoreBinaria();

        arvore.insert(22);
        arvore.insert(18);
        arvore.insert(100);
        arvore.insert(6);
        arvore.insert(20);
        arvore.insert(105);
        arvore.insert(102);
        arvore.insert(405);

        arvore.inOrder();
        System.out.println(arvore.countNodes());
        System.out.println("\nJonas");
        arvore.remove(22);
        arvore.inOrder();
        System.out.println(arvore.countNodes());
    }

}
