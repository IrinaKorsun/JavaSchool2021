package manafov.fortest;

import manafov.DoAfterAll;
import manafov.DoBeforeAll;

public class BeforeAfterAll {
    @DoAfterAll
    public void tearDown() {
    }

    @DoBeforeAll
    public void setUp() {
    }
}
