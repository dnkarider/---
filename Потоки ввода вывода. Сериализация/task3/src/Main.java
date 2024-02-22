import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class Main implements Serializable {
    private static final long serialVersionUID = 1L;
    public static void main(String[] args) {
        openZip("F:\\JavaProjects\\Games\\savegames\\zipSave.zip", "F:\\JavaProjects\\Games\\res");
    }
    public static void openZip(String pathZip, String pathSave){
        try(ZipInputStream zis = new ZipInputStream(new FileInputStream(pathZip))) {
            ZipEntry entry;
            String name;
            while ((entry = zis.getNextEntry()) != null) {
                name = entry.getName();
                FileOutputStream fos = new FileOutputStream(pathSave + "\\" + name);
                ObjectOutputStream objOut = new ObjectOutputStream(fos);
                objOut.writeObject(entry);
                System.out.println(name + "sozdan");
                objOut.close();
            }
            } catch(IOException e){
                System.out.println("Smth went wrong!!!");
            }
    }
}