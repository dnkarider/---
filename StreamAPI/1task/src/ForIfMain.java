import java.util.Comparator;
import java.util.List;

public class ForIfMain {
    public static void forIfMain(List<Integer> intList){
        intList.sort(Comparator.naturalOrder());
        for(int number : intList){
            if(number > 0 && number % 2 == 0){
                System.out.print(number + " ");
            }
        }
    }

}
