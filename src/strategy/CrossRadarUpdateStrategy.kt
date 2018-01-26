package strategy

import game.GameAnalyzer
import model.Board
import model.MovableEntity

class CrossRadarUpdateStrategy : UpdateStrategy() {
    override fun update(e: MovableEntity, b: Board) {
        e.direction = GameAnalyzer.bestPossibleMovingDirectionWithinCross(e, b)
        super.update(e, b)
    }
}