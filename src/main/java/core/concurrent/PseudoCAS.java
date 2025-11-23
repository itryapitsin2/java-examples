package core.concurrent;

public class PseudoCAS<T> {
    private T value;

    public synchronized T get() {
        return value;
    }

    public synchronized T compareAndSwap(T expectedValue, T newValue) {
        T oldValue = value;
        if (oldValue.equals(expectedValue)) {
            value = newValue;
        }
        return oldValue;
    }

    public synchronized boolean compareAndSet(T expectedValue, T newValue) {
        return expectedValue.equals(compareAndSwap(expectedValue, newValue));
    }
}
