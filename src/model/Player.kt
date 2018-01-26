package model

import strategy.KeyboardUpdateStrategy
import strategy.UpdateStrategy
import game.GameConstants

class Player(color: String = GameConstants.PLAYER_COLOR, droppedFootprint: Footprint = Footprint(color = GameConstants.PLAYER_FINGERPRINT_COLOR), associatedBoard: Board, updateStrategy: UpdateStrategy = KeyboardUpdateStrategy()) : MovableEntity(color, droppedFootprint = droppedFootprint, associatedBoard = associatedBoard, updateStrategy = updateStrategy)