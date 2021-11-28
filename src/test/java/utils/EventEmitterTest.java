package utils;

import org.junit.*;

public class EventEmitterTest {

    // Define inner classes so we can instantiate concrete objects in our tests.
    private class TestEmitter extends EventEmitter {}
    private class TestListener implements EventListener {
        private int state = 0;
        @Override
        public void onEvent(String eventType) {
            if (eventType.equals("add")) {
                state++;
            } else {
                state = 0;
            }
        }
    }

    @Test(timeout = 20)
    public void TestAttach() {
        TestEmitter te = new TestEmitter();
        TestListener lst1 = new TestListener();
        TestListener lst2 = new TestListener();
        te.attach(lst1);
        assert te.getListenersCopy().contains(lst1);
        te.attach(lst2);
        assert te.getListenersCopy().contains(lst1);
        assert te.getListenersCopy().contains(lst2);
        boolean successful = te.attach(lst1);
        assert !successful;
        assert te.getListenersCopy().size() == 2;
    }

    @Test(timeout = 20)
    public void TestDetach() {
        TestEmitter te = new TestEmitter();
        TestListener lst1 = new TestListener();
        TestListener lst2 = new TestListener();
        te.attach(lst1);
        boolean successful = te.detach(lst1);
        assert successful;
        assert te.getListenersCopy().isEmpty();
        successful = te.detach(lst2);
        assert !successful;
    }

    @Test(timeout = 20)
    public void TestEmit() {
        TestEmitter te = new TestEmitter();
        TestListener lst1 = new TestListener();
        te.attach(lst1);
        te.emit("add");
        assert lst1.state == 1;
        te.emit("add");
        assert lst1.state == 2;
        te.emit("clr");
        assert lst1.state == 0;
    }
}
