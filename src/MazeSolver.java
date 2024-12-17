import java.util.Stack;
import java.util.Queue;
import java.util.Map;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Set;
import java.util.List;
import java.util.HashMap;
import java.util.Collections;

class MazeSolver {

    Maze maze;
    Maze.Cell start;
    Maze.Cell end;

    public MazeSolver(Maze maze) {
        this.maze = maze;
        this.start = maze.getCell(0,0); // get top
        this.end = maze.getCell(maze.getGrid().length - 1, maze.getGrid()[0].length - 1); // get bottom right corner
    } // end construct

    void solveDFS() { // solve using algorithm given in 340
        Stack<Maze.Cell> stack = new Stack<>();
        Set<Maze.Cell> visited = new HashSet<>();
        Map<Maze.Cell, Maze.Cell> path = new HashMap<>();

        stack.push(start);
        visited.add(start);

        while (!stack.isEmpty()) {
            Maze.Cell current = stack.pop(); // get element

            if (current == end) {
                reconstructPath(path, current); // we have raeched the end
                return;
            }

            for (Maze.Cell neighbor : getAccessibleNeighbors(current)) {
                if (!visited.contains(neighbor)) { // add and visit neighbors
                    stack.push(neighbor);
                    visited.add(neighbor);
                    path.put(neighbor, current);
                }
            }
        }
        System.out.println("NO PATH FOUND WITH DFS"); // default
    } // end DFS
    //

    // add BFS here
    //


     private List<Maze.Cell> getAccessibleNeighbors(Maze.Cell cell) {

        List<Maze.Cell> neighbors = new ArrayList<>();
        int row = cell.row;
        int col = cell.col;

        if (!cell.hasTopWall() && maze.getCell(row - 1, col) != null) { // get top wall neighbors
            neighbors.add(maze.getCell(row - 1, col));
        }

        if (!cell.hasBottomWall() && maze.getCell(row + 1, col) != null) { // get bottom wall neighbors
            neighbors.add(maze.getCell(row + 1, col));
        }

        if (!cell.hasLeftWall() && maze.getCell(row, col - 1) != null) { // get left wall neighbors
            neighbors.add(maze.getCell(row, col - 1));
        }

        if (!cell.hasRightWall() && maze.getCell(row, col + 1) != null) { // get right wall neighbors
            neighbors.add(maze.getCell(row, col + 1));
        }
        return neighbors; // return back ourlist of neighbors
    }

     private void reconstructPath(Map<Maze.Cell, Maze.Cell> path, Maze.Cell current) {
        List<Maze.Cell> solutionPath = new ArrayList<>(); // path of our solution for either DFS or BFS
        while (current != null) {
            solutionPath.add(current); // add curr to list
            current = path.get(current); // get it
        }
        Collections.reverse(solutionPath); // reverse it at the end to fix

        for (Maze.Cell cell : solutionPath) {
            System.out.println("(" + cell.row + ", " + cell.col + ")"); // print in a pretty way (0,0)
        }
    } // end recon


} // end class
