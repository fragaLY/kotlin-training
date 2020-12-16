import resistor.Band
import resistor.Resistor
import resistor.Type

class TestObjects {

    companion object {

        //region CARDS
        const val VISA_VALID = "4263 9826 4036 9298"
        const val JCB_VALID = "3566 1234 4301 0419"

        const val VISA_NOT_VALID = "4263 9826 4026 9298"
        const val JCB_NOT_VALID = "3566 1234 4321 0419"

        const val NOT_VALID_CARD = "1125 1235 5124 1251"
        const val EMPTY_CARD = ""
        const val BLANK_CARD = "    "
        //endregion

        //region RESISTORS
        val RESISTOR_1 = Resistor(Band(Type.BLACK), Band(Type.BLUE), Band(Type.BROWN))
        val RESISTOR_2 = Resistor(Band(Type.BROWN), Band(Type.YELLOW), Band(Type.RED))
        val RESISTOR_3 = Resistor(Band(Type.GREEN), Band(Type.ORANGE), Band(Type.ORANGE))
        val RESISTOR_4 = Resistor(Band(Type.RED), Band(Type.RED), Band(Type.BLUE))
        val RESISTOR_5 = Resistor(Band(Type.ORANGE), Band(Type.GREEN), Band(Type.GREEN))
        val RESISTOR_6 = Resistor(Band(Type.YELLOW), Band(Type.BROWN), Band(Type.YELLOW))
        val RESISTOR_7 = Resistor(Band(Type.BLUE), Band(Type.BLACK), Band(Type.BLACK))
        //endregion

    }
}