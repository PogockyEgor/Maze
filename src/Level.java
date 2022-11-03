import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Level {

    private int startX;
    private int startY;
    private int finalX;
    private int finalY;
    private char[][] maze;

    public void setMaze(char[][] maze) {
        this.maze = maze;
    }

    public int getStartX() {
        return startX;
    }

    public int getStartY() {
        return startY;
    }

    public int getFinalX() {
        return finalX;
    }

    public int getFinalY() {
        return finalY;
    }

    public char[][] getMaze() {
        return maze;
    }

    public static ArrayList<Level> levels = new ArrayList<>();


    public static char[][] fileToArray(String fileName) throws IOException {
        FileReader fileReader = new FileReader(fileName);
        char[] buff = new char[2000];
        int symbolsLength = fileReader.read(buff);
        int Y = 1;
        int countX = 0;
        int x = 0;
        for (int i = 0; i < symbolsLength; i++) {
            if (buff[i] == '\n') {
                Y++;
                x = countX;
                countX = 1;
            } else {
                countX++;
            }
        }
        StringBuilder[] b = new StringBuilder[Y];
        for (int i = 0; i < b.length; i++) {
            b[i] = new StringBuilder("");
        }
        for (int i = 1, j = 0; i <= symbolsLength; i++) {
            if (!(buff[i - 1] == '\r' || buff[i - 1] == '\n' || (buff[i - 1] == '\u0000'))) {
                b[j].append(buff[i - 1]);
            }
            if (i % x == 0) {
                j++;
            }
        }
        char[][] fileMaze = new char[b.length][b[0].length()];
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[i].length(); j++) {
                fileMaze[i][j] = b[i].charAt(j);
            }
        }
        return fileMaze;
    }

    public Level(String fileName) throws IOException {
        levels.add(this);
        this.maze = Level.fileToArray(fileName);
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                if (maze[i][j] == '\u2B55') {
                    this.startX = i;
                    this.startY = j;
                }
                if (maze[i][j] == '\u2B06') {
                    this.finalX = i;
                    this.finalY = j;
                }
            }
        }
    }
}
