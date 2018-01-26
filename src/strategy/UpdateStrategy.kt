package strategy

import game.GameAnalyzer
import model.Board
import model.Direction
import model.MovableEntity

abstract class UpdateStrategy {
    open fun update(e: MovableEntity, b: Board) {
        if (e.isAlive)
            b[e.x, e.y].setFootprint(e.droppedFootprint)

        when (e.direction) {
            Direction.UP -> e.y--
            Direction.DOWN -> e.y++
            Direction.LEFT -> e.x--
            Direction.RIGHT -> e.x++
            else -> e.isAlive = false
        }

        if(!GameAnalyzer.isPossiblePosition(e.x,e.y,b))
            e.isAlive = false
    }

}