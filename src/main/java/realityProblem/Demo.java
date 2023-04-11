package realityProblem;

import java.util.ArrayList;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        List<Integer> arr = List.of(15, 2, 15, 100, 982, -12, 12);
        System.out.println("Third greates value: " + resolve(arr));
    }

    static Integer resolve(List<Integer> inputArr) {
        if (inputArr.size() < 3 ) {
            throw new IllegalArgumentException("Illegal");
        }

        Integer first = inputArr.get(0);
        Integer second = Integer.MIN_VALUE;
        Integer third = Integer.MIN_VALUE;

        for (int i=1; i<inputArr.size(); ++i) {
            if(first < inputArr.get(i)) {
                third = second;
                second = first;
                first = inputArr.get(i);
            }

            else if(second < inputArr.get(i)) {
                third = second;
                second = inputArr.get(i);
            }

            else if(third < inputArr.get(i)) {
                third = inputArr.get(i);
            }
        }

        return third;
    }
}
