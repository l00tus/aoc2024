package days;

import utils.Day;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day07 implements Day {
    File input = new File("./src/input/input07.txt");

    public static void generateOperators(String current, int size, List<String> operators) {
        if (size == 0) {
            operators.add(current);
            return;
        }

        generateOperators(current + "+", size - 1, operators);
        generateOperators(current + "*", size - 1, operators);
    }
    @Override
    public String part1() {
        long total = 0;
        try {
            Scanner scanner = new Scanner(input);

            while(scanner.hasNextLine()) {
                String target = scanner.next().replace(":", "");
                String[] nums = scanner.nextLine().trim().split(" ");
                List<String> operators = new ArrayList<>();
                generateOperators("", nums.length - 1, operators);
                boolean isValid = false;

                for(String op: operators) {
                    long result = Integer.parseInt(nums[0]);
                    for (int i = 0; i < nums.length - 1; i++) {
                        if (op.charAt(i) == '+') {
                            result += Integer.parseInt(nums[i + 1]);
                        } else {
                            result *= Integer.parseInt(nums[i + 1]);
                        }
                    }

                    if(String.valueOf(result).equals(target)) {
                        isValid = true;
                        break;
                    }
                }

                if(isValid) {
                    total += Long.parseLong(target);
                }

            }

            return String.valueOf(total);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String part2() {
        return null;
    }
}
