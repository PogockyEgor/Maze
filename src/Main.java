import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Level lvl1 = new Level("C:/Users/user/IdeaProjects/Maze/src/level1.txt");
        Level lvl2 = new Level("C:/Users/user/IdeaProjects/Maze/src/level2.txt");
        Player.play(lvl1);
        Player.play(lvl2);
    }
}