package beans.factory;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestFactory {

    @Test
    public void testFactory() {

        ClassPathXmlApplicationContext context;
        context = new ClassPathXmlApplicationContext("spring-beans.xml");

        FactoryProduct factoryProduct = context.getBean(FactoryProduct.class);
        Assert.assertNotNull(factoryProduct);

        Product1 product1 = context.getBean(Product1.class);
        Assert.assertNotNull(product1);

//        factoryProduct.createProduct2(); inlocuim cu context.getBean si
//        bagam anotare pe metoda din factory
        Product2 product2 = context.getBean(Product2.class);
        Assert.assertNotNull(product2);
    }
}
