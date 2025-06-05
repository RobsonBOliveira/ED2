package arvore_rubro_negra;

public class ArvoreRN {
    private final NodeRN nullNode = new NodeRN();
    // Nó sentinela para folhas nulas (sempre preto)
    private NodeRN root = nullNode;

    public ArvoreRN() {
        nullNode.color = 0;
        nullNode.left = null;
        nullNode.right = null;
    }

    public ArvoreRN(NodeRN tree) {
        this.root = tree;
    }

    public void inOrder() {
        inOrder(root);
        System.out.println();
    }

    private void inOrder(NodeRN tree) {
        if (tree != nullNode) {
            inOrder(tree.left);
            System.out.print(tree.key + (tree.color == 0 ? "(P) " : "(V) "));
            inOrder(tree.right);
        }
    }

    public void insert(int key) {
        NodeRN newNode = new NodeRN(key); //cor 1 == vermelho
        newNode.left = nullNode;
        newNode.right = nullNode;

        NodeRN currentDad = null;
        NodeRN currentRoot = root;

        // Busca
        while (currentRoot != nullNode) {
            currentDad = currentRoot;

            if(newNode.key < currentRoot.key){
                currentRoot = currentRoot.left;
            } else {
                currentRoot = currentRoot.right;
            }
        }

        newNode.dad = currentDad;

        //verificar em qual subarvore vai ficar
        if(currentDad == null){
            root = newNode;
        } else if(newNode.key < currentDad.key){
            currentDad.left = newNode;
        } else {
            currentDad.right = newNode;
        }

        if(currentDad == null){
            newNode.color = 0;
            return;
        }

        if(newNode.dad.dad == null){
            return;
        }

        postInsertAdjust(newNode);
    }

    public void postInsertAdjust(NodeRN v) {
        NodeRN u;
        while(v.dad.color == 1){
            if(v.dad == v.dad.dad.right){
                u = v.dad.dad.left;
                if (u.color == 1){
                    u.color = 0;
                    v.dad.color = 0;
                    v.dad.dad.color = 1;
                    v = v.dad.dad;
                } else {
                    if(v == v.dad.left){
                        v = v.dad;
                        rds(v);
                    }
                        v.dad.color = 0;
                        v.dad.dad.color = 1;
                        res(v.dad.dad);
                }
            } else {
                u = v.dad.dad.right;

                if(u.color == 1){
                    u.color = 0;
                    v.dad.color = 0;
                    v.dad.dad.color = 1;
                    v = v.dad.dad;
                } else {
                    if(v == v.dad.right){
                        v = v.dad;
                        res(v);
                    }

                    v.dad.color = 0;
                    v.dad.dad.color = 1;
                    rds(v.dad.dad);
                }
            }
            if(v == root)
                break;
        }
        root.color = 0;
    }

    public NodeRN search(NodeRN tree, int key) {
        while (tree != nullNode && key != tree.key) {
            if (key < tree.key) {
                tree = tree.left;
            } else {
                tree = tree.right;
            }
        }
        return tree;
    }

    private void replace(NodeRN u, NodeRN v) {
        if (u.dad == null) {
            root = v;
        } else if (u == u.dad.left) {
            u.dad.left = v;
        } else {
            u.dad.right = v;
        }
        v.dad = u.dad;
    }

    private NodeRN lesserKey(NodeRN tree) {
        while (tree.left != nullNode) {
            tree = tree.left;
        }
        return tree;
    }

    public void remove(int k) {
        NodeRN z = search(root, k);

        if (z == nullNode) {
            System.out.println("Nó não encontrado na árvore.");
            return;
        }

        NodeRN y = z;
        int originalColorY = y.color;
        NodeRN x;

        if (z.left == nullNode) {
            x = z.right;
            replace(z, z.right);
        } else if (z.right == nullNode) {
            x = z.left;
            replace(z, z.left);
        } else {
            y = lesserKey(z.right);
            originalColorY = y.color;
            x = y.right;
            if (y.dad == z) {
                x.dad = y;
            } else {
                replace(y, y.right);
                y.right = z.right;
                y.right.dad = y;
            }
            replace(z, y);
            y.left = z.left;
            y.left.dad = y;
            y.color = z.color;
        }

        if (originalColorY == 0) {
            postRemoveAdjust(x);
        }
    }

    // Corrigir a árvore após remoção se necessário
    private void postRemoveAdjust(NodeRN x) {
        while (x != root && x.color == 0) {
            if (x == x.dad.left) {
                NodeRN brother = x.dad.right;
                if (brother.color == 1) {
                    brother.color = 0;
                    x.dad.color = 1;
                    res(x.dad);
                    brother = x.dad.right;
                }
                if (brother.left.color == 0 && brother.right.color == 0) {
                    brother.color = 1;
                    x = x.dad;
                } else {
                    if (brother.right.color == 0) {
                        brother.left.color = 0;
                        brother.color = 1;
                        rds(brother);
                        brother = x.dad.right;
                    }
                    brother.color = x.dad.color;
                    x.dad.color = 0;
                    brother.right.color = 0;
                    res(x.dad);
                    x = root;
                }
            } else {
                NodeRN brother = x.dad.left;
                if (brother.color == 1) {
                    brother.color = 0;
                    x.dad.color = 1;
                    rds(x.dad);
                    brother = x.dad.left;
                }
                if (brother.right.color == 0 && brother.left.color == 0) {
                    brother.color = 1;
                    x = x.dad;
                } else {
                    if (brother.left.color == 0) {
                        brother.right.color = 0;
                        brother.color = 1;
                        res(brother);
                        brother = x.dad.left;
                    }
                    brother.color = x.dad.color;
                    x.dad.color = 0;
                    brother.left.color = 0;
                    rds(x.dad);
                    x = root;
                }
            }
        }
        x.color = 0;
    }

    private void res(NodeRN x) {
        NodeRN y = x.right;
        x.right = y.left;
        if (y.left != nullNode) {
            y.left.dad = x;
        }
        y.dad = x.dad;
        if (x.dad == null) {
            root = y;
        } else if (x == x.dad.left) {
            x.dad.left = y;
        } else {
            x.dad.right = y;
        }
        y.left = x;
        x.dad = y;
    }

    private void rds(NodeRN x){
        NodeRN y = x.left;
        x.left = y.right;
        if(y.right != nullNode){
            y.right.dad = x;
        }

        y.dad = x.dad;
        if(x.dad == null){
            root = y;
        }  else if(x == x.dad.right){
            x.dad.right = y;
        }else {
            x.dad.left = y;
        }

        y.right = x;
        x.dad = y;
    }

    public NodeRN getRoot() {return root;}
}
