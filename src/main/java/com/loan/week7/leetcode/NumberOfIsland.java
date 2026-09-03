package com.loan.week7.leetcode;

public class NumberOfIsland {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int rows = grid.length;
        int cols = grid[0].length;
        int islandCount = 0;

        // Scan the entire grid row by row
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == '1') {
                    // New island discovered
                    islandCount++;
                    // Erase this entire connected island
                    dfs(grid, r, c);
                }
            }
        }

        return islandCount;
    }

    private void dfs(char[][] grid, int r, int c) {
        // Boundary checking and water tracking
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == '0') {
            return;
        }

        // Sink the current piece of land
        grid[r][c] = '0';

        // Flood fill 4-directionally
        dfs(grid, r + 1, c); // Down
        dfs(grid, r - 1, c); // Up
        dfs(grid, r, c + 1); // Right
        dfs(grid, r, c - 1); // Left
    }

    public static void main(String[] args) {
        // Instantiate the solution class
        NumberOfIsland solution = new NumberOfIsland();

        // Test Case 1: A grid with 3 distinct islands
        char[][] grid1 = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };

        // Test Case 2: A grid with 1 giant island
        char[][] grid2 = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };

        // Execute and print results
        System.out.println("Number of Islands (Grid 1): " + solution.numIslands(grid1)); // Expected Output: 3
        System.out.println("Number of Islands (Grid 2): " + solution.numIslands(grid2)); // Expected Output: 1
    }
}

