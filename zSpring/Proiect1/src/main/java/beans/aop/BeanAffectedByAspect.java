package beans.aop;

import org.springframework.stereotype.Component;

@Component
public class BeanAffectedByAspect {

    public void doSomething(){
        System.out.println(this + " did something!");
    }


}
