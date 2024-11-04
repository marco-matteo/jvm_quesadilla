package jvm.quesadilla.search

object Search {
    fun search(query: String, data: List<String>, threshold: Int = 2) : List<String> {
        return data.filter { levenshteinDistance(it.lowercase(), query.lowercase()) <= threshold }
    }

    private fun levenshteinDistance(source: CharSequence, target: CharSequence): Int {
        val sourceLength = source.length
        val targetLength = target.length

        if(sourceLength == 0) return targetLength
        if (targetLength == 0) return sourceLength

        var previousRow = IntArray(sourceLength + 1) { it }
        var currentRow = IntArray(sourceLength + 1)

        for (i in 1..targetLength) {
            currentRow[0] = i
            for(j in 1..sourceLength) {
                val insertCost = currentRow[j - 1] + 1
                val deleteCost = previousRow[j] + 1
                val replaceCost = previousRow[j - 1] + if(source[j - 1] == target[i - 1]) 0 else 1

                currentRow[j] = minOf(insertCost, deleteCost, replaceCost)
            }

            val temp = previousRow
            previousRow = currentRow
            currentRow = temp
        }

        return previousRow[sourceLength]
    }
}