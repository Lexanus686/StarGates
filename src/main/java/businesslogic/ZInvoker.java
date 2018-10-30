package businesslogic;

import java.applet.Applet;

public class ZInvoker extends Applet {

    public ZInvoker() {

    }

    public void noArgMethod() {
    }

    public <T> T someMethod(T arg) {
        return arg;
    }

    public int methodReturningInt() {
        return 5;
    }

    public String methodReturningString() {
        return "Hello";
    }
}

