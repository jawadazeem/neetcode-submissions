class Solution {
    public boolean isValidSudoku(char[][] board) {

        // Check rows
        for (int r = 0; r < 9; r++) {
            Set<Character> seen = new HashSet<>();
            for (int c = 0; c < 9; c++) {
                char val = board[r][c];
                if (val == '.') continue;
                if (!seen.add(val)) return false;
            }
        }

        // Check columns
        for (int c = 0; c < 9; c++) {
            Set<Character> seen = new HashSet<>();
            for (int r = 0; r < 9; r++) {
                char val = board[r][c];
                if (val == '.') continue;
                if (!seen.add(val)) return false;
            }
        }

        // Check 3x3 boxes
        for (int rowStart = 0; rowStart < 9; rowStart += 3) {
            for (int colStart = 0; colStart < 9; colStart += 3) {

                Set<Character> seen = new HashSet<>();

                for (int r = rowStart; r < rowStart + 3; r++) {
                    for (int c = colStart; c < colStart + 3; c++) {
                        char val = board[r][c];
                        if (val == '.') continue;
                        if (!seen.add(val)) return false;
                    }
                }
            }
        }

        return true;
    }
}