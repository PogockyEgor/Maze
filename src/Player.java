import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Player {

    private static int playerX;
    private static int playerY;

    public static int getPlayerX() {
        return playerX;
    }

    public static void setPlayerX(int x) {
        Player.playerX = x;
    }

    public static int getPlayerY() {
        return playerY;
    }

    public static void setPlayerY(int y) {
        Player.playerY = y;
    }

    public static void chooseLevel(ArrayList levels) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите уровень:");
        int choose = 0;
        boolean result = true;
        do {
            try {
                choose = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Неверные данные");
                result = false;
            } finally {
                switch (choose) {
                    case 1 -> Player.play((Level) levels.get(0));
                    case 2 -> Player.play((Level) levels.get(1));
                    case 3 -> Player.play((Level) levels.get(2));
                    case 4 -> Player.play((Level) levels.get(3));
                    case 5 -> Player.play((Level) levels.get(4));
                    default -> {
                        result = false;
                        System.out.println("Неверный ввод");
                    }
                }
            }
        }
        while (!result);
    }

    public static void play(Level lvl) {
        Scanner scanner = new Scanner(System.in);
        setPlayerX(lvl.getStartX());
        setPlayerY(lvl.getStartY());
        System.out.println("Координаты игрока: " + playerX + ", " + playerY);
        while (!((playerX == lvl.getFinalX()) && (playerY == lvl.getFinalY()))) {
            for (char[] t : lvl.getMaze()) {
                for (char r : t) {
                    System.out.print(r);
                }
                System.out.println();
            }
            String motion = scanner.nextLine();
            try {
                switch (motion) {

                    case "w" -> lvl.setMaze(Player.moveUp(lvl.getMaze()));
                    case "a" -> lvl.setMaze(Player.moveLeft(lvl.getMaze()));
                    case "s" -> lvl.setMaze(Player.moveDown(lvl.getMaze()));
                    case "d" -> lvl.setMaze(Player.moveRight(lvl.getMaze()));
                    default -> System.out.println("Введен неверный символ, повторите ввод:");
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Там край лабиринта!");
            }
        }

        for (char[] t : lvl.getMaze()) {
            for (char r : t) {
                System.out.print(r + "");
            }
            System.out.println();
        }
        System.out.println("Вы прошли лабиринт! Ура!");
    }

    public static char[][] moveUp(char[][] maze) {
        System.out.println("Идем вперед");
        if (maze[playerX - 1][playerY] != '\u2B1B') {
            maze[playerX][playerY] = '\u2B1C';
            maze[playerX - 1][playerY] = '\u2B55';
            playerX--;
        } else {
            System.out.println("Здесь стена!");
        }
        return maze;
    }

    public static char[][] moveLeft(char[][] maze) {
        System.out.println("Идем влево");
        if (maze[playerX][playerY - 1] != '\u2B1B') {
            maze[playerX][playerY] = '\u2B1C';
            maze[playerX][playerY - 1] = '\u2B55';
            playerY--;
        } else {
            System.out.println("Здесь стена!");
        }
        return maze;
    }

    public static char[][] moveDown(char[][] maze) {
        System.out.println("Идем вниз");
        if (maze[playerX + 1][playerY] != '\u2B1B') {
            maze[playerX][playerY] = '\u2B1C';
            maze[playerX + 1][playerY] = '\u2B55';
            playerX++;
        } else {
            System.out.println("Здесь стена!");
        }
        return maze;
    }

    public static char[][] moveRight(char[][] maze) {
        System.out.println("Идем вправо");
        if (maze[playerX][playerY + 1] != '\u2B1B') {
            maze[playerX][playerY] = '\u2B1C';
            maze[playerX][playerY + 1] = '\u2B55';
            playerY++;
        } else {
            System.out.println("Здесь стена!");
        }
        return maze;
    }
}