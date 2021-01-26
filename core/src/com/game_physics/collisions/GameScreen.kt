package com.game_physics.collisions

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Screen
import com.badlogic.gdx.graphics.GL20


class GameScreen(private val game: RestoringForceGame) : Screen {

    private var balls = ArrayList<Ball>()
    private var lines = ArrayList<Line>()
    private var scale = 1f

    init {
        balls.add(Ball(30f * scale, Color(255, 0, 0), 20f * scale, 350f* scale))
        balls.add(Ball(30f* scale, Color(0, 255, 0), 300f* scale, 100f* scale))
        balls.add(Ball(30f* scale, Color(0, 0, 255), 600f* scale, 500f* scale))
        balls.add(Ball(30f* scale, Color(255, 255, 0), 550f* scale, 10f* scale))
        balls.add(Ball(30f* scale, Color(0, 255, 255), 1200f* scale, 450f* scale))
        balls.add(Ball(30f* scale, Color(255, 0, 255), 70f* scale, 800f* scale))
        balls.add(Ball(30f* scale, Color(255, 255, 255), 150f* scale, 370f* scale))

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
        for(i in lines.indices.reversed())
        {
            lines[i].lengthUpdate()
            if(lines[i].ripAppart())
                lines.removeAt(i)
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