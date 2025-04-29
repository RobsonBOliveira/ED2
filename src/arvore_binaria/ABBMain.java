package arvore_binaria;

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

        Node temp = arvore.search(99);
        if(temp != null) {
            System.out.println("O elemento " + temp.key + " está na árvore!");
        } else {
            System.out.println("O elemento não está na árvore!");
        }
    }
}
