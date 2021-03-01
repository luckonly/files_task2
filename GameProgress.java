package files_task2;

import java.io.*;
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

    public static void saveGame(String path, GameProgress gameProgress) {

        try (FileOutputStream fos = new FileOutputStream(path);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(gameProgress);
            System.out.println("Файл сохранения успешно записан");


        } catch (Exception ex) {
            System.out.println("Произошла ошибка при записи файла " + ex.toString());
        }

    }

    public static void zipFiles(String path, String fileName) {

        try (FileInputStream fis = new FileInputStream(path);
              FileOutputStream fos = new FileOutputStream(fileName);
              ZipOutputStream zos = new ZipOutputStream(fos)) {

            byte[] buffer = new byte[fis.available()];
            ZipEntry entry = new ZipEntry(fileName);
            zos.putNextEntry(entry);
            fis.read(buffer);
            zos.write(buffer);
            zos.closeEntry();

            System.out.println("Zip-архива успешно создан");

        } catch (Exception ex) {
            System.out.println("Произошла ошибка при создании zip-архива");
        }

    }


}