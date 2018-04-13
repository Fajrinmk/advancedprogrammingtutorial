package tallycounter;


public class AtomicIntegerMain {
    public static void main(String[] args) {
        AtomicTallyCounter atomicCounter = new AtomicTallyCounter();

        /* Increase this variable value to make the thread process
        slower, so you can see the log in console more clearly */
        int buyingRate = 150;

        /* Total Ticket Ordered is 150 ticket. So the tally
        counter must show 150 at the end of the thread */
        OnlineTicketShow keeShop = new OnlineTicketShow("Kee Shop",
                atomicCounter, 30, buyingRate);
        keeShop.start();

        OnlineTicketShow saharaShop = new OnlineTicketShow("Sahara Shop",
                atomicCounter, 60, buyingRate);
        saharaShop.start();

        OnlineTicketShow gordonShop = new OnlineTicketShow("Gordon Shop",
                atomicCounter, 25, buyingRate);
        gordonShop.start();

        OnlineTicketShow barbaraShop = new OnlineTicketShow("Barbara Shop",
                atomicCounter, 35, buyingRate);
        barbaraShop.start();

        TallyCounterChecker threadChecker = new TallyCounterChecker(atomicCounter, buyingRate);

        //Thread that check the ticket counter
        threadChecker.start();

    }
}

