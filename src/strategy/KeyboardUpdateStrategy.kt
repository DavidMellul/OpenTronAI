package strategy

import game.GameAnalyzer
import model.Board
import model.Direction
import model.MovableEntity
import java.awt.event.KeyEvent

class KeyboardUpdateStrategy : UpdateStrategy() {
    var keyEvent: KeyEvent? = null

    override fun update(e: MovableEntity, b: Board) {
        keyEvent?.let {
            if (GameAnalyzer.isKeyAllowed(it.keyCode, e)) {
                with(it) {
                    if (keyCode == KeyEvent.VK_UP && GameAnalyzer.isPossiblePosition(e.x, e.y - 1, b)) e.direction = Direction.UP
                    else if (keyCode == KeyEvent.VK_DOWN && GameAnalyzer.isPossiblePosition(e.x, e.y + 1, b)) e.direction = Direction.DOWN
                    else if (keyCode == KeyEvent.VK_LEFT && GameAnalyzer.isPossiblePosition(e.x - 1, e.y, b)) e.direction = Direction.LEFT
                    else if (keyCode == KeyEvent.VK_RIGHT && GameAnalyzer.isPossiblePosition(e.x + 1, e.y, b)) e.direction = Direction.RIGHT
                }
            }
        }

        super.update(e, b)
    }


}