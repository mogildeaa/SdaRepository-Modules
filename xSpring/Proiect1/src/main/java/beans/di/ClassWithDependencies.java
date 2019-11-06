package beans.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClassWithDependencies {

    @Autowired
    private DependencyField dependencyField;

    private DependencyConstructor dependencyConstructor;
    private DependencySetter dependencySetter;

    //    SAU, A 2-a varianta
    @Autowired
    public ClassWithDependencies(DependencyConstructor dc) {
        this.dependencyConstructor = dc;
    }

    //    SAU, A 3-a varianta
    @Autowired
    public void setDependencySetter(DependencySetter ds) {
        this.dependencySetter = ds;
    }

    public DependencyField getDependencyField() {
        return dependencyField;
    }

    public DependencyConstructor getDependencyConstructor() {
        return dependencyConstructor;
    }

    public DependencySetter getDependencySetter() {
        return dependencySetter;
    }
}
