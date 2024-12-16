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

    }

    class Cell {





    }



}
