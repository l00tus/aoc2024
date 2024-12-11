import java.util.ArrayList;
import java.util.List;

import days.Day01;
import days.Day02;
import days.Day03;
import days.Day04;
import utils.Day;
public class AdventOfCode {
    public static void main(String[] args) {
        System.out.println("aoc2024 by l00tus");

        List<Day> days = new ArrayList<>();

        days.add(new Day01());
        days.add(new Day02());
        days.add(new Day03());
        days.add(new Day04());

        for(int i = 0 ; i < days.size() ; i++) {
            Day day = days.get(i);
            int dayNumber = i + 1;
            System.out.println("Day " + dayNumber);
            System.out.println("Part 1: " + day.part1());
            System.out.println("Part 2: " + day.part2());
        }
    }
}
