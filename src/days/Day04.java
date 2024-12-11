package days;

import utils.Day;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day04 implements Day {
    File input = new File("./src/input/input04.txt");

    public int searchAll(char[][] matrix, int row, int col, String word) {
        int m = matrix.length;
        int n = matrix[0].length;
        int length = word.length();
        int count = 0;

        int[] x = {-1, -1, -1, 0, 1, 1, 1, 0};
        int[] y = {-1, 0, 1, 1, 1, 0, -1, -1};

        if (matrix[row][col] != word.charAt(0)) {
            return 0;
        }

        for (int dir = 0; dir < 8; dir++) {
            int currX = row;
            int currY = col;
            boolean match = true;

            for (int i = 1; i < length; i++) {
                currX += x[dir];
                currY += y[dir];

                if (currX < 0 || currX >= m || currY < 0 || currY >= n) {
                    match = false;
                    break;
                }

                if (matrix[currX][currY] != word.charAt(i)) {
                    match = false;
                    break;
                }
            }

            if (match) {
                count++;
            }
        }

        return count;
    }

    @Override
    public String part1() {
        List<char[]> charList = new ArrayList<>();
        int count = 0;
        try {
            Scanner scanner = new Scanner(input);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                char[] row = line.toCharArray();
                charList.add(row);
            }

            char[][] matrix = new char[charList.size()][];

            for (int i = 0; i < charList.size(); i++) {
                matrix[i] = charList.get(i);
            }

            int m = matrix.length;
            int n = matrix[0].length;

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    count += searchAll(matrix, i, j, "XMAS");
                }
            }

            return String.valueOf(count);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String part2() {
        List<char[]> charList = new ArrayList<>();
        int count = 0;
        try {
            Scanner scanner = new Scanner(input);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                char[] row = line.toCharArray();
                charList.add(row);
            }

            char[][] matrix = new char[charList.size()][];

            for (int i = 0; i < charList.size(); i++) {
                matrix[i] = charList.get(i);
            }

            int m = matrix.length;
            int n = matrix[0].length;

            for (int i = 1; i < m - 1; i++) {
                for (int j = 1; j < n - 1; j++) {
                    if(matrix[i][j] != 'A') {
                        continue;
                    }
                    //main diagonal
                    if((matrix[i - 1][j - 1] == 'M' && matrix[i + 1][j + 1] == 'S') || (matrix[i - 1][j - 1] == 'S' && matrix[i + 1][j + 1] == 'M')) {
                        //secondary diagonal
                        if((matrix[i - 1][j + 1] == 'M' && matrix[i + 1][j - 1] == 'S') || (matrix[i - 1][j + 1] == 'S' && matrix[i + 1][j - 1] == 'M')) {
                            count++;
                        }
                    }
                }
            }

            return String.valueOf(count);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
