import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        char[][] maze = {{'\u2B1B', '\u2B06', '\u2B1B', '\u2B1B', '\u2B1B', '\u2B1B','\u2B1B','\u2B1B'},
                         {'\u2B1C', '\u2B1C', '\u2B1B', '\u2B1C', '\u2B1C', '\u2B1C','\u2B1C','\u2B1B'},
                         {'\u2B1C', '\u2B1B', '\u2B1B', '\u2B1C', '\u2B1B', '\u2B1B','\u2B1C','\u2B1B'},
                         {'\u2B1C', '\u2B1C', '\u2B1B', '\u2B1C', '\u2B1C', '\u2B1B','\u2B1C','\u2B1C'},
                         {'\u2B1B', '\u2B1C', '\u2B1B', '\u2B1B', '\u2B1C', '\u2B1B','\u2B1B','\u2B1C'},
                         {'\u2B1B', '\u2B1C', '\u2B1C', '\u2B1C', '\u2B1C', '\u2B1B','\u2B1B','\u2B1C'},
                         {'\u2B1B', '\u2B1B', '\u2B1B', '\u2B1B', '\u2B1B', '\u2B1C','\u2B1C','\u2B1C'},
                         {'\u2B1B', '\u2B1B', '\u2B1B', '\u2B1B', '\u2B1B', '\u2B55','\u2B1B','\u2B1B'}};

        Scanner scanner = new Scanner(System.in);
        for (int x = 7, y = 5; !((x == 0) && (y == 1)); ) {
            for (char[] t : maze) {
                for (char r : t) {
                    System.out.print(r + " ");
                }
                System.out.println();
            }
            String motion = scanner.nextLine();
            if (motion.equals("w")) {
                System.out.println("Идем вперед");
                if (maze[x - 1][y]!='\u2B1B') {
                    char temp = maze[x][y];
                    maze[x][y] = maze[x - 1][y];
                    maze[x - 1][y] = temp;
                    x--;
                }
                else {
                    System.out.println("Здесь стена!");
                }
            } else if (motion.equals("a")) {
                System.out.println("Идем влево");
                if (maze[x][y - 1]!='\u2B1B') {
                    char temp = maze[x][y];
                    maze[x][y] = maze[x][y - 1];
                    maze[x][y - 1] = temp;
                    y--;
                }
                else {
                    System.out.println("Здесь стена!");
                }
            } else if (motion.equals("s")) {
                System.out.println("Идем вниз");
                if (maze[x + 1][y]!='\u2B1B') {
                    char temp = maze[x][y];
                    maze[x][y] = maze[x + 1][y];
                    maze[x + 1][y] = temp;
                    x++;
                }
                else {
                    System.out.println("Здесь стена!");
                }
            } else if (motion.equals("d")) {
                System.out.println("Идем вправо");
                if (maze[x][y + 1]!='\u2B1B') {
                    char temp = maze[x][y];
                    maze[x][y] = maze[x][y + 1];
                    maze[x][y + 1] = temp;
                    y++;
                }
                else {
                    System.out.println("Здесь стена!");
                }
            } else {
                System.out.println("Введен неверный символ, повторите ввод:");
            }
        }
        for (char[] t : maze) {
            for (char r : t) {
                System.out.print(r + " ");
            }
            System.out.println();
        }
        System.out.println("Вы прошли лабиринт! Ура!");
    }
}
