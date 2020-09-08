package tallycounter;

public class OnlineTicketShow implements Runnable {

    private AtomicTallyCounter atomicTallyCounterReference;
    private volatile SynchronizedTallyCounter synchronizedTallyCounterReference;
    private Thread thread;
    private int maxTicketOrdered;
    private String websiteName;
    private int buyingRateinMiliSecond;

    public OnlineTicketShow(String websiteName, AtomicTallyCounter atomicTallyCounterReference,
                                 int maxTicketOrdered, int buyingRateinMiliSecond) {
        this.atomicTallyCounterReference = atomicTallyCounterReference;
        this.maxTicketOrdered = maxTicketOrdered;
        this.websiteName = websiteName;
        this.buyingRateinMiliSecond = buyingRateinMiliSecond;
    }

    public OnlineTicketShow(String websiteName,
                            SynchronizedTallyCounter synchronizedTallyCounterReference,
                            int maxTicketOrdered, int buyingRateinMiliSecond) {
        this.synchronizedTallyCounterReference = synchronizedTallyCounterReference;
        this.maxTicketOrdered = maxTicketOrdered;
        this.websiteName = websiteName;
        this.buyingRateinMiliSecond = buyingRateinMiliSecond;
    }

    public void start() {
        System.out.println(websiteName);
        if (thread == null) {
            thread = new Thread(this, websiteName);
            thread.start();
        }
    }

    @Override
    public void run() {
        System.out.println("Running " + websiteName);
        try {
            for (int i = maxTicketOrdered; i > 0; i--) {
                System.out.println("Website: " + websiteName
                        + ", have sold" + (maxTicketOrdered - i + 1));
                // Let the thread sleep for a while.
                Thread.sleep(buyingRateinMiliSecond);
                if (checkType()) {
                    atomicTallyCounterReference.increment();
                } else {
                    synchronizedTallyCounterReference.increment();
                }
            }
        } catch (InterruptedException e) {
            System.out.println("Website " + websiteName + " interrupted.");
        }

        System.out.println("Website " + websiteName + " closed.");
    }

    private boolean checkType() {
        return atomicTallyCounterReference != null ? true : false;
    }
}
