package beans.scopes;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component(value = "numeDePrototype")
@Scope("prototype")
//by default Scope este Singleton, de asta nu-l mai scrii
//cand faci
public class Prototype {

    @PostConstruct
    public void inIt(){
        System.out.println("init " + this);
    }

    @PreDestroy
    public void destroy(){
        System.out.println("destroy " + this);
    }

}
