public class WinnerState implements State {
    GumballMachine gumballMachine;

    public WinnerState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    public void insertQuarter() {
        System.out.println("winner insert");
    }

    public void ejectQuarter() {
        System.out.println("winner eject");
    }

    public void turnCrank() {
        System.out.println("winner turnCrank");
    }

    public void dispense() {
        System.out.println("You are a winner");
        gumballMachine.releaseBall();
        if (gumballMachine.getCount() == 0) {
            gumballMachine.setState(gumballMachine.getSoldOutState());
        } else {
            gumballMachine.releaseBall();
            if (gumballMachine.getCount() > 0) {
                gumballMachine.setState(gumballMachine.getNoQuarterState());
            } else {
                System.out.println("out");
                gumballMachine.setState(gumballMachine.getSoldOutState());
            }
        }
    }
}
