package game

import extension.increment
import model.Board
import model.Direction
import model.MovableEntity
import java.awt.event.KeyEvent

object GameAnalyzer {
    fun isBeyondBounds(x: Int, y: Int): Boolean = !(x >= 0 && x < GameConstants.BOARD_SIZE && y >= 0 && y < GameConstants.BOARD_SIZE)
    fun isOccupied(x: Int, y: Int, b: Board): Boolean = !(b[x, y].innerFootprint == null)
    fun isPossiblePosition(x: Int, y: Int, b: Board): Boolean = !isBeyondBounds(x, y) && !isOccupied(x, y, b)
    fun isKeyAllowed(k: Int, e: MovableEntity): Boolean = !((k == KeyEvent.VK_UP && e.direction == Direction.DOWN) || (k == KeyEvent.VK_DOWN && e.direction == Direction.UP) || (k == KeyEvent.VK_LEFT && e.direction == Direction.RIGHT) || (k == KeyEvent.VK_RIGHT && e.direction == Direction.LEFT))
    fun isKeySupported(k: Int): Boolean = k in listOf(KeyEvent.VK_UP, KeyEvent.VK_DOWN, KeyEvent.VK_LEFT, KeyEvent.VK_RIGHT)

    fun firstNextPossibleMovingDirection(e: MovableEntity, b: Board): Direction {
        val excluded = HashSet<Direction>()
        with(e) {
            if (!isPossiblePosition(x - 1, y, b)) excluded.add(Direction.LEFT)
            if (!isPossiblePosition(x + 1, y, b)) excluded.add(Direction.RIGHT)
            if (!isPossiblePosition(x, y - 1, b)) excluded.add(Direction.UP)
            if (!isPossiblePosition(x, y + 1, b)) excluded.add(Direction.DOWN)


            // Moves we're sure we can work with
            val safeDirections = Direction.values().filter { it !in excluded && it != Direction.NONE }
            return when (direction) {
                in safeDirections -> direction
                else -> safeDirections.firstOrNull() ?: Direction.NONE
            }
        }


    }

    fun bestPossibleMovingDirectionWithinCross(e: MovableEntity, b: Board): Direction {
        val weights = hashMapOf(*Direction.values().toList().filter { it != Direction.NONE }.map { a -> Pair(a, 0) }.toTypedArray())

        with(e) {
            (1 until GameConstants.BOARD_SIZE)
                    .takeWhile { isPossiblePosition(x - it, y, b) }
                    .forEach { weights.increment(Direction.LEFT) }
            (1 until GameConstants.BOARD_SIZE)
                    .takeWhile { isPossiblePosition(x + it, y, b) }
                    .forEach { weights.increment(Direction.RIGHT) }
            (1 until GameConstants.BOARD_SIZE)
                    .takeWhile { isPossiblePosition(x, y - it, b) }
                    .forEach { weights.increment(Direction.UP) }
            (1 until GameConstants.BOARD_SIZE)
                    .takeWhile { isPossiblePosition(x, y + it, b) }
                    .forEach { weights.increment(Direction.DOWN) }

        }
        return weights.toList().sortedByDescending { (_, value) -> value }.first().let { if (it.second != 0) it.first else Direction.NONE }
    }
}
