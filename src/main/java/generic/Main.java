package generic;

import java.sql.Array;
import java.util.Arrays;

public class Main {
    static <T> void showValue(T inputValues) {
        System.out.println("\nShow value ~~~");
        System.out.println(inputValues.getClass().getName() + " : " + inputValues);
    }

    static <E> void showName(E[] inputNames) {
        System.out.println("\nShow name ~~~");
        for(E element: inputNames) {
            System.out.println(element);
        }
    }

    public static void main(String[] args) {
        Chil chil = new Chil("Beel", 25);
        chil.show();
        chil.run("Shoes");
        Chil chil1 = new Chil("Luci", 15);

        School school = new School();
        school.show(Arrays.asList(chil, chil1));

        showValue("Lucifer");
        String[] inputNames = {"Beel", "Luci", "Behe"};
        showName(inputNames);
    }
}
