import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Level lvl1 = new Level("Levels/level1.txt");
        Level lvl2 = new Level("Levels/level2.txt");
        Level lvl3 = new Level("Levels/level3.txt");
        Player.startGame(Level.levels);
    }
}