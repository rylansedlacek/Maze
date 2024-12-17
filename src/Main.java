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

        // add sorting selection here

        Maze maze = new Maze(rows, cols); // our maze with defined size
        MazeGenerator generator = new MazeGenerator(maze); // the generated
        generator.generate(); // here

        maze.printMaze(); // print it to test

        // add solving next

        MazeSolver solver = new MazeSolver(maze);
        solver.solveDFS(); // solve using DFS

    }
}
