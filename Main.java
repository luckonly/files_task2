package files_task2;

import java.io.File;

public class Main {

    private static final String PATH = "/users/at/netology-ru/IdeaProjects/out/";

    public static void main(String[] args) {

        GameProgress game1 = new GameProgress(10,2,5,20.2);
        GameProgress game2 = new GameProgress(50,4,9,35.5);
        GameProgress game3 = new GameProgress(100,7,14,49.7);

        GameProgress.saveGame(PATH + "/Games/savegames/savedatg1.dat", game1);
        GameProgress.saveGame(PATH + "/Games/savegames/savedatg2.dat", game2);
        GameProgress.saveGame(PATH + "/Games/savegames/savedatg3.dat", game3);

        GameProgress.zipFiles(PATH + "/Games/savegames/savedatg1.dat", PATH + "/Games/savegames/savedatg1.zip");
        GameProgress.zipFiles(PATH + "/Games/savegames/savedatg2.dat", PATH + "/Games/savegames/savedatg2.zip");
        GameProgress.zipFiles(PATH + "/Games/savegames/savedatg3.dat", PATH + "/Games/savegames/savedatg3.zip");

        File dirSaveGames = new File(PATH + "/Games/savegames/");

        if (dirSaveGames.isDirectory()) {
            for (File item : dirSaveGames.listFiles()) {
                if (item.getName().contains(".dat")) {
                    item.delete();
                }
            }
        }

    }

}
