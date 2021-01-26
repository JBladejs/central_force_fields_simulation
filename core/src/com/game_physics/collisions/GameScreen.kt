package com.game_physics.collisions

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Screen
import com.badlogic.gdx.graphics.GL20


class GameScreen(private val game: RestoringForceGame) : Screen {

    private var balls = ArrayList<Ball>()
    private var lines = ArrayList<Line>()

    init {
        balls.add(Ball(30f, Color(255, 0, 0), 20f, 350f))
        balls.add(Ball(30f, Color(0, 255, 0), 300f, 100f))
        balls.add(Ball(30f, Color(0, 0, 255), 600f, 500f))
        balls.add(Ball(30f, Color(255, 255, 0), 550f, 10f))
        balls.add(Ball(30f, Color(0, 255, 255), 1200f, 450f))
        balls.add(Ball(30f, Color(255, 0, 255), 70f, 800f))
        balls.add(Ball(30f, Color(255, 255, 255), 150f, 370f))

        lines.add(Line(balls[0], balls[1]))
        lines.add(Line(balls[0], balls[2]))
        lines.add(Line(balls[1], balls[3]))
        lines.add(Line(balls[3], balls[2]))
        lines.add(Line(balls[0], balls[3]))
        lines.add(Line(balls[4], balls[2]))
        lines.add(Line(balls[5], balls[4]))
        lines.add(Line(balls[4], balls[1]))
        lines.add(Line(balls[5], balls[6]))
    }

    private fun update() {
        for(line in lines)
        {
            line.lengthUpdate()
        }
        for(ball in balls)
        {
            ball.updateLocation()
        }
    }

    override fun render(delta: Float) {
        Gdx.gl.glClearColor(0f, 0f, 0f, 1f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
        with(game.renderer) {
            begin()
            for(line in lines)
            {
                line.render(this)
            }
            for(ball in balls)
            {
                ball.render(this)
            }
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