package resistor

fun Type.validateThirdBand() = when (this) {
    Type.VIOLET -> throw IllegalArgumentException("Not correct 3rd band type [$this]")
    Type.GREY -> throw IllegalArgumentException("Not correct 3rd band type [$this]")
    Type.WHITE -> throw IllegalArgumentException("Not correct 3rd band type [$this]")
    else -> Unit
}

enum class Type(val value: Int, val multiplier: Int) {
    BLACK(0, 1),
    BROWN(1, 10),
    RED(2, 100),
    ORANGE(3, 1000),
    YELLOW(4, 10_000),
    GREEN(5, 100_000),
    BLUE(6, 1_000_000),
    VIOLET(7, 1),
    GREY(8, 1),
    WHITE(9, 1)
}

data class Band(val type: Type)

data class Resistor(val band1: Band, val band2: Band, val band3: Band) {

    init {
        band3.type.validateThirdBand()
    }

    fun bands() = listOf(band1, band2, band3)
}

interface Calculator {
    fun calculate(resistor: Resistor): Int
}

class ThreeBandResistorCalculator : Calculator {
    override fun calculate(resistor: Resistor) =
        resistor
            .bands()
            .map { it.type }
            .map { it.value to it.multiplier }
            .reduceIndexed { index, acc, band ->
                if (index != 2) (10 * acc.first).plus(band.first) to 1
                else acc.first * band.second to 1
            }.first
}