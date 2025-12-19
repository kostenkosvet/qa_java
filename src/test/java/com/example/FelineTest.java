package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class FelineTest {

    private Feline feline;

    @BeforeEach
    void setUp() throws Exception {
        feline = new Feline();
    }

    @Test
    public void eatMeatReturnsCorrectFoodTest() throws Exception {
        List<String> actual = feline.eatMeat();
        List<String> expected = List.of("Животные", "Птицы", "Рыба");

        assertEquals(expected, actual, "Food list is not correct for Feline");
    }

    @Test
    public void eatMeatCallsGetFoodTest() throws Exception {
        Feline spyFeline = Mockito.spy(new Feline());
        spyFeline.eatMeat();

        Mockito.verify(spyFeline).getFood("Хищник");
    }

    @Test
    void getFamilyTest() {
        String actual = feline.getFamily();
        assertEquals("Кошачьи", actual, "Wrong type of feline family");
    }

    @Test
    void getKittensTest() {
        int actual = feline.getKittens();
        assertEquals(1, actual, "Wrong count of feline kittens");
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 3, -1, 100})
    void getKittensParametrisedTest(int kittensCount) {
        int actual = feline.getKittens(kittensCount);

        assertEquals(kittensCount, actual, "Wrong count of feline kittens");
    }
}