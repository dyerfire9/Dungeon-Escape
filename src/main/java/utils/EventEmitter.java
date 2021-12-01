package utils;

import java.util.ArrayList;

/**
 * Abstract observable class in an observer design pattern. May be used by any class.
 */
public abstract class EventEmitter {
    private ArrayList<EventListener> listeners = new ArrayList<>();

    /**
     * Adds an event listener to the emitter.
     * @param lst The event listener to be added.
     * @return true if an add operation was actually carried out, false otherwise.
     */
    public boolean attach(EventListener lst) {
        if (!listeners.contains(lst)) {
            listeners.add(lst);
            return true;
        }
        return false;
    }

    /**
     * Removes an event listener from the emitter.
     * @param lst The event listener to be removed.
     * @return true if a remove operation was actually carried out, false otherwise.
     */
    public boolean detach(EventListener lst) {
        if (listeners.contains(lst)) {
            listeners.remove(lst);
            return true;
        }
        return false;
    }

    /**
     * Removes all listeners from the emitter.
     */
    public void detachAll() {
        listeners.clear();
    }

    /**
     * Returns a shallow copy of the listener array. Primarily used in unittests.
     * @return A new ArrayList containing the same elements as the "listeners" property.
     */
    public ArrayList<EventListener> getListenersCopy() {
        return new ArrayList<>(listeners);
    }

    /**
     * Emits an event to all listeners.
     * @param eventType An optional parameter for the event type. May be null.
     */
    public void emit(String eventType, Object... args) {
        for (EventListener lst : listeners) {
            lst.onEvent(eventType, args);
        }
    }
}
