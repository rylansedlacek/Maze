import java.util.LinkedList;
import java.util.Stack;
import java.util.Random;


class MazeGenerator {

    Maze maze;
    Random random;

    public MazeGenerator(Maze maze) {
        this.maze = maze;
        random = new Random();
    }

    public void generate() {
        Stack<Maze.Cell> stack = new Stack<>();
        
        Maze.Cell start = maze.getCell(0,0);
        start.setVisited(true);
        stack.push(start);

        while (!stack.isEmpty()) {
            Maze.Cell current = stack.peek();
            List<Maze.Cell> neighbors = current.getUnvisitedNeighbors(current);

            if (neighbors.isEmpty() || neighbors == null) {
                stack.pop();
            } else {
                Maze.Cell next = neighbors.get(random.nextInt(neighbors.size()));
                removeWall(current, next);
                next.setVisited(true);
                stack.push(next);
            }
        } // end while
    }

    // add getUnivisted
    //
    // add addNeighbor if unvistied
    //
    // add removeWall

}
