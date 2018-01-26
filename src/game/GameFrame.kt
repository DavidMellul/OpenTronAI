package game

import extension.Dimension
import java.awt.event.KeyEvent
import java.awt.event.KeyListener
import javax.swing.JFrame
import javax.swing.WindowConstants

class GameFrame(val view: GameView) : JFrame(), KeyListener {
    init {
        // Properties
        title = "Tron"
        size = Dimension(GameConstants.FRAME_SIZE)
        isResizable = false
        defaultCloseOperation = WindowConstants.EXIT_ON_CLOSE
        isLocationByPlatform = true

        // Components
        contentPane.add(view)

        // Listener
        addKeyListener(this)

        // Rearrange frame size
        pack()
    }

    fun display() {
        isVisible = true
    }

    override fun keyTyped(e: KeyEvent?) {

    }

    override fun keyPressed(e: KeyEvent?) {
        e?.let { if (GameAnalyzer.isKeySupported(e.keyCode)) view.model.propagateKeyboardSignal(it) }
    }

    override fun keyReleased(e: KeyEvent?) {}
}