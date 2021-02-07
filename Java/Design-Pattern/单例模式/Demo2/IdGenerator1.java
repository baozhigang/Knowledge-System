import java.util.concurrent.atomic.AtomicLong;

public class IdGenerator1 {
    private AtomicLong id = new AtomicLong(0);
    private static final IdGenerator1 instance = new IdGenerator1();

    public IdGenerator1() {}
    public static IdGenerator1 getInstance() {
        return instance;
    }

    public long getId() {
        return id.incrementAndGet();
    }
}
