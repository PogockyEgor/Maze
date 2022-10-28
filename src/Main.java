public class Main {
    public static void main(String[] args) {
        char[][] maze = {{'\u2B1B', '\u2B06', '\u2B1B', '\u2B1B', '\u2B1B', '\u2B1B', '\u2B1B', '\u2B1B' },
        {'\u2B1C', '\u2B1C', '\u2B1B', '\u2B1C', '\u2B1C', '\u2B1C', '\u2B1C', '\u2B1B' },
        {'\u2B1C', '\u2B1B', '\u2B1B', '\u2B1C', '\u2B1B', '\u2B1B', '\u2B1C', '\u2B1B' },
        {'\u2B1C', '\u2B1C', '\u2B1B', '\u2B1C', '\u2B1C', '\u2B1B', '\u2B1C', '\u2B1C' },
        {'\u2B1B', '\u2B1C', '\u2B1B', '\u2B1B', '\u2B1C', '\u2B1B', '\u2B1B', '\u2B1C' },
        {'\u2B1B', '\u2B1C', '\u2B1C', '\u2B1C', '\u2B1C', '\u2B1B', '\u2B1B', '\u2B1C' },
        {'\u2B1B', '\u2B1B', '\u2B1B', '\u2B1B', '\u2B1B', '\u2B1C', '\u2B1C', '\u2B1C' },
        {'\u2B1B', '\u2B1B', '\u2B1B', '\u2B1B', '\u2B1B', '\u2B55', '\u2B1B', '\u2B1B' }};

        Level lvl1 = new Level(maze);
        Player.play(lvl1);
    }
}
