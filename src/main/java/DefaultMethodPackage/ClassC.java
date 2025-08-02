package DefaultMethodPackage;

public class ClassC implements DefaultMethodInterfaceA, DefaultMethodInterfaceB{
    @Override
    public void printDefault() {
        DefaultMethodInterfaceA.super.printDefault();
    }
}
