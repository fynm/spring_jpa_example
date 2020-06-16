package com.javaPractice.jpa.basics.springJpaExample;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.javaPractice.jpa.basics.springJpaExample.jpa.PersonJpaRepository;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class PersonJpaRepositoryTest {

    @BeforeAll
    public static void before(){
        System.out.println("Before");
    }

    @AfterAll
    public static void after(){
        System.out.println("After");
    }

    @Test
    public void sum_with3Numbers(){
        PersonJpaRepository myMath = new PersonJpaRepository();
        int result = myMath.getSum(new int[] {1, 2, 3});
        //check that the result is 6
        assertEquals(6, result);
        System.out.println(result);
    }

    @Test
    public void sum_withFailure(){
        PersonJpaRepository myMath = new PersonJpaRepository();
        int result = myMath.getSum(new int[] {1, 2, 3});
        //check that the result is 5 but will fail
        assertEquals(5, result);
        System.out.println(result);
    }

    
}