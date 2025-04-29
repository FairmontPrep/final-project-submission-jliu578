import java.util.*;

public class PathFinding {
    static int[][] A = {
            {0,0,0,0,0,0,0,0,0,0,1},
            {0,0,0,0,0,0,0,0,0,0,1},
            {0,0,0,0,0,0,0,0,0,0,1},
            {0,0,0,0,0,0,0,0,0,0,1},
            {0,0,0,0,0,0,0,0,0,0,1},
            {0,0,0,0,0,0,0,0,0,0,1},
            {1,1,1,1,1,1,1,1,1,1,1}
    };

    static int[][] B = {
            {0,0,0,0,0,0,0,0,0,1,0},
            {0,0,0,0,0,0,0,0,0,1,0},
            {0,0,0,0,0,0,0,0,1,1,0},
            {0,0,0,0,0,0,0,0,1,0,0},
            {0,0,0,0,0,0,1,1,1,0,0},
            {0,0,0,0,0,0,1,0,0,0,0},
            {1,1,1,1,1,1,1,0,0,0,0},
    };

    static ArrayList<String> answerList = new ArrayList<>();
    static boolean[][] visited1 = new boolean[A.length][A[0].length];
    static boolean[][] visited2 = new boolean[B.length][B[0].length];

    private static void dfs(int[][] matrix, boolean[][] visited, int row, int col) {
        if (row < 0 || row >= matrix.length || col < 0 || col >= matrix[0].length) return;
        if (matrix[row][col] != 1 || visited[row][col]) return;

        visited[row][col] = true;
        answerList.add("[" + row + "][" + col + "]");

        dfs(matrix, visited, row - 1, col);
        dfs(matrix, visited, row + 1, col);
        dfs(matrix, visited, row, col - 1);
        dfs(matrix, visited, row, col + 1);
    }

    public static void main(String[] args) {

        System.out.println("A");
        int componentCount = 1;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (A[i][j] == 1 && !visited1[i][j]) {
                    dfs(A, visited1, i, j);
                    System.out.println("Component " + componentCount++ + ": " + answerList);
                    answerList.clear();
                }
            }
        }

        System.out.println("B");
        componentCount = 1;
        for (int i = 0; i < B.length; i++) {
            for (int j = 0; j < B[0].length; j++) {
                if (B[i][j] == 1 && !visited2[i][j]) {
                    dfs(B, visited2, i, j);
                    System.out.println("Component " + componentCount++ + ": " + answerList);
                    answerList.clear();
                }
            }
        }
    }
}
