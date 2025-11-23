package core.concurrent;

public class CasCounter {
    private PseudoCAS<Integer> pseudoCAS = new PseudoCAS<>();

    public int getValue() {
        return pseudoCAS.get();
    }

    public int increment() {
        int value;

        do {
            value = getValue();
        } while (value != pseudoCAS.compareAndSwap(value, value + 1));

        return value;
    }
}
