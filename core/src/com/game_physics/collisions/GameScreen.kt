package com.game_physics.collisions

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Screen
import com.badlogic.gdx.graphics.GL20


class GameScreen(private val game: RestoringForceGame) : Screen {

    private var ball1 = Ball(30f, Color(255, 0, 0), 20f, 350f)
    private var ball2 = Ball(30f, Color(0, 0, 255), 300f, 100f)
    private var line1 = Line(ball2, ball1)

    init {

        ball1.AddCon(line1)

    }

    private fun update() {
        ball1.updateLocation()
        line1.lengthUpdate()
        //println(line1.length)


    }

    override fun render(delta: Float) {
        Gdx.gl.glClearColor(0f, 0f, 0f, 1f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
        with(game.renderer) {
            begin()
            ball1.render(this)
            ball2.render(this)
            line1.render(this)
            end()
        }
        update()
    }

    override fun resize(width: Int, height: Int) {}
    override fun dispose() {}

    override fun pause() {}
    override fun resume() {}
    override fun hide() {}
    override fun show() {}
}