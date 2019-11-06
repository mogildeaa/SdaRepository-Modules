package beans.scopes;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@Lazy
public class Singleton {
//
//    @Autowired
//    Singleton2 xxx;
//
//    public void f() {
//        xxx.f();
//    }

    /*
           DACA NU AM FI FOLOSIT SPRING, ASTA ERA ABORDAREA PENTRU APELAREA METODEI F.
       Singleton2 xxx1 = new Singleton2();
       Singleton singleton = new Singleton();
       singleton.xxx = xxx1; //CRITIC
       singleton.f();
    */

    @PostConstruct
    public void inIt(){
        System.out.println("init " + this);
    }

    @PreDestroy
    public void destroy(){
        System.out.println("destroy " + this);
    }
}
