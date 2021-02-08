import java.util.concurrent.atomic.AtomicLong;

public class IdGenerator2 {
    private AtomicLong id = new AtomicLong(0);
    public IdGenerator2() {}
    private static class SingletonHolder {
        private static final IdGenerator2 instance = new IdGenerator2();
    }

    public static IdGenerator2 getInstance() {
        return SingletonHolder.instance;
    }

    public long getId() {
        return id.incrementAndGet();
    }
}
