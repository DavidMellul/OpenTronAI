package game

import model.Board
import model.Direction
import model.Enemy
import model.Player
import strategy.CrossRadarUpdateStrategy
import strategy.KeyboardUpdateStrategy
import java.awt.event.KeyEvent

class GameModel {
    // Game board initially filled with Blocks
    val board = Board()
    val player = Player(associatedBoard = board)
    val enemy = Enemy(associatedBoard = board)

    init {
        player.apply { x = 1; y = 1; direction = Direction.LEFT }
        enemy.apply { x = GameConstants.BOARD_SIZE / 2; y = GameConstants.BOARD_SIZE / 2; direction = Direction.RIGHT; updateStrategy = CrossRadarUpdateStrategy() }
    }

    fun update() {
        //    player.update()
        enemy.update()
    }

    fun playerAndEnemyAlive() = player.isAlive && enemy.isAlive

    fun propagateKeyboardSignal(e: KeyEvent) {
        (player.updateStrategy as KeyboardUpdateStrategy).keyEvent = e
    }
}