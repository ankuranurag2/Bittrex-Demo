package ankuranurag2.biitrex

import android.os.Build
import androidx.annotation.RequiresApi

/**
 * created by ankur on 19/3/20
 */
@RequiresApi(Build.VERSION_CODES.N)
fun main() {
    getWordCount("Hi, My Name is Ankur. I love programming! . I love android too.")
}

@RequiresApi(Build.VERSION_CODES.N)
private fun getWordCount(string: String) {
    val wordsList = string.split(" ")
    val map = hashMapOf<String, Int>()
    wordsList.forEach {
        if (map.containsKey(it.toLowerCase())) {
            val count = map[it.toLowerCase()]
            println("Already there in map : $it $count")
            map[it.toLowerCase()] = (count ?: 0) + 1
        } else
            map[it.toLowerCase()] = 1
    }

    map.forEach { s, i ->
        println("Occurence of $s is $i")
    }
}