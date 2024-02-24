import java.util.List;

class Main {
    public static void main(String[] args) {
        List<String> pathFiles = List.of("F:\\JavaProjects\\Games\\savegames\\save1.dat","F:\\JavaProjects\\Games\\savegames\\save2.dat","F:\\JavaProjects\\Games\\savegames\\save3.dat");
        GameProgress save1 = new GameProgress(5,2,3,4.0);
        save1.saveGame(save1, pathFiles.get(0));
        GameProgress save2 = new GameProgress(2,3,4,5.0);
        save2.saveGame(save2, pathFiles.get(1));
        GameProgress save3 = new GameProgress(1,4,1,7.0);
        save3.saveGame(save3, pathFiles.get(2));
        GameProgress.zipFiles("F:\\JavaProjects\\Games\\savegames\\zipSave.zip", pathFiles);
        save1.deleteGame(pathFiles.get(0));
        save2.deleteGame(pathFiles.get(1));
        save3.deleteGame(pathFiles.get(2));
        GameProgress.openZip("F:\\JavaProjects\\Games\\savegames\\zipSave.zip", "F:\\JavaProjects\\Games\\res");
    }
}