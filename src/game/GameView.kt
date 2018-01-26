package game

import java.awt.Dimension
import java.awt.Graphics
import javax.swing.JPanel

class GameView(val model: GameModel) : JPanel() {

    override fun paintComponent(g: Graphics?) {
        super.paintComponent(g)
        g?.let {
            model.board.render(g)
            model.player.render(g)
            model.enemy.render(g)
        }
    }

    override fun getPreferredSize(): Dimension {
        return Dimension(GameConstants.FRAME_SIZE, GameConstants.FRAME_SIZE)
    }
}