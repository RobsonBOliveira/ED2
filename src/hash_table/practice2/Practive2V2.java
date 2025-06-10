package hash_table.practice2;

import java.sql.SQLOutput;

public class Practive2V2 {
    static int hash(int key, int size) {
        double A = 0.6180339887;
        double temp = key * A;
        System.out.println(temp);
        temp = temp  - (int) temp;
        return (int) (size*temp);
    }
    public static void main(String[] args) {
        System.out.println(hash(12345, 100));
    }
}

