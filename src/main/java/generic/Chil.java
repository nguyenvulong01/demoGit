package generic;

public class Chil<T, U>  extends Parent<T, U>  implements Action<T> {

    Chil(Object objT, Object objU) {
        super((T) objT, (U) objU);
    }

    @Override
    public void run(Object o) {
        System.out.println("I am running by " + o);
    }
}
