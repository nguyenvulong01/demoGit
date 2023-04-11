package generic;

import java.util.Collection;

public class School {

    void show(Collection<? extends Parent> parents) {
        System.out.println("\nShow ~~~");
        for (Parent parent : parents) {
            parent.show();
        }
    }
}
