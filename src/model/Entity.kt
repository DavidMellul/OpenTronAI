package model

import game.GameConstants
import game.GameController
import java.awt.Color
import java.awt.Graphics

abstract class Entity(var x: Int = 0, var y: Int = 0, val color: String) : Cloneable {

    open fun render(g: Graphics) {
        g.color = Color.decode(color)
        g.fillRect(x * GameConstants.CELL_SIZE, y * GameConstants.CELL_SIZE, GameConstants.CELL_SIZE, GameConstants.CELL_SIZE)
    }

    override public fun clone(): Any {
        return super.clone()
    }
}