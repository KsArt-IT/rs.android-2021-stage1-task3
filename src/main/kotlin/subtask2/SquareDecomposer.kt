package subtask2

import kotlin.math.sqrt

class SquareDecomposer {

    fun decomposeNumber(number: Int): Array<Int>? {
        if (number < 0) return null
        val numberPow: Long = 1L * number * number
        val list = mutableListOf<Int>()
        var x = 0
        var pow = 0L
        var powNext = 0L
        var value = 0L
        var indexFirst = 0
        var indexSecond = 1
        var correctionFirst = 1
        var correctionSecond = 0
        do {
            do {
                list.clear()
                x = number - 1
                list.add(x)
                pow = 1L * x * x
                value = numberPow - pow
                while (value > 0) {
                    x = sqrt(value.toDouble()).toInt()
                    if (indexFirst == list.size)
                        if (x > 2) x -= correctionFirst else break
                    if (indexSecond == list.size)
                        if (x > 2) x -= correctionSecond else break
                    powNext = 1L * x * x
                    if (powNext != pow && value >= powNext) {
                        pow = powNext
                        list.add(x)
                        value -= pow
                    } else break
                }
                if (value > 0) {
                    if (indexFirst > 0) indexFirst-- else indexFirst = list.size / 2
                }
            } while (value > 0 && indexFirst > 0)
            if (value > 0) {
                indexFirst = list.size / 2
                correctionSecond++
            }
        } while (value > 0 && indexFirst > 1 && correctionSecond <= 2)
        return if (value == 0L) {
            list.sort()
            list.toTypedArray()
        } else null
    }
}
