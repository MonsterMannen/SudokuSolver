public class Main {

    public static int[][] board1 = {
            { 0, 0, 0, 2, 6, 0, 7, 0, 1 },
            { 6, 8, 0, 0, 7, 0, 0, 9, 0 },
            { 1, 9, 0, 0, 0, 4, 5, 0, 0 },
            { 8, 2, 0, 1, 0, 0, 0, 4, 0 },
            { 0, 0, 4, 6, 0, 2, 9, 0, 0 },
            { 0, 5, 0, 0, 0, 3, 0, 2, 8 },
            { 0, 0, 9, 3, 0, 0, 0, 7, 4 },
            { 0, 4, 0, 0, 5, 0, 0, 3, 6 },
            { 7, 0, 3, 0, 1, 8, 0, 0, 0 },
    };

    public static void main(String[] args) {
        SudokuSolver ss = new SudokuSolver();

        System.out.println("\nStarting board");
        ss.printBoard(board1);

        int[][] res = ss.solve(board1);
        System.out.println("\nSolved Sudoku");
        ss.printBoard(res);
    }
}
