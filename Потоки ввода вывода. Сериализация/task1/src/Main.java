import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Main {
    static StringBuilder stringBuilder = new StringBuilder();
    public static void main(String[] args) throws IOException {
        List<String> directoryPath = List.of("F://JavaProjects//Games//src", "F://JavaProjects//Games//res", "F://JavaProjects//Games//savegames", "F://JavaProjects//Games//temp", "F://JavaProjects//Games//src//main", "F://JavaProjects//Games//src//test", "F://JavaProjects//Games//res//drawables", "F://JavaProjects//Games//res//vectors", "F://JavaProjects//Games//res//icons");
        List<String> filePath = List.of("F://JavaProjects//Games//src//main//Main.java", "F://JavaProjects//Games//src//main//Utils.java", "F://JavaProjects//Games//temp//temp.txt");
        directoryPath
                .forEach(Main::createDirectory);
        filePath
                .forEach(Main::createFile);
        try(FileWriter fileWriter = new FileWriter("F://JavaProjects//Games//temp//temp.txt", true);){
        fileWriter.write(String.valueOf(stringBuilder));
        fileWriter.flush();
    } catch(IOException e){
            System.out.println("Что - то пошло не так во время записи");
        }
        System.out.println(stringBuilder);
    }
    private static void createDirectory(String directoryPath){
        File dir = new File(directoryPath);
        if (dir.mkdir()) {
            stringBuilder.insert(stringBuilder.length(),"Каталог " + dir.getName() + " создан\n");
        } else {
            stringBuilder.insert(stringBuilder.length(),"Каталог " + dir.getName() + " не был создан\n");
        }
    }
    private static void createFile(String filePath){
        File file = new File(filePath);
        try{
            if (file.createNewFile()) {
                stringBuilder.insert(stringBuilder.length(),"Файл " + file.getName() + " создан\n");
            } else {
                stringBuilder.insert(stringBuilder.length(),"Файл " + file.getName() + " не был создан\n");
            }
        } catch(IOException e){
            System.out.println("Что-то пошло не так");
        }
    }
}