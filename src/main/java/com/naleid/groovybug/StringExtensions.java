package com.naleid.groovybug;

public abstract class StringExtensions {

    private static String append = null;

    private StringExtensions() { }

    public static void initialize() {
        System.out.println("initialized");
        if (append != null) {
            throw new RuntimeException("Already initialized");
        }
        append = "foo";
    }

    public static String appendFoo(String self) {
        return self + append;
    }
}


