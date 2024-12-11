package days;

import utils.Day;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Day05 implements Day {
    File input = new File("./src/input/input05.txt");
    @Override
    public String part1() {
        Map<Integer, List<Integer>> rules =  new HashMap<>();
        int sum = 0;

        try {
            Scanner scanner = new Scanner(input);

            //handling the a|b pairs
            while(scanner.hasNextLine()) {
                String line = scanner.nextLine();

                if(!line.contains("|")) {
                    break;
                }

                String[] pair = line.split("\\|");
                int key = Integer.parseInt(pair[1]);
                int rule = Integer.parseInt(pair[0]);

                if(!rules.containsKey(key)) {
                    rules.put(key, new ArrayList<>());
                }

                rules.get(key).add(rule);
            }

            //handling the pages
            while(scanner.hasNextLine()) {
                String[] line = scanner.nextLine().split(",");
                List<Integer> pages = new ArrayList<>();
                boolean isOrdered = true;

                for (String s : line) {
                    pages.add(Integer.parseInt(s));
                }

                for(int i = 0 ; i < pages.size() - 1 ; i++) {
                    for(int j = i + 1 ; j < pages.size() ; j++) {
                        if(rules.containsKey(pages.get(i))) {
                            if(rules.get(pages.get(i)).contains(pages.get(j))) {
                                isOrdered = false;
                            }
                        }
                    }

                    if(!isOrdered) {
                        break;
                    }
                }

                if(isOrdered) {
                    sum += pages.get(pages.size() / 2);
                }
            }

            return String.valueOf(sum);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public String part2() {
        return null;
    }
}
