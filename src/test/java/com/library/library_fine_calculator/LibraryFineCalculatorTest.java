package com.library.library_fine_calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LibraryFineCalculatorTest {

    private LibraryFineCalculator calculator;
    private LocalDate dueDate;

    @BeforeEach
    void setUp() {
        calculator = new LibraryFineCalculator();
        dueDate = LocalDate.of(2026, 6, 1);
    }

    @Test
    void testOnTimeReturn() {
        LocalDate returnDate = LocalDate.of(2026, 6, 1);
        double fine = calculator.calculateFine(dueDate, returnDate);
        assertEquals(0.0, fine, "Fine should be 0.0 for on-time returns");
    }

    @Test
    void testEarlyReturn() {
        LocalDate returnDate = LocalDate.of(2026, 5, 28);
        double fine = calculator.calculateFine(dueDate, returnDate);
        assertEquals(0.0, fine, "Fine should be 0.0 for early returns");
    }

    @Test
    void testOverdueShortPeriod() {
        LocalDate returnDate = LocalDate.of(2026, 6, 4); // 3 days late
        double fine = calculator.calculateFine(dueDate, returnDate);
        assertEquals(4.50, fine, "Fine should be $4.50 for 3 days late");
    }

    @Test
    void testOverdueLongPeriod() {
        LocalDate returnDate = LocalDate.of(2026, 6, 11); // 10 days late
        double fine = calculator.calculateFine(dueDate, returnDate);
        assertEquals(15.00, fine, "Fine should be $15.00 for 10 days late");
    }
}