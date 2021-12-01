package utils;

/**
 * Interface for a listening class in an observer pattern.
 * Note that there is a class with the same name in java.util.
 */
public interface EventListener {
    /**
     * Method called by the observed class when an event happens.
     * @param eventType An optional string code for the event type. May be null.
     */
    void onEvent(String eventType, Object... args);
}
