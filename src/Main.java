import java.util.Scanner;

class Main {
    public static void main (String args[]) {

        Scanner stdin = new Scanner(System.in);

        System.out.println("DEFINE MAZE DIMENSIONS:");
        System.out.println();
        System.out.print("Rows: ");
        int rows = stdin.nextInt();
        System.out.print("Cols: ");
        int cols = stdin.nextInt();

        Maze maze = new Maze(rows, cols);
        MazeGenerator generator = new MazeGenerator(maze);
        generator.generate();

        maze.printMaze();

        // add solving next

    }
}
