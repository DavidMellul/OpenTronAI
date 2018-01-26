package strategy

import game.GameAnalyzer
import model.Board
import model.MovableEntity

class BasicUpdateStrategy : UpdateStrategy() {
    override fun update(e: MovableEntity, b: Board) {
        e.direction = GameAnalyzer.firstNextPossibleMovingDirection(e, b)
        super.update(e,b)
    }
}