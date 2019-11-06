package langproxy;

import javax.xml.ws.Service;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Ceva {

    public static void main(String[] args) {

        ServiceInterface serviceInterface = createProxy();
        String result = serviceInterface.execute();
        System.out.println(result);
    }

    private static ServiceInterface createProxy() {
        ServiceInterface proxy;

        {
            //Get the class loader
            ClassLoader classLoader = Ceva.class.getClassLoader();

            //Construiesc un vector de classloader
            //Class<?> -> orice tip de clasa
            Class<?>[] interfaces = new Class[]{ServiceInterface.class};

            //construiesc un obiect de tipul handler
            InvocationHandler handler = new InvocationHandler() {

                ServiceImplementation serviceImplementation = new ServiceImplementation();
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    System.err.println(method);
                    System.err.println(args);
                    return method.invoke(serviceImplementation, args);
                }
            };

            //construiesc proxy-ul
            proxy = (ServiceInterface) java.lang.reflect.Proxy.newProxyInstance(classLoader, interfaces, handler);

        }

        return proxy;
    }
}
