package generic;

public class Parent<T, U> {
    T objT;
    U objU;

    Parent(T objT, U objU) {
        this.objT = objT;
        this.objU = objU;
    }

    public void show() {
        System.out.println("First name: " + objT);
        System.out.println("Age: " + objU);
    }
}
