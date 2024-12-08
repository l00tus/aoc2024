package days;

import utils.Day;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day03 implements Day {
    File input = new File("./src/input/input03.txt");

    @Override
    public String part1() {
        int total = 0;
        try {
            Scanner scanner = new Scanner(input);
            while(scanner.hasNextLine()) {
                String memory = scanner.nextLine();
                int memoryLength = memory.length();

                for(int i = 0 ; i < memoryLength ; i++) {
                    if (memory.startsWith("mul", i) && i + 3 < memoryLength) {
                        if (memory.charAt(i + 3) == '(') {
                            int index = i + 4;
                            StringBuilder left = new StringBuilder();
                            StringBuilder right = new StringBuilder();
                            while (Character.isDigit(memory.charAt(index))) {
                                left.append(memory.charAt(index++));
                            }
                            if (memory.charAt(index++) == ',' && index < memoryLength) {
                                while (Character.isDigit(memory.charAt(index))) {
                                    right.append(memory.charAt(index++));
                                }
                                if (memory.charAt(index) == ')') {
                                    int leftNumber = Integer.parseInt(left.toString());
                                    int rightNumber = Integer.parseInt(right.toString());
                                    total += leftNumber * rightNumber;
                                    i = index;
                                }
                            }
                        }
                    }
                }
            }
            return String.valueOf(total);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String part2() {
        int total = 0;
        boolean isEnabled = true;
        try {
            Scanner scanner = new Scanner(input);
            while(scanner.hasNextLine()) {
                String memory = scanner.nextLine();
                int memoryLength = memory.length();

                for(int i = 0 ; i < memoryLength ; i++) {
                    if(memory.startsWith("do()", i) && i + 4 < memoryLength) {
                        isEnabled = true;
                    } else if (memory.startsWith("don't()", i) && i + 7 < memoryLength) {
                        isEnabled = false;
                    } else if (memory.startsWith("mul", i) && i + 3 < memoryLength && isEnabled) {
                        if (memory.charAt(i + 3) == '(') {
                            int index = i + 4;
                            StringBuilder left = new StringBuilder();
                            StringBuilder right = new StringBuilder();
                            while (Character.isDigit(memory.charAt(index))) {
                                left.append(memory.charAt(index++));
                            }
                            if (memory.charAt(index++) == ',' && index < memoryLength) {
                                while (Character.isDigit(memory.charAt(index))) {
                                    right.append(memory.charAt(index++));
                                }
                                if (memory.charAt(index) == ')') {
                                    int leftNumber = Integer.parseInt(left.toString());
                                    int rightNumber = Integer.parseInt(right.toString());
                                    total += leftNumber * rightNumber;
                                    i = index;
                                }
                            }
                        }
                    }
                }
            }
            return String.valueOf(total);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}