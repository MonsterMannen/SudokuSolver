import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestValidMethods {

    // invalid board
    private static int[][] board1 = {
            { 0, 0, 0, 2, 6, 0, 7, 0, 1 },
            { 6, 8, 0, 0, 7, 0, 0, 9, 0 },
            { 1, 9, 0, 0, 0, 4, 5, 0, 0 },
            { 8, 2, 0, 1, 0, 0, 0, 4, 0 },
            { 0, 0, 4, 6, 0, 2, 9, 0, 0 },
            { 0, 5, 0, 0, 0, 3, 0, 2, 8 },
            { 0, 0, 9, 3, 0, 0, 0, 7, 7 },
            { 0, 4, 0, 0, 5, 0, 0, 8, 8 },
            { 7, 0, 3, 0, 1, 8, 0, 9, 9 },
    };

    // valid board
    private static int[][] board2 = {
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

    @Test
    public void testRows1(){
        SudokuSolver ss = new SudokuSolver();
        assertTrue(ss.validRows(board2));
    }

    @Test
    public void testRows2(){
        SudokuSolver ss = new SudokuSolver();
        assertFalse(ss.validRows(board1));
    }

    @Test
    public void testSolve(){
        SudokuSolver ss = new SudokuSolver();
        int[][] res = ss.solve(board2, false);
        assertTrue(ss.isValid(res));
    }
}
