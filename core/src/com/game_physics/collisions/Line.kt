package com.game_physics.collisions

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import com.badlogic.gdx.math.MathUtils.cos
import com.badlogic.gdx.math.MathUtils.sin
import com.game_physics.collisions.system.CircleCollider
import kotlin.math.abs
import kotlin.math.sqrt

class Line(ball1: Ball, ball2: Ball) {

    var ball1 = ball1
        set
    var ball2 = ball2
        set
    var length = 0f
        set
    var relaxLength = 100f
    var maxLength = 1200f

    init {
        ball1.addCon(this)
        ball2.addCon(this)
    }

    fun lengthUpdate()
    {
        //Wzór na odległość między punktami
        length = sqrt((ball1.x - ball2.x) * (ball1.x - ball2.x) + (ball1.y - ball2.y) * (ball1.y - ball2.y))
    }

    fun getOtherEndXLocation(ball :Ball): Float
    {
        if(ball1 == ball)
            return ball2.x
        else
            return ball1.x
    }

    fun getOtherEndYLocation(ball :Ball): Float
    {
        if(ball1 == ball)
            return ball2.y
        else
            return ball1.y
    }

    fun ripAppart(): Boolean
    {
        if(this.length>maxLength)
        {
            ball1.con.remove(this)
            ball2.con.remove(this)
            return true
        }
        else
            return false
    }

    fun render(renderer: ShapeRenderer) {
        with(renderer) {
            setColor(Color(255, 255, 255))
            rectLine(ball1.x, ball1.y, ball2.x, ball2.y, 5f)
        }
    }
}