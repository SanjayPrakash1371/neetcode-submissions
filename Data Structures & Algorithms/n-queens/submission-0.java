class Solution {
    public void findSol(int row, char[][] board, int[] colsPlaced,  List<List<String>> result, int n)
    {
        // Base case 

        if(row == n)
        {
            List<String> list = new ArrayList<>();

            for(char[] arr : board)
            {
                StringBuilder sb = new StringBuilder();
                for(char ch : arr)
                {
                    sb.append(ch);
                }

                list.add(sb.toString());
            }

            result.add(new ArrayList<>(list));
            return;
        }




        for(int col = 0; col < n; col++)
        {
            if(colsPlaced[col] == 1) continue;

            // is diagonals are valid

            if(!validateDiagonals(row,col,n,board)) continue;

            board[row][col] = 'Q';
            colsPlaced[col] = 1;

            findSol(row+1, board, colsPlaced, result, n);

            colsPlaced[col] = 0;
            board[row][col] = '.';
        }
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
    public List<List<String>> solveNQueens(int n) {

        List<List<String>> result = new ArrayList<>();

        char[][] board = new char[n][n];

        int[] colsPlaced = new int[n];

        for(char[] arr : board) Arrays.fill(arr,'.');
        
        findSol(0, board, colsPlaced, result,n);

        return result;

    }
}

// Impl plan 
// create a char arr with n x n and fill it with .
// each row place one queen 
// keep a track of queens placed cols , so pick and addition n size row 
// for a new queen , we know there is no queen in the row 
// check all the cols for 0 to n-1
// if the cols is also vaild
// check back the left and right digonal 
// if its valid , place and move to next row

// TC O(n ! * n) 

// we need to place n queens 
// in n x n board 
// it attacks hor - ver - dia
// we canot place 2 queens on same rows and same columns
// also if a queen is palced in a cell, we need to check all the diagonals 
// left and right of it , so that it wont get attacked
