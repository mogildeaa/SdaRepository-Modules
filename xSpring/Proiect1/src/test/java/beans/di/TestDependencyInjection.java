package beans.di;

import beans.factory.FactoryProduct;
import beans.factory.Product1;
import beans.factory.Product2;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDependencyInjection {

    @Test
    public void testDI() {

        ClassPathXmlApplicationContext context;
        context = new ClassPathXmlApplicationContext("spring-beans.xml");

        ClassWithDependencies classWithDependencies = context.getBean(ClassWithDependencies.class);
        Assert.assertNotNull(classWithDependencies.getDependencyConstructor());
        Assert.assertNotNull(classWithDependencies.getDependencyField());
        Assert.assertNotNull(classWithDependencies.getDependencySetter());

        A a = context.getBean(A.class);
        Assert.assertNotNull(a);

        ClassWithInterfaceDependencies bean = context.getBean(ClassWithInterfaceDependencies.class);
        Assert.assertNotNull(bean);
        Assert.assertNotNull(bean.getInterfaceDependency());

        ClassWithDependencyQualifier classWithDependencyQualifier = context.getBean(ClassWithDependencyQualifier.class);
        Assert.assertNotNull(classWithDependencyQualifier);
        Assert.assertNotNull(classWithDependencyQualifier.getXxx());
        Assert.assertNotNull(classWithDependencyQualifier.getYyy());

    }

    @Test(expected = org.springframework.beans.factory.UnsatisfiedDependencyException.class)
    public void testDiDoubleImplementation() {

        ClassPathXmlApplicationContext context;
        context = new ClassPathXmlApplicationContext("spring-beans.xml", "spring-beans-double-implementation.xml");

    }
}
