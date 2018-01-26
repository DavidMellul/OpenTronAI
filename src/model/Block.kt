package model

import game.GameConstants
import java.awt.Graphics

open class Block(color: String = GameConstants.BLOCK_COLOR, var innerFootprint: Footprint? = null) : Entity(color = color) {

    fun setFootprint(f: Footprint) {
        innerFootprint = f.clone() as Footprint
        innerFootprint?.x = this.x
        innerFootprint?.y = this.y
    }
    override fun render(g: Graphics) = innerFootprint?.render(g) ?: super.render(g)

}