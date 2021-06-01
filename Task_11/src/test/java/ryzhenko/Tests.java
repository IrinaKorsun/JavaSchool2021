package ryzhenko;

import org.junit.jupiter.api.Test;

public class Tests {

    @Test
    public void test1() throws InterruptedException {
        String filePath = "src/main/resources/ryzhenko/config1.properties";
        Runner.startTransfers(filePath);
    }

    @Test
    public void test2() throws InterruptedException {
        String filePath = "src/main/resources/ryzhenko/config2.properties";
        Runner.startTransfers(filePath);
    }

    @Test
    public void test3() throws InterruptedException {
        String filePath = "src/main/resources/ryzhenko/config3.properties";
        Runner.startTransfers(filePath);
    }
}
