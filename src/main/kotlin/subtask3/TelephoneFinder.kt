package subtask3

class TelephoneFinder {

    fun findAllNumbersFromGivenNumber(number: String): Array<String>? {
        number.toIntOrNull()?.takeIf { it > 0 } ?: return null
        val result = mutableListOf<String>()
        number.forEachIndexed { index, c ->
            val neighbour = neighbors(c)
            neighbour.forEach { cNew ->
                val numberNew = number.replaceRange(index, index+1, cNew.toString())
                result.add(numberNew)
            }
        }
        return if (result.isNotEmpty()) result.toTypedArray() else null
    }

    private fun neighbors(num: Char) = when(num) {
        '1' -> arrayOf('2', '4')
        '2' -> arrayOf('1', '3', '5')
        '3' -> arrayOf('2', '6')
        '4' -> arrayOf('1', '5', '7')
        '5' -> arrayOf('2', '4' , '6' ,'8')
        '6' -> arrayOf('3', '5', '9')
        '7' -> arrayOf('4', '8')
        '8' -> arrayOf('5', '7', '9', '0')
        '9' -> arrayOf('6', '8')
        '0' -> arrayOf('8')
        else -> arrayOf()
    }
}
