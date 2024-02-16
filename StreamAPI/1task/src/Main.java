import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(1, 2, 5, 16, -1, -2, 0, 32, 3, 5, 8, 23, 4);
        System.out.print("Вывод через Stream: \n");
        StreamMain.operations(intList);
        System.out.println("\nВывод через for + if:");
        ForIfMain.forIfMain(intList);
    }
}