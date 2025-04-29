package arvore_binaria;

public class Main {
    public static void main(String[] args) {
        //Nodes nv3
        Node node7 = new Node(7);
        Node node10 = new Node(10);
        Node node16 = new Node(16);

        //Nodes nv2
        Node node4 = new Node(4);
        Node node9 = new Node(9, node7, node10);
        Node node17 = new Node(17, node16, null);

        //Nodes nv1
        Node node6 = new Node(6, node4, node9);
        Node node13 = new Node(13, null, node17);

        //Nodes nv0
        Node node11 = new Node(11, node6, node13);

        ArvoreBinaria arvore = new ArvoreBinaria(node11);

        System.out.println("PréOrdem Recursivo");
        arvore.preOrder();

        System.out.println("\nEmOrdem Recursivo");
        arvore.inOrder();

        System.out.println("\nPosOrdem Recursivo");
        arvore.posOrder();

        System.out.println("\nPor Nível(em largura)");
        arvore.inLevel();

        System.out.println("\nAltura da Árvore");
        System.out.println(arvore.height());
    }
}
