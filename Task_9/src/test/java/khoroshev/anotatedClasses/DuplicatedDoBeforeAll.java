package khoroshev.anotatedClasses;

import khoroshev.anotations.DoBeforeAll;

public class DuplicatedDoBeforeAll extends SuccessClass {
    @DoBeforeAll
    public int wrongMethod() {
        return 6;
    }

}
