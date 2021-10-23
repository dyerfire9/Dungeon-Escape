package InteractiveElements;

import java.util.concurrent.ThreadLocalRandom;

public interface ChangePoints {
    //TODO: refine change range.
    int change = ThreadLocalRandom.current().nextInt(-20, 20);
    int getChange();
}
