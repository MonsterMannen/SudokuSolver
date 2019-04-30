public class Main {

    public static void main(String[] args){
        boolean print = false;
        if(args.length > 0){
            if(args[0].equals("--print")){
                print = true;
            }
        }
        SudokuSolver ss = new SudokuSolver();
        int[][] board = Boards.board2;

        System.out.println("\nStarting board");
        ss.printBoard(board);

        int[][] res = ss.solve(board, print);
        System.out.println("\nSolved Sudoku");
        ss.printBoard(res);
    }
}
