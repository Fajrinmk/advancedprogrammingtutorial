package tallycounter;

public class TallyCounterChecker implements Runnable {

    private AtomicTallyCounter atomicTallyCounterReference;
    private volatile SynchronizedTallyCounter synchronizedTallyCounterReference;
    private Thread thread;
    private int sleepTime;

    public TallyCounterChecker(AtomicTallyCounter atomicTallyCounterReference, int sleepTime) {
        this.atomicTallyCounterReference = atomicTallyCounterReference;
        this.sleepTime = sleepTime;
    }

    public TallyCounterChecker(SynchronizedTallyCounter synchronizedTallyCounterReference,
                               int sleepTime) {
        this.synchronizedTallyCounterReference = synchronizedTallyCounterReference;
        this.sleepTime = sleepTime;
    }


    public void start() {
        if (thread == null) {
            thread = new Thread(this, "Tally Counter Checker");
            thread.start();
        }
    }

    @Override
    public void run() {
        System.out.println("Running " + "Tally Counter Checker");
        try {
            for (int i = 65; i > 0; i--) {
                if (checkType()) {
                    System.out.println("Total Ticket ordered in Tally Counter Is : "
                            + atomicTallyCounterReference.value());
                } else {
                    System.out.println("Total Ticket ordered in Tally Counter Is : "
                            + synchronizedTallyCounterReference.value());
                }
                Thread.sleep(sleepTime);
            }
        } catch (InterruptedException e) {
            System.out.println("Tally Counter Checker interrupted.");
        }
        System.out.println("Tally Counter Checker closed.");

    }

    private boolean checkType() {
        return atomicTallyCounterReference != null ? true : false;
    }
}
