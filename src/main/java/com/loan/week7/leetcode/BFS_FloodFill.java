package com.loan.week7.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class BFS_FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int startColor = image[sr][sc];

        // Guard clause: If the starting pixel is already the target color, do nothing
        if (startColor == color) {
            return image;
        }

        int rows = image.length;
        int cols = image[0].length;

        // Queue to store coordinates as 1D arrays: {row, col}
        Queue<int[]> queue = new LinkedList<>();

        // Step 1: Initialize by adding the starting point
        queue.add(new int[]{sr, sc});
        image[sr][sc] = color; // Change color immediately upon adding to queue

        // Direction vectors for moving Down, Up, Right, Left
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        // Step 2: Loop until there are no more matching neighbors to process
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currRow = current[0];
            int currCol = current[1];

            // Look in all 4 directions
            for (int[] dir : directions) {
                int nextRow = currRow + dir[0];
                int nextCol = currCol + dir[1];

                // Validate boundaries and check if the neighbor matches the starting color
                if (nextRow >= 0 && nextRow < rows && nextCol >= 0 && nextCol < cols
                        && image[nextRow][nextCol] == startColor) {

                    // Update the color and add to queue
                    image[nextRow][nextCol] = color;
                    queue.add(new int[]{nextRow, nextCol});
                }
            }
        }

        return image;
    }

    public static void main(String[] args) {
        BFS_FloodFill solution = new BFS_FloodFill();

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

