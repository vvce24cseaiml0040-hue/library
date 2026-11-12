package com.library.library_fine_calculator;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class LibraryFineCalculator {
    private static final double DAILY_FINE_RATE = 1.50;

    public double calculateFine(LocalDate dueDate, LocalDate returnDate) {
        if (returnDate.isBefore(dueDate) || returnDate.isEqual(dueDate)) {
            return 0.0;
        }
        
        long overdueDays = ChronoUnit.DAYS.between(dueDate, returnDate);
        return overdueDays * DAILY_FINE_RATE;
    }
}