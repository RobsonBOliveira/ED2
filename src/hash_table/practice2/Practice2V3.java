package hash_table.practice2;

    public class Practice2V3 {
        private int tamanho;
        public Practice2V3(int tamanho) {
            this.tamanho = tamanho;
        }
            // Metodo de hash utilizando o metodo da dobra
            public int hash(int chave) {
            // Converter a chave para string
            String chaveStr = String.valueOf(chave);
            // Obter o tamanho da chave em caracteres
            int tamChave = chaveStr.length();
            // Dobra de 2 dígitos
            int tamanhoDobra = 2;
            int valorHash = 0;
            // Percorre-se a chave, dividindo-a em pedaços
            for (int i = 0; i < tamChave; i += tamanhoDobra) {
                String pedaco;
                // Verifica se o pedaço tem o tamanho correto
                if (i + tamanhoDobra <= tamChave) {
                    pedaco = chaveStr.substring(i, i + tamanhoDobra);
                } else {
                    pedaco = chaveStr.substring(i); // Último pedaço pode ser menor
                }
                // Converte o pedaço para inteiro e soma ao valor de hash
                valorHash += Integer.parseInt(pedaco);
            }
            // Retorna o valor do hash, ajustado pelo tamanho da tabela (módulo)
            return valorHash % tamanho;
        }
        public static void main(String[] args) {
            // Cria uma tabela com 100 posições
            Practice2V3 tabelaHash =
                    new Practice2V3(100);
            //int chave = 123456789;
            int chave = 813459;
            int indice = tabelaHash.hash(chave);
            System.out.println("O índice da chave " + chave + " é: " + indice);
        }
    }
