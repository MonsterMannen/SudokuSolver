import java.util.HashSet;
import java.util.Set;

public class SudokuSolver {

    Set<Integer> set = new HashSet<>(); // use this to check for duplicates
    Position pos;

    public int[][] solve(int[][] board){

        int count = 0;

        // keep track of current position on board
        pos = new Position();

        // make a copy of the board to know
        // which numbers were there from the start
        int[][] b = new int[board.length][];
        for(int i = 0; i < board.length; i++){
            b[i] = board[i].clone();
        }

        // check if we move forward or backward
        boolean forward = true;

        while(true){
            int y = pos.getY();
            int x = pos.getX();

            // when every row is done, quit
            if(y > 8) break;

            count++;

            // go next loop if we're on a fixed board number
            if(board[y][x] != 0){
                if(forward){
                    pos.next();
                }else{
                    pos.prev();
                }
                continue;
            }

            // check value 1-9
            do{
                b[y][x]++;
            }while(!isValid(b) && b[y][x] <= 9);

            if(b[y][x] > 9){    // no valid value, go back
                b[y][x] = 0;
                forward = false;
                pos.prev();
            }else{              // valid value found, go forward
                forward = true;
                pos.next();
            }
        }
        System.out.println("Solutions tried: " + count);
        return b;
    }

    // ***** check board methods *****

    public boolean isValid(int[][] board){
        return validRows(board)
                && validColumns(board)
                && validSquares(board);
    }

    public boolean validRows(int[][] board){
        for(int y = 0; y < board.length; y++){
            set.clear();
            for(int x = 0; x < board.length; x++){
                if(board[y][x] == 0) continue;  // skip 0
                if(!set.add(board[y][x])) return false;
            }
        }
        return true;
    }

    public boolean validColumns(int[][] board){
        for(int x = 0; x < board.length; x++){
            set.clear();
            for(int y = 0; y < board.length; y++){
                if(board[y][x] == 0) continue;  // skip 0
                if(!set.add(board[y][x])) return false;
            }
        }
        return true;
    }

    public boolean validSquares(int[][] board){
        for(int baseX = 0; baseX <= 6; baseX += 3){
            for(int baseY = 0; baseY <= 6; baseY += 3) {
                // check 3x3 square
                set.clear();
                for(int x = 0; x < 3; x++){
                    for(int y = 0; y < 3; y++){
                        if(board[y + baseY][x + baseX] == 0) continue;  // skip 0
                        if(!set.add(board[y + baseY][x + baseX])) return false;
                    }
                }
            }
        }
        return true;
    }

    public void printBoard(int[][] board){
        System.out.println("-----------------");
        for(int y = 0; y < board.length; y++){
            for(int x = 0; x < board.length; x++){
                if(board[y][x] == 0) System.out.print(". ");
                else System.out.print(board[y][x] + " ");
            }
            System.out.print("\n");
        }
        System.out.println("-----------------");
    }
}
