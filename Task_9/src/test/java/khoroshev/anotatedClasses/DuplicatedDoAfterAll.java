package khoroshev.anotatedClasses;

import khoroshev.anotations.DoAfterAll;

public class DuplicatedDoAfterAll extends SuccessClass{
    @DoAfterAll
    public int wrongMethod() {
        return 6;
    }
}
