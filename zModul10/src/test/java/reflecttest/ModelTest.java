package reflecttest;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import reflection.Model;

public class ModelTest {

    //testam test model cu reflect fara JUNIT
    public static void main(String[] args) throws Exception {
        Model model = new Model();
        System.out.println(model.getX());

        Field x = model.getClass().getDeclaredField("x");
        x.setAccessible(true);
        Object o = x.get(model);
        System.out.println(o);

        x.set(model, 1);
        System.out.println(model.getX());

        Method serviceMethod = Model.class.getDeclaredMethod("service", int.class);
        serviceMethod.setAccessible(true);
        Object invoke = serviceMethod.invoke(model, 10);
        System.out.println("Method result " + invoke);
        System.out.println("Method efect " + model.getX());
    }
}
