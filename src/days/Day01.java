package days;

import utils.Day;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Day01 implements Day {
    File input = new File("./src/input/input01.txt");

    @Override
    public String part1() {
        try {
            Scanner scanner = new Scanner(input);
            List<Integer> left = new ArrayList<>();
            List<Integer> right = new ArrayList<>();
            int totalDistance = 0;

            while(scanner.hasNextLine()) {
                left.add(scanner.nextInt());
                right.add(scanner.nextInt());
            }

            left.sort(null);
            right.sort(null);

            for(int i = 0 ; i < left.size() ; i++) {
                int distance = Math.abs(left.get(i) - right.get(i));
                totalDistance += distance;
            }

            return String.valueOf(totalDistance);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String part2() {
        try {
            Scanner scanner = new Scanner(input);
            List<Integer> left = new ArrayList<>();
            List<Integer> right = new ArrayList<>();
            int totalOccurances = 0;

            while(scanner.hasNextLine()) {
                left.add(scanner.nextInt());
                right.add(scanner.nextInt());
            }

            for (Integer leftNumber : left) {
                int occurances = 0;
                for(Integer rightNumber : right) {
                    if (Objects.equals(leftNumber, rightNumber)) {
                        occurances++;
                    }
                }
                totalOccurances += leftNumber * occurances;
            }

            return String.valueOf(totalOccurances);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
