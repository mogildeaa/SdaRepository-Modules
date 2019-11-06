package beans.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClassWithInterfaceDependencies {

    @Autowired
    private InterfaceDependency interfaceDependency;

    public InterfaceDependency getInterfaceDependency() {
        return interfaceDependency;
    }
}
