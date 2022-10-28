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

    public Level(char[][] maze) {
        this.maze = maze;
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
