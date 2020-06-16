package com.javaPractice.jpa.basics.springJpaExample;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class AssertTest {

    @Test
    public void test(){
        boolean cond = true;
        assertEquals(1, 1);
        assertTrue(cond);
        assertFalse(cond);
        //assertArrayEquals(expected, actual);
        
    }
    
}