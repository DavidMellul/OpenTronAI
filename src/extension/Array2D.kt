package extension

inline fun <reified T> Array2D(nRows: Int, nCols: Int, defaultValueInitializer: () -> T): Array<Array<T>> = Array(nRows) { Array(nCols) { defaultValueInitializer() } }
inline fun <reified T> Array2D(size: Int, defaultValueInitializer: () -> T): Array<Array<T>> = Array2D(size, size, defaultValueInitializer)
