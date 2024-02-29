import java.io.*;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

class Main {
    public static void main(String[] args) {
        List<String> pathsFiles = List.of("F:\\JavaProjects\\Games\\savegames\\save1.dat","F:\\JavaProjects\\Games\\savegames\\save2.dat","F:\\JavaProjects\\Games\\savegames\\save3.dat");
        List<GameProgress> gameObjects = List.of(new GameProgress(5,2,3,4.0), new GameProgress(2,3,4,5.0), new GameProgress(1,4,1,7.0));
        String pathZip = "F:\\JavaProjects\\Games\\savegames\\zipSave.zip";
        String pathZipSave = "F:\\JavaProjects\\Games\\res";
        for(int i = 0; i < 3; i++) {
            try (FileOutputStream outputStream = new FileOutputStream(pathsFiles.get(i));
                 ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream)) {
                objectOutputStream.writeObject(gameObjects.get(i));
            } catch (IOException e) {
                System.out.println("Возникла ошибка!!!");
            }
        }
        try (ZipOutputStream zout = new ZipOutputStream(new FileOutputStream(pathZip))) {
            for (int i = 0; i < pathsFiles.size(); i++) {
                FileInputStream fis = new FileInputStream(pathsFiles.get(i));
                ZipEntry entry = new ZipEntry("save" + (i + 1) + ".dat");
                zout.putNextEntry(entry);
                byte[] buffer = new byte[fis.available()];
                fis.read(buffer);
                zout.write(buffer);
                zout.closeEntry();
                fis.close();
            }
        } catch (IOException e) {
            System.out.println("Что-то пошло не так!!!");
        }
        for(int i = 0; i < 3; i++) {
            File fileToDel = new File(pathsFiles.get(i));
            if (fileToDel.delete()) {
                System.out.println("FileDeleted");
            } else {
                System.out.println("FileNotFound");
            }
        }
        try (ZipInputStream zis = new ZipInputStream(new FileInputStream(pathZip))) {
            ZipEntry entry;
            String name;
            while ((entry = zis.getNextEntry()) != null) {
                name = entry.getName();
                FileOutputStream fout = new FileOutputStream(pathZipSave + "\\" + name);
                for (int c = zis.read(); c != -1; c = zis.read()) {
                    fout.write(c);
                }
                fout.flush();
                zis.closeEntry();
                fout.close();
            }
        } catch (IOException e) {
            System.out.println("Что - то пошло не так!!!");
        }
        for(int i = 0; i < 3; i++){
            try (FileInputStream fileInputStream = new FileInputStream(pathZipSave + "\\save" + (i + 1) + ".dat");
                 ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
                GameProgress gameProgress = (GameProgress) objectInputStream.readObject();
                objectInputStream.close();
                System.out.println(gameProgress);
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Ошибка");
            }
        }
    }
}