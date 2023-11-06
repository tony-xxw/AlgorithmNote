package search.course

import javax.print.attribute.IntegerSyntax


fun main() {

    println("查找的目标值 8 下标是 ${binarySearch1(intArrayOf(1, 3, 6, 8, 12, 15, 23, 26, 31, 35), 8)}")
    println("查找的目标值 8 下标是 ${dfs(intArrayOf(1, 3, 6, 8, 12, 15, 23, 26, 31, 35), 8, 0, 9)}")
    println("插入目标是元素8，应该插入的位置是下标 ${binarySearchInsertNotRepeat(intArrayOf(1, 3, 6, 8, 12, 15, 23, 26, 31, 35), 8)}")
    println("插入目标是元素8，应该插入的位置是下标 ${binarySearchInsertRepeat(intArrayOf(1, 3, 6, 8, 8, 8, 8, 12, 15, 23, 26, 31, 35), 8)}")

    //汉诺塔问题
    val A = mutableListOf(1,2,3,4,5,6)
    val B = mutableListOf<Int>()
    solveHanota(A, mutableListOf(), B)
    println(B.joinToString())

}

//移动圆盘
fun move(src: MutableList<Int>, tar: MutableList<Int>) {
    val pan = src.removeAt(src.size - 1)
    tar.add(pan)
}

fun dfs(i: Int, src: MutableList<Int>, buf: MutableList<Int>, tar: MutableList<Int>) {
    if (i == 1) {
        move(src, tar)
        return
    }

    dfs(i - 1, src, tar, buf)
    move(src, tar)
    dfs(i - 1, buf, src, tar)
}

fun solveHanota(A: MutableList<Int>, B: MutableList<Int>, C: MutableList<Int>) {
    val n = A.size
    dfs(n, A, B, C)
}

/* 二分查找：问题 f(i, j) */
fun dfs(nums: IntArray, target: Int, i: Int, j: Int): Int {
    // 若区间为空，代表无目标元素，则返回 -1
    if (i > j) {
        return -1
    }
    // 计算中点索引 m
    val m = (i + j) / 2
    return when {
        nums[m] < target -> {
            // 递归子问题 f(m+1, j)
            dfs(nums, target, m + 1, j)
        }
        nums[m] > target -> {
            // 递归子问题 f(i, m-1)
            dfs(nums, target, i, m - 1)
        }
        else -> {
            // 找到目标元素，返回其索引
            m
        }
    }
}


fun binarySearch(nums: IntArray, target: Int): Int {

    var i = 0
    var j = nums.size - 1

    while (i <= j) {
        var m = i + (j - i) / 2
        when {
            nums[m] > target -> {
                j = m - 1
            }
            nums[m] < target -> {
                i = m + 1
            }
            else -> {
                return m
            }
        }
    }
    return -1
}


fun binarySearch1(nums: IntArray, target: Int): Int {

    var i = 0
    var j = nums.size

    while (i < j) {
        var m = i + (j - i) / 2
        when {
            nums[m] > target -> {
                j = m
            }
            nums[m] < target -> {
                i = m + 1
            }
            else -> {
                return m
            }
        }
    }
    return -1
}


fun binarySearchInsertNotRepeat(nums: IntArray, target: Int): Int {

    var i = 0
    var j = nums.size - 1

    while (i <= j) {
        var m = i + (j - i) / 2
        when {
            nums[m] > target -> {
                j = m - 1
            }
            nums[m] < target -> {
                i = m + 1
            }
            else -> {
                return m
            }
        }
    }
    return i
}


fun binarySearchInsertRepeat(nums: IntArray, target: Int): Int {

    var i = 0
    var j = nums.size - 1

    while (i <= j) {
        var m = i + (j - i) / 2
        when {
            nums[m] > target -> {
                j = m - 1
            }
            nums[m] < target -> {
                i = m + 1
            }
            else -> {
                j = m - 1
            }
        }
    }


    return i
}

