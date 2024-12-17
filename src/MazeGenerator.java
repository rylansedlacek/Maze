import java.util.*;
import java.util.Stack;
import java.util.Random;


class MazeGenerator {

    Maze maze;
    Random random;

    public MazeGenerator(Maze maze) {
        this.maze = maze;
        random = new Random();
    } // end construct

    public void generate() {
        Stack<Maze.Cell> stack = new Stack<>(); // using a stack we generate
        
        Maze.Cell start = maze.getCell(0,0);
        start.setVisited(true); // grab cell 0 0 
        stack.push(start);

        while (!stack.isEmpty()) {
            Maze.Cell current = stack.peek();
            List<Maze.Cell> neighbors = getUnvisitedNeighbors(current); // look at all neighbors

            if (neighbors.isEmpty() || neighbors == null) {
                stack.pop();
            } else {
                Maze.Cell next = neighbors.get(random.nextInt(neighbors.size())); // create path usign neighbors
                removeWall(current, next);
                next.setVisited(true);
                stack.push(next);
            }
        } // end while
    }

    List<Maze.Cell> getUnvisitedNeighbors(Maze.Cell cell) {
        int row = cell.row;
        int col = cell.col;

        List<Maze.Cell> neighbors = new ArrayList<>(); // array to store and return

        addNeighborIfUnvisited(neighbors, maze.getCell(row - 1, col)); // Top
        addNeighborIfUnvisited(neighbors, maze.getCell(row + 1, col)); // Bottom
        addNeighborIfUnvisited(neighbors, maze.getCell(row, col - 1)); // Left
        addNeighborIfUnvisited(neighbors, maze.getCell(row, col + 1)); // Right

        return neighbors;

    }

    void addNeighborIfUnvisited(List<Maze.Cell> neighbors, Maze.Cell neighbor) {
         if (neighbor != null && !neighbor.isVisited()) {
            neighbors.add(neighbor); // if its not visited we can add it to our list!
        }
    }

     private void removeWall(Maze.Cell current, Maze.Cell next) {
        int rowDiff = current.row - next.row; // get the differences and determine where to remove
        int colDiff = current.col - next.col;

        if (rowDiff == 1) { // Next is above
            current.removeWall("top");
            next.removeWall("bottom");
        } else if (rowDiff == -1) { // Next is below
            current.removeWall("bottom");
            next.removeWall("top");
        } else if (colDiff == 1) { // Next is left
            current.removeWall("left");
            next.removeWall("right");
        } else if (colDiff == -1) { // Next is right
            current.removeWall("right");
            next.removeWall("left");
        }
    }

} // end class
