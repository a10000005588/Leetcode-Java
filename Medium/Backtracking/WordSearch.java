// 79  Word Search


// my solution...time limited exceeded.

class Solution {
    public boolean exist(char[][] board, String word) {
        // create a two dimension array for tracking.
        // 0: not go through, 1: go through
        int[][] track;
        char[] words = word.toCharArray();

        boolean res = false;
        int[] x = new int[1];
        x[0] = 0;

        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[i].length; j++) {
                // initialize track...
                track = new int[board.length][board[0].length];
                doSearch(board, words, track, 0, i, j, x);
            }
        }

        if(x[0] == 1) {
            return true;
        }

        return false;
    }

    public void doSearch(char[][] board, char[] words,int[][] track, int index, int row, int column, int[] flag) {

        if(index == words.length) {
            flag[0] = 1;
            return;
        }

        if(row < 0 || row >= board.length || ) {
            return ;
        }

        if(column < 0 || column >= board[row].length) {
            return ;
        }

        if(track[row][column] == 1) {
            return;
        }

        // if match the word, do searching...
        if(board[row][column] == words[index]) {
            track[row][column] = 1;

            int[][] newTrackBottom = deepCopyIntMatrix(track);
            int[][] newTrackRight = deepCopyIntMatrix(track);
            int[][] newTrackTop = deepCopyIntMatrix(track);
            int[][] newTrackLeft = deepCopyIntMatrix(track);

            // bottom
            doSearch(board, words, newTrackBottom,index+1, row+1, column, flag);
            // right
            doSearch(board, words, newTrackRight,index+1, row, column+1, flag);
            // top
            doSearch(board, words, newTrackTop,index+1, row-1, column, flag);
            // left
            doSearch(board, words, newTrackLeft,index+1, row, column-1, flag);
        } else {
            return;
        }

        return ;
    }

    public static int[][] deepCopyIntMatrix(int[][] input) {
        if (input == null)
            return null;
        int[][] result = new int[input.length][];
        for (int r = 0; r < input.length; r++) {
            result[r] = input[r].clone();
        }
        return result;
    }
}

// reference: https://www.nowcoder.com/questionTerminal/14bcbcb7ae3c40c9bdbc5a0861361c29?commentTags=Java

class Solution {
    private boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        // create a two dimension array for tracking.
        // 0: not go through, 1: go through
        int[][] track;
        char[] words = word.toCharArray();
        visited = new boolean[board.length][board[0].length];

        boolean res = false;
        int[] x = new int[1];
        x[0] = 0;

        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[i].length; j++) {
                if(dfs(board, words, 0, i, j)) return true;
            }
        }

        return false;
    }

    public boolean dfs(char[][] board, char[] words, int index, int row, int column) {

        if(index == words.length) return true;
        if(row < 0 || row >= board.length || column < 0 || column >= board[row].length || visited[row][column]) {
            return false;
        }

        if(board[row][column] != words[index]) {
            return false;
        }

        visited[row][column] = true;

        boolean exist = dfs(board, words, index+1,row, column+1)
          || dfs(board, words, index+1, row, column-1)
          || dfs(board, words, index+1, row+1, column)
          || dfs(board, words, index+1, row-1, column);

        // 清除已訪問過的元素
        visited[row][column] = false;

        return exist;
    }
}

// no extra space
// reference: https://leetcode.com/explore/interview/card/top-interview-questions-medium/109/backtracking/797/discuss/27658/Accepted-very-short-Java-solution.-No-additional-space.

class Solution {
    private boolean[][] visited;

    public boolean exist(char[][] board, String word) {
       
        char[] words = word.toCharArray();
        visited = new boolean[board.length][board[0].length];

        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[i].length; j++) {
                if(dfs(board, words, 0, i, j)) return true;
            }
        }

        return false;
    }

    public boolean dfs(char[][] board, char[] words, int index, int row, int column) {

        if(index == words.length) return true;
        if(row < 0 || row >= board.length || column < 0 || column >= board[row].length || visited[row][column]) {
            return false;
        }

        if(board[row][column] != words[index]) {
            return false;
        }

        visited[row][column] = true;
        
        // 從該點(row,column)出發，確認是否有word...
        boolean exist = dfs(board, words, index+1,row, column+1)
          || dfs(board, words, index+1, row, column-1)
          || dfs(board, words, index+1, row+1, column)
          || dfs(board, words, index+1, row-1, column);

        // 清除已訪問過的元素
        visited[row][column] = false;

        return exist;
    }
}