package com.loan.week7.leetcode;

import java.util.Arrays;

public class DFS_FloodFill {
        public int[][] floodFill(int[][] image, int sr, int sc, int color) {
            // Get the original color we need to replace
            int startColor = image[sr][sc];

            // If the starting pixel is already the target color, return immediately
            if (startColor == color) {
                return image;
            }

            // Start the recursive DFS traversal
            dfs(image, sr, sc, startColor, color);

            return image;
        }

        private void dfs(int[][] image, int r, int c, int startColor, int color) {
            // Base cases: Check grid boundaries and ensure the color matches the starting color
            if (r < 0 || r >= image.length || c < 0 || c >= image[0].length || image[r][c] != startColor) {
                return;
            }

            // Update the pixel color
            image[r][c] = color;

            // Traverse 4-directionally (Up, Down, Left, Right)
            dfs(image, r + 1, c, startColor, color); // Down
            dfs(image, r - 1, c, startColor, color); // Up
            dfs(image, r, c + 1, startColor, color); // Right
            dfs(image, r, c - 1, startColor, color); // Left
        }


    public static void main(String[] args) {
        DFS_FloodFill solution = new DFS_FloodFill();

        // Test Case: An image where 1 represents the color to replace
        int[][] image = {
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}
        };

        int sr = 1;      // Starting Row
        int sc = 1;      // Starting Column
        int newColor = 2; // Target Color

        System.out.println("Original Image:");
        printGrid(image);

        // Execute Flood Fill
        int[][] result = solution.floodFill(image, sr, sc, newColor);

        System.out.println("\nImage After Flood Fill:");
        printGrid(result);
    }

    // Helper method to format and print the grid cleanly in the terminal
    private static void printGrid(int[][] grid) {
        for (int[] row : grid) {
            System.out.println(Arrays.toString(row));
        }
    }

}
