package model

import strategy.BasicUpdateStrategy
import strategy.UpdateStrategy

open class MovableEntity(color: String, var direction: Direction = Direction.NONE, var isAlive: Boolean = true, val droppedFootprint: Footprint, var updateStrategy: UpdateStrategy = BasicUpdateStrategy(), val associatedBoard: Board) : Entity(color = color) {
    fun update() = updateStrategy.update(this, associatedBoard)
}