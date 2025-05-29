package arvore_rubro_negra;

import java.awt.*;

public class ArvoreRN {
    NodeRN root;

    public ArvoreRN() {
        root = null;
    }

    public ArvoreRN(NodeRN tree) {
        this.root = tree;
    }

    public void insert(int key) {
        NodeRN newNode = new NodeRN(key, 1); //cor 1 == vermelho

        NodeRN currentDad = null;
        NodeRN currentRoot = root;

        // Busca
        while (currentRoot != null) {
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
                        //rds em v
                    }
                        v.dad.color = 0;
                        v.dad.dad.color = 1;
                        //res(v.dad.dad);
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
                        //res(v)
                    }

                    v.dad.color = 0;
                    v.dad.dad.color = 1;
                    //rds(v.dad.dad)
                }
            }
            if(v == root)
                break;
        }
        root.color = 0;
    }

    private void rds(NodeRN x){
        NodeRN y = x.left;
        x.left = y.right;
        if(y.right != null){
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

}
