package hash_table.practice2;

public class Practice2V4 {
    int hash(int key, int size) {
        int nBits = 5;
        int part1 = key >> nBits;
        int part2 = key & (size - 1);
        return (part1 ^ part2);


}}
