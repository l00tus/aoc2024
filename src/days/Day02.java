package days;

import utils.Day;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Day02 implements Day {
    File input = new File("./src/input/input02.txt");

    public boolean checkReportWithDamping(List<Integer> report) {
        for(int i = 0 ; i < report.size() ; i++) {
            List<Integer> modifiedReport = new ArrayList<>(report);
            modifiedReport.remove(i);

            if(checkReport(modifiedReport)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkReport(List<Integer> report) {
        if(report.size() < 2) {
            return true;
        }

        boolean isIncreasing = report.get(0) < report.get(1);
        int previous = report.get(0);

        for(int i = 1 ; i < report.size() ; i++) {
            int delta = Math.abs(report.get(i) - previous);

            if(delta < 1 || delta > 3) {
                return false;
            }

            if((isIncreasing && (report.get(i) < previous)) ||
                    (!isIncreasing && (report.get(i) > previous))) {
                return false;
            }

            previous = report.get(i);
        }

        return true;
    }
    @Override
    public String part1() {
        try {
            Scanner scanner = new Scanner(input);
            int safeReports = 0;

            while(scanner.hasNextLine()) {
                String[] line = scanner.nextLine().split(" ");
                List<Integer> report = Arrays.stream(line)
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());

                if(checkReport(report)) {
                    safeReports++;
                }
            }

            return String.valueOf(safeReports);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String part2() {
        try {
            Scanner scanner = new Scanner(input);
            int safeReports = 0;

            while(scanner.hasNextLine()) {
                String[] line = scanner.nextLine().split(" ");
                List<Integer> report = Arrays.stream(line)
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());

                if(checkReportWithDamping(report)) {
                    safeReports++;
                }
            }

            return String.valueOf(safeReports);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
