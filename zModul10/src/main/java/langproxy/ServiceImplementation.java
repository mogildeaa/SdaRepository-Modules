package langproxy;

public class ServiceImplementation implements ServiceInterface {

    @Override
    public String execute() {
        return this + " execute";
    }
}

