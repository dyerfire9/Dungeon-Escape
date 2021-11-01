package elements;
import java.util.concurrent.ThreadLocalRandom;

public interface ChangePoints {
    //TODO: Note I kept ThreadLocalRandom here because java.util.Random does not give negative numbers.
    int change = ThreadLocalRandom.current().nextInt(-20, 20);
    int getChange();
}
