package model

import game.GameConstants

class Enemy(color: String = GameConstants.ENEMY_COLOR, droppedFootprint: Footprint = Footprint(color = GameConstants.ENEMY_FINGERPRINT_COLOR), associatedBoard: Board) : MovableEntity(color = color, droppedFootprint = droppedFootprint, associatedBoard = associatedBoard)