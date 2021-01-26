package com.game_physics.collisions

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input.Keys.*
import com.badlogic.gdx.Screen
import com.badlogic.gdx.graphics.GL20
import com.game_physics.collisions.system.CollisionSystem


class GameScreen(private val game: RestoringForceGame) : Screen {
    private var ball1 = Ball(30f, Color(255, 0, 0), 20f, 350f)

    init {
        println("test")
    }

    private fun update(delta: Float) {
        ball1.x +=1
    }

    override fun render(delta: Float) {
        Gdx.gl.glClearColor(0f, 0f, 0f, 1f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
        with(game.renderer) {
            begin()
            ball1.render(this)
            end()
        }
        update(delta)
    }

    override fun resize(width: Int, height: Int) {}
    override fun dispose() {}

    override fun pause() {}
    override fun resume() {}
    override fun hide() {}
    override fun show() {}
}