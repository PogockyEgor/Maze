import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Player {

    private static int playerX;
    private static int playerY;

    public static void setPlayerX(int x) {
        Player.playerX = x;
    }

    public static void setPlayerY(int y) {
        Player.playerY = y;
    }

    public static void startGame(ArrayList<Level> levels) {
        System.out.println("Добро пожаловать в игру!");
        levels.get(0).setAvailable(true);
        boolean isContinue = true;
        do {
            Player.chooseLevel(levels);
            System.out.println("Хотите продолжить игру?");
            boolean isRight;
            do {
                String answer = new Scanner(System.in).nextLine();
                if (answer.equalsIgnoreCase("Нет")){
                    System.out.println("Спасибо за игру!");
                    isContinue=false;
                    isRight=true;
                } else if (answer.equalsIgnoreCase("Да")) {
                    System.out.println("Продолжаем игру!");
                    isRight=true;
                }else {
                    System.out.println("Не удается распознать написанное, введите \"да\" или \"нет\"");
                    isRight = false;
                }
            }while (!isRight);
        }while (isContinue);
    }

    public static void chooseLevel(ArrayList<Level> levels) {
        Scanner scanner = new Scanner(System.in);
        boolean result = false;
        do {
            System.out.println("Выберите уровень:");
            if (scanner.hasNextInt()) {
                try {
                    int chosenLevel = scanner.nextInt();
                    if (levels.get(chosenLevel - 1).isAvailable()) {
                        System.out.println("Запускаем " + chosenLevel + " уровень...");
                        Player.play(levels.get(chosenLevel - 1));
                        result = true;
                        try {
                            levels.get(chosenLevel).setAvailable(true);
                        } catch (IndexOutOfBoundsException e) {
                            System.out.println("Вы прошли игру!");
                        }
                    } else {
                        System.out.println("Этот уровень недоступен, пройдите прошлые уровни!");
                    }
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Такого уровня нет!");
                }
            } else {
                System.out.println("Необходимо вводить число!");
                scanner.next();
            }
        }
        while (!result);
    }

    public static void play(Level lvl) {
        char[][] clearMaze = Arrays.stream(lvl.getMaze()).map(char[]::clone).toArray(char[][]::new);
        setPlayerX(lvl.getStartX());
        setPlayerY(lvl.getStartY());
        while (!((playerX == lvl.getFinalX()) && (playerY == lvl.getFinalY()))) {
            lvl.showMaze();
            String motion = new Scanner(System.in).nextLine();
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
        lvl.showMaze();
        lvl.setMaze(clearMaze);
        System.out.println("Уровень пройден");
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