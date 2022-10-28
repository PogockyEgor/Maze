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
        //System.out.println("Координаты финала: "+lvl1.getFinalX()+", "+ lvl1.getFinalY());
        //System.out.println("Координаты начала: "+lvl1.getStartX()+" "+ lvl1.getStartY());
        Player.play(lvl1);
    }
}
