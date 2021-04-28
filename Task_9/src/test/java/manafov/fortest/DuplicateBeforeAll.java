package manafov.fortest;

import manafov.DoBeforeAll;

public class DuplicateBeforeAll {
    @DoBeforeAll
    public void setUp1() {
    }

    @DoBeforeAll
    public void setUp2() {
    }
}
