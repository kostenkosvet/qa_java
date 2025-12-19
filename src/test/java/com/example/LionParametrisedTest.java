package com.example;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class LionParametrisedTest {

    @Mock
    private Feline feline;

    @ParameterizedTest
    @CsvSource({
            "Самец, true",
            "Самка, false"
    })
    void doesHaveManeTest(String sex, boolean expectedResult) throws Exception {
        Lion maneLion = new Lion(feline, sex);
        boolean actual = maneLion.doesHaveMane();
        assertEquals(expectedResult, actual, "Mane for this sex is incorrect");
    }
}
