/**
 * 类适配器，基于继承
 */
public class Adaptor extends Adaptee implements ITarget {
    public void f1() {
        super.fa();
    }
    public void f2() {
        super.fb();
    }
    public void f3() {
        super.fc();
    }
}
