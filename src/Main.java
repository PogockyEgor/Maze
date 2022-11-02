import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Level lvl1 = new Level("C:/Users/user/IdeaProjects/Maze/src/level1.txt");
        Player.play(lvl1);
    }
}