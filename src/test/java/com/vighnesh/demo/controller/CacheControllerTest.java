package com.vighnesh.demo.controller;

import com.vighnesh.demo.exceptions.DependencyException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
class CacheControllerTest {

    @Autowired
    private CacheController controller;

    @BeforeEach
    void setUp() {
        controller.set("apple", "1");
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void get() {
        Assert.isTrue(controller.get("apple").getValue().equals("1"));
    }

    @Test
    void getExceptionCase() {
        try {
            controller.get("Mango");
        }catch (Exception e){
            System.out.println(e.getClass());
            Assert.isTrue(e instanceof DependencyException);
        }
    }

    @Test
    void set() {
        controller.set("orange", "2");
        Assert.isTrue(controller.get("orange").getValue().equals("2"));
    }
}