package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class FelineParametrisedTest {

    private Feline feline;

    @BeforeEach
    void setUp() throws Exception {
        feline = new Feline();
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 3, -1, 100})
    void getKittensParametrisedTest(int kittensCount) {
        int actual = feline.getKittens(kittensCount);

        assertEquals(kittensCount, actual, "Wrong count of feline kittens");
    }
}
