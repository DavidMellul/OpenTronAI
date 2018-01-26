package extension

fun <K> HashMap<K, Int>.increment(k: K) {
    put(k, getOrDefault(k, 0) + 1)
}