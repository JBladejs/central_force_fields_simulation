package com.game_physics.collisions

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import com.badlogic.gdx.math.MathUtils.cos
import com.badlogic.gdx.math.MathUtils.sin
import com.game_physics.collisions.system.CircleCollider
import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.abs
import kotlin.math.sqrt

class Ball(val radius: Float, private val color: Color, x: Float = 0.0f, y: Float = 0.0f) {

    private var k = 0.01f
    var x = x
        set
    var y = y
        set

    var vx = 0f
    var vy = 0f

    var Con = ArrayList<Line>()


    fun updateLocation() {

        vx += calcForceX(Con[0])
        vy += calcForceY(Con[0])
        x += vx
        y += vy
    }

    fun calcForceX(line: Line): Float {

        //Obliczanie |F|
        //var moduleF = -k * line.length
        val otherX = line.getOtherEndXLocation(this)

        println(-k*(this.x-otherX))
        return -k*(this.x-otherX)
    }
    fun calcForceY(line: Line): Float {

        //Obliczanie |F|
        //var moduleF = -k * line.length
        val otherY = line.getOtherEndYLocation(this)

        println(-k*(this.y-otherY))
        return -k*(this.y-otherY)
    }

    fun AddCon(line: Line) {
        Con.add(line)
    }

    fun render(renderer: ShapeRenderer) {
        with(renderer) {
            set(ShapeRenderer.ShapeType.Filled)
            setColor(this@Ball.color)
            circle(x, y, radius)
        }
    }
}