package com.example.tiptime

import junit.framework.TestCase.assertEquals
import org.junit.Test
import java.text.NumberFormat

class TipCalculatorTests {
    // Test function for exact output
    @Test
    fun calculateTip_20PercentNoRoundup() {
        val amount = 10.00
        val tip = 20.00
        val expectedTip = NumberFormat.getCurrencyInstance().format(2)
        val actualTip = calculateTip(amount=amount, tipPercent = tip, roundup = false)

        assertEquals(expectedTip,actualTip)
    }

    // Test function with round up output
    @Test
    fun calculateTip_20PercentWithRoundup() {
        val amount = 10.10
        val tip = 20.00
        val expectedTip = NumberFormat.getCurrencyInstance().format(3)
        val actualTip = calculateTip(amount=amount, tipPercent = tip, roundup = true)

        assertEquals(expectedTip,actualTip)
    }

}