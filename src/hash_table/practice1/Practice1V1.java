package hash_table.practice1;

public class Practice1V1 {
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
        // Contador de acessos por posição
        int[] hashCont = new int[m];
        // Armazena as chaves como texto por posição
        String[] hashChaves = new String[m];
        // Inicializa o array das chaves sinônimas
        for (int i = 0; i < m; i++) {
            // vazio inicialmente
            hashChaves[i] = "";
        }
        int totalColisoes = 0;
        for (int k : chaves) {
            int hash = k % m;
            if (hashCont[hash] > 0) {
                totalColisoes++;
            }
            hashCont[hash]++;
            if (!hashChaves[hash].isEmpty()) {
                hashChaves[hash] += ", ";
            }
            hashChaves[hash] += k;
        }
        System.out.println("Colisões por posição:");
        for (int i = 0; i < m; i++) {
            if (hashCont[i] > 1) {
                System.out.printf("Posição %d: %d colisões — chaves: [%s]\n",
                        i, hashCont[i] - 1, hashChaves[i]);
            }
        }
        System.out.println("Total de colisões: " + totalColisoes);
    }
}
