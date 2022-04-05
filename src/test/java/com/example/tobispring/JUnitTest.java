package com.example.tobispring;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

public class JUnitTest {

    static Set<JUnitTest> testObject = new HashSet<>();

    @Test
    void test1(){
        testObject.add(this);
        assertThat(testObject).contains(this);
    }
    @Test
    void test2(){
        testObject.add(this);
        assertThat(testObject).contains(this);
    }
    @Test
    void test3(){
        testObject.add(this);
        assertThat(testObject).contains(this);
    }
}
