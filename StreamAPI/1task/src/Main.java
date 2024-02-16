import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(1, 2, 5, 16, -1, -2, 0, 32, 3, 5, 8, 23, 4);
        StreamMain operator = new StreamMain();
        System.out.print("Вывод через Stream: \n");
        operator.operations(intList);
        intList.sort(Comparator.naturalOrder());
        System.out.println("\nВывод через for + if:");
        for(int number : intList){
            if(number > 0 && number % 2 == 0){
                System.out.print(number + " ");
            }
        }
    }
}