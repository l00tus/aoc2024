package days;

import com.sun.nio.sctp.AbstractNotificationHandler;
import utils.Day;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day06 implements Day {
    File input = new File("./src/input/input06.txt");
    @Override
    public String part1() {
        List<char[]> charList = new ArrayList<>();
        int positions = 0;

        try {
            Scanner scanner = new Scanner(input);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                char[] row = line.toCharArray();
                charList.add(row);

            }

            char[][] map = new char[charList.size()][];

            for (int i = 0; i < charList.size(); i++) {
                map[i] = charList.get(i);
            }

            int m = map.length;
            int n = map[0].length;
            int guardX = 0, guardY = 0;

            for(int i = 0 ; i < m ; i++) {
                for(int j = 0 ; j < n ; j++) {
                    if(map[i][j] == '^') {
                        guardX = j;
                        guardY = i;
                    }
                }
            }

            //north, east, south, west
            int[] dirX = {0, 1, 0, -1};
            int[] dirY = {-1, 0, 1, 0};
            int dir = 0;

            while(true) {
                if(guardX < 0 || guardX >= n || guardY < 0 || guardY >= m) {
                    break;
                }

                map[guardY][guardX] = 'X';
                int futureX = guardX + dirX[dir];
                int futureY = guardY + dirY[dir];

                if(futureX < 0 || futureX >= n || futureY < 0 || futureY >=m) {
                    break;
                }

                if(map[futureY][futureX] == '#') {
                    dir = (dir + 1) % 4;
                } else {
                    guardX = futureX;
                    guardY = futureY;
                }
            }
            for(int i = 0 ; i < m ; i++) {
                for(int j = 0 ; j < n ; j++) {
                    if(map[i][j] == 'X') {
                       positions++;
                    }
                }
            }

            return String.valueOf(positions);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String part2() {
        return null;
    }
}
