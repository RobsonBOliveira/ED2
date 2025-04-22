package arvore_binaria;

public class ArvoreBinaria {
    private Node root;

    public ArvoreBinaria() {
        this.root = null;
    }

    public ArvoreBinaria(Node root) {
        this.root = root;
    }

    public void preOrder() {
        this.preOrder(this.root);
    }

    private void preOrder(Node tree) {
        if(tree != null) {
            System.out.print(tree.key + " ");
            preOrder(tree.left);
            preOrder(tree.right);
        }
    }

    public void inOrder() {
        this.inOrder(this.root);
    }

    private void inOrder(Node tree) {
        if(tree != null) {
            inOrder(tree.left);
            System.out.print(tree.key + " ");
            inOrder(tree.right);
        }
    }

    public void posOrder() {
        this.posOrder(this.root);
    }

    private void posOrder(Node tree) {
        if(tree != null) {
            posOrder(tree.left);
            posOrder(tree.right);
            System.out.print(tree.key + " ");
        }
    }

}
