class Solution {
    public int  findSol(int row, char[][] board, int[] colsPlaced, int n)
    {
        // Base case 

        if(row == n)
        {
            return 1;
        }

        int count = 0;

        for(int col = 0; col < n; col++)
        {
            if(colsPlaced[col] == 1) continue;

            // is diagonals are valid

            if(!validateDiagonals(row,col,n,board)) continue;

            board[row][col] = 'Q';
            colsPlaced[col] = 1;

            count+=findSol(row+1, board, colsPlaced, n);

            colsPlaced[col] = 0;
            board[row][col] = '.';
        }

        return count;
    }

    public boolean validateDiagonals(int row, int col , int n, char[][] board)
    {
        // left check
        int r1 = row;
        int c1 = col;

        while(r1 >= 0 && c1 >=0)
        {
            if(board[r1][c1] == 'Q') return false;

            r1--;
            c1--;
        }


        // right check

        int r2 = row;
        int c2 = col;

        while(r2 >=0 && c2 < n)
        {
            if(board[r2][c2] == 'Q') return false;

            r2--;
            c2++;
        }

        return true;
    }
    public int totalNQueens(int n) {
        
        char[][] board = new char[n][n];

        int[] colsPlaced = new int[n];

        for(char[] arr : board) Arrays.fill(arr,'.');
        
        int count = findSol(0, board, colsPlaced,n);

        return count;
    }
}