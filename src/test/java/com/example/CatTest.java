package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class CatTest {
    private Cat cat;

    @Mock
    private Feline feline;

    @BeforeEach
    void setUp() {
        cat = new Cat(feline);
    }

    @Test
    void getSoundTest() {
        String actual = cat.getSound();
        assertEquals("Мяу", actual, "Cat should be meowing");
    }

    @Test
    void getFoodTest() throws Exception {
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.eatMeat()).thenReturn(expected);
        List<String> actual = cat.getFood();
        assertEquals(expected, actual, "Food list is not correct for Cat");
    }
}