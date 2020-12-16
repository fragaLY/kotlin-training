package validator

import TestObjects
import card.Card
import card.LuhnValidator
import card.Validator
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Tag
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

@DisplayName(value = "Luhn validator unit tests")
@Tag(value = "#luhn-validator")
internal class LuhnValidatorTest {

    lateinit var validator: Validator;

    @BeforeEach
    internal fun setUp() {
        validator = LuhnValidator()
    }

    @ParameterizedTest
    @MethodSource("cards")
    fun `validate cards`(card: Card, expected: Boolean) {
        Assertions.assertEquals(expected, validator.validate(card))
    }

    companion object {
        @JvmStatic
        fun cards() = listOf(
            Arguments.of(Card(TestObjects.NOT_VALID_CARD), false),
            Arguments.of(Card(TestObjects.VISA_NOT_VALID), false),
            Arguments.of(Card(TestObjects.JCB_NOT_VALID), false),
            Arguments.of(Card(TestObjects.BLANK_CARD), false),
            Arguments.of(Card(TestObjects.EMPTY_CARD), false),
            Arguments.of(Card(TestObjects.VISA_VALID), true),
            Arguments.of(Card(TestObjects.JCB_VALID), true)
        )
    }

}