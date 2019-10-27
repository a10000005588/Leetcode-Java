// 73 Set Matrix Zeroes  https://leetcode.com/problems/set-matrix-zeroes/


// my solution... using O(m+n) spaces
class Node {
    int i;
    int j;

    public Node(int i, int j) {
        this.i = i;
        this.j = j;
    }
}

class Solution {

    Queue<Node> queue = new LinkedList<Node>();

    public void setZeroes(int[][] matrix) {
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[i].length; j++) {
                if(matrix[i][j] == 0) {
                    Node node = new Node(i, j);

                    queue.offer(node);
                }
            }
        }

        for(Node q : queue){
            for(int i=0; i<matrix[q.i].length; i++) {
                // update row
                matrix[q.i][i] = 0;
            }

            for(int j=0; j<matrix.length; j++){
                // update column
                matrix[j][q.j] = 0;
            }
        }
    }
}

// another solutoin to reach O(1)
// idea is to find the row0 and column0. if there exists (i,j)=0 , set its (i,0) or (0,j) to the 0.
// and iterate all matrix , if (i,j) its (i,0) or (0,j) is 0, then set (i,j) to the 0...