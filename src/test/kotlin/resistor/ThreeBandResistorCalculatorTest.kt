package resistor

import TestObjects
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Tag
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

@DisplayName(value = "Resistor calculator unit tests")
@Tag(value = "#resistor-calculator")
internal class ThreeBandResistorCalculatorTest {

    lateinit var calculator: Calculator

    @BeforeEach
    fun setUp() {
        calculator = ThreeBandResistorCalculator()
    }

    @ParameterizedTest
    @MethodSource("resistors")
    fun `calculate resistors value`(resistor: Resistor, expected: Int) {
        Assertions.assertEquals(expected, calculator.calculate(resistor))
    }

    companion object {
        @JvmStatic
        fun resistors() = listOf(
            Arguments.of(TestObjects.RESISTOR_1, 60),
            Arguments.of(TestObjects.RESISTOR_2, 1400),
            Arguments.of(TestObjects.RESISTOR_3, 53_000),
            Arguments.of(TestObjects.RESISTOR_4, 22_000_000),
            Arguments.of(TestObjects.RESISTOR_5, 3_500_000),
            Arguments.of(TestObjects.RESISTOR_6, 410_000),
            Arguments.of(TestObjects.RESISTOR_7, 60)
        )
    }
}