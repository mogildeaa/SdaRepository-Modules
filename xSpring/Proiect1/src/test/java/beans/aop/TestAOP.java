package beans.aop;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAOP {

    @Test
    public void testDI() {

        ClassPathXmlApplicationContext context;
        context = new ClassPathXmlApplicationContext("spring-beans.xml");

        BeanAffectedByAspect bean = context.getBean(BeanAffectedByAspect.class);
        bean.doSomething();
    }
}
