import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder stringBuilder = new StringBuilder("");
        File dir1 = new File("F://JavaProjects//Games//src");
        if (dir1.mkdir()) {
            stringBuilder.insert(stringBuilder.length(),"Каталог " + dir1.getName() + " создан\n");
        }
        File dir2 = new File("F://JavaProjects//Games//res");
        if (dir2.mkdir()) {
            stringBuilder.insert(stringBuilder.length(),"Каталог " + dir2.getName() + " создан\n");
        }
        File dir3 = new File("F://JavaProjects//Games//savegames");
        if (dir3.mkdir()) {
            stringBuilder.insert(stringBuilder.length(),"Каталог " + dir3.getName() + " создан\n");
        }
        File dir4 = new File("F://JavaProjects//Games//temp");
        if (dir4.mkdir()) {
            stringBuilder.insert(stringBuilder.length(),"Каталог " + dir4.getName() + " создан\n");
        }
        File dir5 = new File("F://JavaProjects//Games//src//main");
        if (dir5.mkdir()) {
            stringBuilder.insert(stringBuilder.length(),"Каталог " + dir5.getName() + " создан\n");
        }
        File dir6 = new File("F://JavaProjects//Games//src//test");
        if (dir6.mkdir()) {
            stringBuilder.insert(stringBuilder.length(),"Каталог " + dir6.getName() + " создан\n");
        }
        File dir7 = new File("F://JavaProjects//Games//src//main");
        if (dir7.mkdir()) {
            stringBuilder.insert(stringBuilder.length(),"Каталог " + dir7.getName() + " создан\n");
        }
        File dir8 = new File("F://JavaProjects//Games//src//main//Main.java");
        try{
        if (dir8.createNewFile()) {
            stringBuilder.insert(stringBuilder.length(),"Файл " + dir8.getName() + " создан\n");
        }} catch(IOException e){
            System.out.println(e.getMessage());
        }
        File dir9 = new File("F://JavaProjects//Games//src//main//Utils.java");
        try{
            if (dir9.createNewFile()) {
                stringBuilder.insert(stringBuilder.length(),"Файл " + dir9.getName() + " создан\n");
            }} catch(IOException e){
            System.out.println(e.getMessage());
        }
        File dir10 = new File("F://JavaProjects//Games//res//drawables");
        if (dir10.mkdir()) {
            stringBuilder.insert(stringBuilder.length(),"Каталог " + dir10.getName() + " создан\n");
        }
        File dir11 = new File("F://JavaProjects//Games//res//vectors");
        if (dir11.mkdir()) {
            stringBuilder.insert(stringBuilder.length(),"Каталог " + dir11.getName() + " создан\n");
        }
        File dir12 = new File("F://JavaProjects//Games//res//icons");
        if (dir12.mkdir()) {
            stringBuilder.insert(stringBuilder.length(),"Каталог " + dir12.getName() + " создан\n");
        }
        File dir13 = new File("F://JavaProjects//Games//temp//temp.txt");
        try{
            if (dir13.createNewFile()) {
                stringBuilder.insert(stringBuilder.length(),"Файл " + dir13.getName() + " создан\n");
            }} catch(IOException e){
            System.out.println(e.getMessage());
        }
        try(FileWriter fileWriter = new FileWriter("F://JavaProjects//Games//temp//temp.txt", false);){
        fileWriter.write(String.valueOf(stringBuilder));
        fileWriter.flush();
    }}
}