public class SoldState implements State {
    GumballMachine gumballMachine;

    public SoldState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    public void insertQuarter() {
        System.out.println("Please wait, we are already giving you a ball");
    }

    public void ejectQuarter() {
        System.out.println("Sorry, You already turned the crank");
    }

    public void turnCrank() {
        System.out.println("Turning twice");
    }

    public void dispense() {
        gumballMachine.releaseBall();
        if (gumballMachine.getCount() > 0) {
            gumballMachine.setState(gumballMachine.getNoQuarterState());
        } else {
            System.out.println("out of gumballs");
            gumballMachine.setState(gumballMachine.getSoldOutState());
        }
    }
}
