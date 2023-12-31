package com.skillsoft.mocks;

import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ComparatorMock {

    @Test
    public void mockComparator() {

        Comparator<String> comparatorMock = mock(Comparator.class);

//        System.out.println("toString() of Comparator: " + comparatorMock);
//        System.out.println("getClass() of Comparator: " + comparatorMock.getClass());
//        System.out.println("comparatorMock instanceof Comparator: " + (comparatorMock instanceof Comparator));

        when(comparatorMock.compare("Alice", "Bob")).thenReturn(1);
        when(comparatorMock.compare("Bob", "Charles")).thenReturn(1);
        when(comparatorMock.compare("Alice", "Charles")).thenReturn(1);

        when(comparatorMock.compare("Bob", "Alice")).thenReturn(-1);
        when(comparatorMock.compare("Charles", "Bob")).thenReturn(-1);
        when(comparatorMock.compare("Charles", "Alice")).thenReturn(-1);

        when(comparatorMock.compare("Alice", "Alice")).thenReturn(0);
        when(comparatorMock.compare("Bob", "Bob")).thenReturn(0);
        when(comparatorMock.compare("Charles", "Charles")).thenReturn(0);

        assertTrue(comparatorMock.compare("Alice", "Charles") > 0);
        assertTrue(comparatorMock.compare("Charles", "Bob") < 0);
        assertEquals(0, comparatorMock.compare("Bob", "Bob"));

    }
}
