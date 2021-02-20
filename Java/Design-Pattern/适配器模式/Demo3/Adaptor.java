/**
 * 对象适配器，基于组合
 */
public class Adaptor implements ITarget {
    private Adaptee adaptee;

    public Adaptor(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    public void f1() {
        adaptee.fa();
    }
    public void f2() {
        adaptee.fb();
    }
    public void f3() {
        adaptee.fc();
    }
}
