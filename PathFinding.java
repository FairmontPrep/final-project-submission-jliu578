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

    private static boolean findPath(int[][] matrix, boolean[][] visited, int row, int col, int endRow, int endCol, List<String> path) {
        if (row < 0 || row >= matrix.length || col < 0 || col >= matrix[0].length) return false;
        if (matrix[row][col] != 1 || visited[row][col]) return false;

        visited[row][col] = true;
        path.add("[" + row + "][" + col + "]");

        if (row == endRow && col == endCol) {
            return true;
        }

        if (findPath(matrix, visited, row - 1, col, endRow, endCol, path) ||
            findPath(matrix, visited, row + 1, col, endRow, endCol, path) ||
            findPath(matrix, visited, row, col - 1, endRow, endCol, path) ||
            findPath(matrix, visited, row, col + 1, endRow, endCol, path)) {
            return true;
        }

        path.remove(path.size() - 1);
        return false;
    }

    public static void main(String[] args) {
        int startRow = 0, startCol = 5;
        int endRow = 6, endCol = 10;

        System.out.println("Path from A:");
        if (findPath(A, visited1, startRow, startCol, endRow, endCol, answerList)) {
            for (String step : answerList) {
                System.out.println(step);
            }
        } else {
            System.out.println("No path found.");
        }

        startRow = 0; startCol = 9;
        endRow = 6; endCol = 0;
        System.out.println("Path from B:");
        if (findPath(B, visited2, startRow, startCol, endRow, endCol, answerList)) {
            for (String step : answerList) {
                System.out.println(step);
            }
        } else {
            System.out.println("No path found.");
        }
    }
}
