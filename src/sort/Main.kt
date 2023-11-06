package sort

fun main() {
    val array = intArrayOf(4, 1, 3, 1, 5, 2)
    mergeSort(array, 0, array.size - 1)
    println(array.joinToString())
}


fun selectSort(num: IntArray) {
    num.forEachIndexed { index, i ->

        var k = index
        for (x in index + 1 until num.size) {
            if (num[x] < num[k]) {
                k = x
            }
        }
        val temp = num[index]
        num[index] = num[k]
        num[k] = temp
    }

}

fun bubbleSort(num: IntArray) {
    for (i in num.size - 1 downTo 0) {
        var flag = false
        for (j in 0 until i) {
            if (num[j] >= num[j + 1]) {
                swap(num, j, j + 1)
                flag = true
            }
        }
        if (!flag) break
    }
}

fun insertSort(num: IntArray) {
    for (i in 1 until num.size) {
        val base = num[i]
        var j = i - 1
        while (j >= 0 && num[j] > base) {
            num[j + 1] = num[j]
            j--
        }
        num[j + 1] = base
    }
}

fun quickSort(num: IntArray, left: Int, right: Int) {
    if (left >= right) return
    val pivot = partition(num, left, right)
    quickSort(num, left, pivot - 1)
    quickSort(num, pivot + 1, right)
}

fun partition(nums: IntArray, left: Int, right: Int): Int {
    val medianThree = medianThree(nums, left, left + (right - left) / 2, right)
    swap(nums, left, medianThree)
    var i = left
    var j = right
    while (i < j) {
        while (i < j && nums[j] >= nums[left]) {
            j--
        }
        while (i < j && nums[i] <= nums[left]) {
            i++
        }
        swap(nums, i, j)
    }
    swap(nums, i, left)
    return i
}

fun swap(num: IntArray, old: Int, new: Int) {
    val temp = num[old]
    num[old] = num[new]
    num[new] = temp
}

fun medianThree(nums: IntArray, left: Int, mid: Int, right: Int): Int {
    if ((nums[left] < nums[mid]) xor (nums[left] < nums[right])) {
        return left
    } else if ((nums[mid] < nums[left]) xor (nums[mid] < nums[right])) {
        return mid
    } else {
        return right
    }
}

/* 合并左子数组和右子数组 */
fun merge(nums: IntArray, left: Int, mid: Int, right: Int) {
    // 左子数组区间 [left, mid], 右子数组区间 [mid+1, right]
    // 创建一个临时数组 tmp ，用于存放合并后的结果
    val tmp = IntArray(right - left + 1)
    // 初始化左子数组和右子数组的起始索引
    var i = left
    var j = mid + 1
    var k = 0
    // 当左右子数组都还有元素时，比较并将较小的元素复制到临时数组中
    while (i <= mid && j <= right) {
        if (nums[i] <= nums[j]) tmp[k++] = nums[i++] else tmp[k++] = nums[j++]
    }
    // 将左子数组和右子数组的剩余元素复制到临时数组中
    while (i <= mid) {
        tmp[k++] = nums[i++]
    }
    while (j <= right) {
        tmp[k++] = nums[j++]
    }
    // 将临时数组 tmp 中的元素复制回原数组 nums 的对应区间
    k = 0
    while (k < tmp.size) {
        nums[left + k] = tmp[k]
        k++
    }
}

/* 归并排序 */
fun mergeSort(nums: IntArray, left: Int, right: Int) {
    // 终止条件
    if (left >= right) return  // 当子数组长度为 1 时终止递归
    // 划分阶段
    val mid = (left + right) / 2 // 计算中点
    mergeSort(nums, left, mid) // 递归左子数组
    mergeSort(nums, mid + 1, right) // 递归右子数组
    // 合并阶段
    merge(nums, left, mid, right)
}