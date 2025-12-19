package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class LionTest {

    private Lion lion;

    @Mock
    private Feline feline;

    @BeforeEach
    void setUp() throws Exception {
        lion = new Lion(feline, "Самец");
    }

    @Test
    void getKittensTest() throws Exception {
        Mockito.when(feline.getKittens()).thenReturn(1);
        int actual = lion.getKittens();

        assertEquals(1, actual, "Wrong count of lion kittens");
    }

    @Test
    public void doesHaveManeExceptionTest() {
        Executable executable = () -> new Lion(feline, "incorrect");

        assertThrows(
                Exception.class,
                executable
        );
    }

    @Test
    public void getFoodReturnsCorrectFoodTest() throws Exception {
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.getFood("Хищник")).thenReturn(expected);
        List<String> actual = lion.getFood();

        assertEquals(expected, actual, "Food list is not correct for Lion");
    }

    @Test
    public void getFoodCallsGetFoodTest() throws Exception {
        Feline spyFeline = Mockito.spy(new Feline());
        Lion spyLion = new Lion(spyFeline, "Самец");
        spyLion.getFood();

        Mockito.verify(spyFeline).getFood("Хищник");
    }
}