package beans.scopes;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestPrototype {

    @Test
    public void testPrototype(){
        ClassPathXmlApplicationContext context;
        context = new ClassPathXmlApplicationContext("spring-beans.xml");

        Prototype bean1 = context.getBean(Prototype.class);
        Assert.assertNotNull(bean1);
        Assert.assertSame(Prototype.class, bean1.getClass());

        Prototype bean2 = context.getBean(Prototype.class);
        Assert.assertNotNull(bean2);
        Assert.assertSame(Prototype.class, bean2.getClass());

        Assert.assertNotSame(bean1, bean2);

        Prototype bean3 = (Prototype) context.getBean("numeDePrototype");
        Assert.assertNotNull(bean3);
        Assert.assertSame(Prototype.class, bean3.getClass());

        context.destroy();
    }
}
