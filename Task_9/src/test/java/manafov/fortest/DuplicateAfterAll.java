package manafov.fortest;

import manafov.DoAfterAll;

public class DuplicateAfterAll {
    @DoAfterAll
    public void tearDown1() {
    }

    @DoAfterAll
    public void tearDown2() {
    }
}
