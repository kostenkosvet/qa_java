package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class AlexLionTest {

    private AlexLion alexLion;

    @Mock
    private Feline feline;

    @BeforeEach
    void setUp() throws Exception {
        alexLion = new AlexLion(feline);
    }

    @Test
    void getFriendsTest() {
        List<String> actual = alexLion.getFriends();
        List<String> expected = List.of("Марти", "Глория", "Мелман");
        assertEquals(expected, actual, "List of Alex's friends is incorrect");
    }

    @Test
    void getPlaceOfLiving() {
        String actual = alexLion.getPlaceOfLiving();
        assertEquals("Нью-Йоркский зоопарк", actual, "Place of Alex living is incorrect");
    }

    @Test
    void getKittens() {
        int actual = alexLion.getKittens();
        assertEquals(0, actual, "Alex doesn't have kittens");
    }
}