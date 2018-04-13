package tallycounter;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicTallyCounter {
    private AtomicInteger counter = new AtomicInteger(0);

    public int increment() {
        return counter.incrementAndGet();
    }

    public int decrement() {
        return counter.decrementAndGet();
    }

    public int value() {
        return counter.get();
    }
}
