package subtask1

class Combinator {

    fun checkChooseFromArray(array: Array<Int>): Int? {
        if (array.isEmpty() || array.size < 2 || array[0] < 0 || array[1] <= 0) return null
        val m = array[0]
        val n = array[1]
        val factorialN = factorial(n)
        for (i in 1..n) {
            val nMinusI = n - i
            val factorialNminusI = factorial(nMinusI)
            val factorialI = factorial(i)
            val result = factorialN / factorialNminusI / factorialI
            if (result >= m) return i
        }
        return null
    }

    private tailrec fun factorial(n: Int, f: Long = 1): Long {
        return if (n < 2) f else factorial(n - 1, f * n)
    }
}
