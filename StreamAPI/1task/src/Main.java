import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Main {
    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(1, 2, 5, 16, -1, -2, 0, 32, 3, 5, 8, 23, 4);
        List<Integer> newList = new ArrayList<>();
        System.out.print("Вывод через ForIf: \n");
        for(int number : intList){
            if(number > 0 && number % 2 == 0){
                newList.add(number);
            }
        }
        newList.sort(Comparator.naturalOrder());
        for (int result : newList){
            System.out.print(result + " ");
        }
        System.out.print("\nВывод через Stream: \n");
        StreamMain.operations();
    }
}