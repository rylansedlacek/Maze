class Maze {

    int rows = 0;
    int cols = 0;
    Cell[][] grid = new Cell[rows][cols];

    public Maze(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.grid = new Cell[rows][cols];
        initGrid();
    } // construct

    void initGrid() {
        for (int i=0; i<rows; ++i) {
            for (int j=0; j<cols; ++j) {
                grid[i][j] = new Cell(i, j);
            }
        }
    } // just set everybody to a cell

    
    public Cell getCell(int row, int col) {
        if (row < 0 || col < 0 ||
                row >= rows || col >= cols) {
            return null;
        }
        return grid[row][col];
    } // check bounds and return it

    public Cell[][] getGrid() {
        return this.grid;
    } // return the grid

   public void printMaze() {
    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
            if (grid[i][j].hasTopWall()) {
                System.out.print("+---"); // top walls for length
            } else {
                System.out.print("+   ");
            }
        }
        System.out.println("+");

        for (int j = 0; j < cols; j++) {
            if (grid[i][j].hasLeftWall()) {
                System.out.print("|   "); // left walls for length
            } else {
                System.out.print("    ");
            }
        }
        System.out.println("|"); // right wals
    }

    for (int j = 0; j < cols; j++) {
        System.out.print("+---"); // bottom walls
    }
        System.out.println("+");
    } // end of the printer   
 


  class Cell { // class inside of cell as learned in 340

        int row;
        int col;
        boolean visited = false;
        boolean topWall; // booleans
        boolean bottomWall;
        boolean leftWall;
        boolean rightWall;


        public Cell(int row, int col) {
            this.row = row;
            this.col = col;

            this.topWall = true;
            this.bottomWall = true;
            this.leftWall = true;
            this.rightWall = true;
        } // basic construct

        // basic getters here
        public boolean hasTopWall() {
            return this.topWall;
        }

        public boolean hasBottomWall() {
            return this.bottomWall;
        }

        public boolean hasLeftWall() {
            return this.leftWall;
        }

        public boolean hasRightWall() {
            return this.rightWall;
        }

        public void removeWall(String choice) {

            if (choice.equals("top")) { topWall = false;}

            if (choice.equals("bottom")) { bottomWall = false;}

            if (choice.equals("left")) { leftWall = false;}

            if (choice.equals("right")) { rightWall = false;}

        } // for usage by other clases

        public boolean isVisited() { // just checking if visited
            return this.visited;
        }

        public void setVisited(boolean visited) { // just adding to visited
            this.visited = visited;
        }
    } // end cell

}


