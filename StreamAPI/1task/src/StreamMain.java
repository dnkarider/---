import java.util.Comparator;
import java.util.List;

public class StreamMain {
public static void operations(List<Integer> intList){
    intList.stream()
            .filter(x -> x > 0)
            .filter(x -> x % 2 == 0)
            .sorted(Comparator.naturalOrder())
            .forEach(x -> System.out.print(x + " "));
}
}