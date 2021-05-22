package shkabrov;

import org.junit.jupiter.api.Test;

public class BankTest {
    @Test
    public void normalWork() {
        Main program = new Main();
        program.SetWorkingTime(3000);
        program.SetEnableDebuggingInformation(false);
        program.Start();
    }

    @Test
    public void twoAccountWork() {
        Main program = new Main();
        program.SetPathToProperties("shkabrov/twoAccountConditions.properties");
        program.SetWorkingTime(3000);
        program.SetEnableDebuggingInformation(false);
        program.Start();
    }

    @Test
    public void watcherWork() {
        Main program = new Main();
        program.SetWorkingTime(2000);
        program.SetEnableDebuggingInformation(false);
        program.SetAccountWithWrongAmountOfMoney();
        program.Start();
    }
}
