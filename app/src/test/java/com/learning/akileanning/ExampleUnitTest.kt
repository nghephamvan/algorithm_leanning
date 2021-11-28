package com.learning.akileanning

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    val inputArray = intArrayOf(4, 1, 11, 12, 99, 55, 2, 3, 7,3 , 5)
    val array2D = arrayOf(intArrayOf(1,2,3), intArrayOf(4,5,6), intArrayOf(7,8,9))

    /**
     * [0 ,0 ]
     * [0 ,1 ] [1 ,0 ]
     * [2 ,0 ] [1 ,1 ] [0 ,2 ]
     * [0 ,3 ] [1 ,2 ] [2 ,1 ] [3 , 0]
     * [4 ,0 ] [3 ,1 ] [2 ,2 ] [1 , 3] [0 ,4 ]
     * [1 ,4 ] [2 ,3 ] [3 ,2 ] [4, 1]
     * [4 ,2 ] [3 ,3 ] [2, 4]
     * [3 ,4 ] [4 ,3 ]
     * [4 ,4 ]
     */

    fun printArray(array2D: Array<IntArray>): IntArray? {
        val size = array2D.size * array2D[0].size
        val result = IntArray(size)

        var index = 0
        for (row in 0 until array2D.size * 2) {
            val reverse = row > array2D.lastIndex
            val startIndex = if (reverse) {row - array2D.lastIndex} else {0}
            val endIndex = if (reverse) {array2D.lastIndex} else row
            var j = endIndex
            var i = startIndex
            while (i in startIndex..endIndex) {
                if (row%2 == 0) {
                    result[index] = array2D[j][i]

                } else {
                    result[index] = array2D[i][j]
                }
                index++
                j--
                i++
            }
        }

        return result
    }

    fun findDiagonalOrder(mat: Array<IntArray>): IntArray? {
        if (mat.isNullOrEmpty()) return IntArray(0)
        val rowSize = mat.size
        val colSize = mat[0].size

        val result = IntArray(rowSize * colSize)

        var isUp = true

        var row = 0
        var col = 0
        var index = 0

        while (row < rowSize && col < colSize) {
            result[index++] = mat[row][col]

            val newRow = row + if (isUp) -1 else 1
            val newCol = col + if (isUp) 1 else -1

            if (newRow !in 0 until rowSize || newCol !in 0 until colSize) {
                if (isUp) {
                    row += if (col == colSize - 1) 1 else 0
                    col += if (col < colSize - 1) 1 else 0
                } else {
                    col += if (row == rowSize - 1) 1 else 0
                    row += if (row < rowSize - 1) 1 else 0
                }
                isUp = !isUp;
            }  else {
                row = newRow
                col = newCol
            }
        }
        return result
    }


    fun insertSort(numbers: IntArray) {
        for (i in numbers.indices) {
            val value = numbers[i]
            var j = i - 1
            while (j >= 0 && numbers[j] > value) {
                numbers[j + 1] = numbers[j]
                j -= 1
            }
            numbers[j + 1] = value
        }
    }

    @Test
    fun addition_isCorrect() {
        val result = findDiagonalOrder(array2D)
        println(result.contentToString())

        assertEquals(4, 2 + 2)
    }
}