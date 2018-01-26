package model

import extension.Array2D
import game.GameConstants
import java.awt.Graphics

// Composite pattern implemented to make a Board usable the same way as a Block, while it's actually a group of Block
class Board : Block() {
    var innerBoard = Array2D(GameConstants.BOARD_SIZE, { Block() })

    // Fill-in the Block grid with correct positions (not [0,0])
    init {
        for (i in 0 until GameConstants.BOARD_SIZE)
            for (j in 0 until GameConstants.BOARD_SIZE)
                with(innerBoard[i][j]) { x = i; y = j }
    }


    override fun render(g: Graphics) {
        for (block in innerBoard.flatten())
            block.render(g)
    }

    operator fun get(i: Int, j: Int): Block = innerBoard[i][j]
}