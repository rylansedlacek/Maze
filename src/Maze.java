class Maze {

    int rows;
    int cols;
    Cell[][] grid;

    public Maze(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.grid = new Cell[rows][cols];
        initGrid();
    }

    void initGrid() {
        for (int i=0; i<rows; ++i) {
            for (int j=0; j<cols; ++j) {
                grid[i][j] = new Cell(i, j);
            }
        }
    }

    
    public Cell getCell(int row, int col) {
        if (row < 0 || col < 0 ||
                row >= rows || col >= cols) {
            return null;
        }
        return grid[row][col];
    }

    public Cell[][] getGrid() {
        return this.grid;
    }

    public void printMaze() {

        for (int i=0; i<rows; ++i) {
    
           for (int j=0; j<cols; ++j) { // top wall
               if (grid[i][j].hasTopWall()) {
                   System.out.print("+---");
               } else {
                   System.out.print("+   ");
               }
           }
           
          System.out.println("+");

          for (int j=0; j<cols; ++j) { // side walls
            if (grid[i][j].hasLeftWall()) {
                System.out.print("|   ");
            } else {
                System.out.print("    ");
            }
          }

          System.out.print("|");

         for (int j=0; j<cols; ++j) {
            System.out.print("+---");
         }

        System.out.println("+");
        }

    }


} // end maze

  class Cell {

        int row;
        int col;
        boolean visited;
        boolean topWall;
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
        }

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

        }

        public boolean isVisited() {
            return this.visited;
        }

        public void setVisited(boolean visited) {
            this.visited = visited;
        }
    } // end cell




