import java.io.*;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class GameProgress implements Serializable {
    private static final long serialVersionUID = 1L;
    private int health;
    private int weapons;
    private int lvl;
    private double distance;

    public GameProgress(int health, int weapons, int lvl, double distance) {
        this.health = health;
        this.weapons = weapons;
        this.lvl = lvl;
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "GameProgress{" +
                "health=" + health +
                ", weapons=" + weapons +
                ", lvl=" + lvl +
                ", distance=" + distance +
                '}';
    }
    public void saveGame(GameProgress gameProgress, String pathFile){
        try(FileOutputStream outputStream = new FileOutputStream(pathFile);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream)){
            objectOutputStream.writeObject(gameProgress);
        }catch(IOException e){
            System.out.println("Вазьникла ашыпка!!!");
        }
    }
    public static void zipFiles(String pathZip, List<String> pathsFiles){
        try(ZipOutputStream zout = new ZipOutputStream(new FileOutputStream(pathZip)))
            {
                for (int i = 0; i < pathsFiles.size(); i++) {
                    FileInputStream fis = new FileInputStream(pathsFiles.get(i));
                    ZipEntry entry = new ZipEntry("save" + (i + 1) + ".dat");
                    zout.putNextEntry(entry);
                    byte[] buffer = new byte[fis.available()];
                    zout.write(buffer);
                    zout.closeEntry();
                }
        } catch (IOException e){
            System.out.println("Что-то пошло не так!!!");
        }
    }

}