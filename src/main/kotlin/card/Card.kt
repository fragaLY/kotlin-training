package card

data class Card(val number: String)

enum class Type(val regexp: String) {
    VISA("^4[0-9]\\d+$"),
    JCB("^(?:35[2-8][0-9])\\d+$");
}

interface Validator {
    fun validate(card: Card): Boolean
}

class LuhnValidator : Validator {

    override fun validate(card: Card) =
        Type.values()
            .map { it.regexp }
            .any { Regex(it) matches card.number.filterNot(Char::isWhitespace) }
                && card.number
            .filterNot(Char::isWhitespace)
            .map { it.toDigit() }
            .mapIndexed { index, value ->
                if (index % 2 == 1) value * 2 % 9 else value
            }
            .sum()
            .endsWithZero()
}

private fun Int.endsWithZero() = this % 10 == 0
private fun Char.toDigit() = this.toInt().minus('0'.toInt())

