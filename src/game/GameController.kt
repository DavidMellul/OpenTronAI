package game

object GameController {
    val model = GameModel()
    val view = GameView(model)
    val frame = GameFrame(view)


    @JvmStatic
    fun main(args: Array<String>) {
        val gameThread = Thread({ frame.display() })

        gameThread.start()
        while (model.playerAndEnemyAlive()) {
            model.update()
            frame.repaint()
            Thread.sleep(110)
        }
        gameThread.join()

        frame.dispose()
    }
}