package hash_table.practice1;

import java.util.ArrayList;
import java.util.List;

public class Practice1V2 {
    public static void main(String[] args) {
        int[] chaves = {
                212, 618, 302, 940, 702, 704, 612, 606,
                772, 510, 423, 650, 317, 907, 507, 304,
                714, 857, 801, 900, 413, 701, 418, 601
        };
        System.out.println("Resultados para m = 100:");
        contarColisoes(chaves, 100);
        System.out.println("\nResultados para m = 101:");
        contarColisoes(chaves, 101);
    }
    public static void contarColisoes(int[] chaves, int m) {
        // Tabela de listas para armazenar as chaves em cada posição
        List<Integer>[] tabela = new ArrayList[m];

        for (int i = 0; i < m; i++) {
            tabela[i] = new ArrayList<>();
        }
        int colisoes = 0;
        for (int k : chaves) {
            int hash = k % m;
            if (!tabela[hash].isEmpty()) {
                colisoes++;
            }
            tabela[hash].add(k);
        }
        // Mostrar posições com colisões e as chaves que caíram nelas
        for (int i = 0; i < m; i++) {
            if (tabela[i].size() > 1) {
                System.out.printf("Posição %d: %d colisões - chaves %s\n",
                        i, tabela[i].size() - 1, tabela[i]);
            }
        }
        System.out.println("Total de colisões: " + colisoes);
    }
}