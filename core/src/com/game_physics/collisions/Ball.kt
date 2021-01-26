package com.game_physics.collisions


import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import java.util.*
import kotlin.collections.ArrayList

class Ball(private val radius: Float, private val color: Color,var x: Float = 0.0f,var y: Float = 0.0f) {

    private var k = 0.001f
    private var airRes = 0.999f
    private var vx = 0f
    private var vy = 0f

    var con = ArrayList<Line>()


    fun updateLocation() {
        for(line in con)
        {
            vx = vx * airRes + calcForceX(line)
            vy = vy * airRes + calcForceY(line)
        }

        x += vx
        y += vy
    }

    private fun calcForceX(line: Line): Float {
        val otherX = line.getOtherEndXLocation(this)
        val moduleF = -k*(line.length-line.relaxLength)

        return moduleF * (this.x-otherX)/line.length
    }
    private fun calcForceY(line: Line): Float {
        val otherY = line.getOtherEndYLocation(this)
        val moduleF = -k*(line.length-line.relaxLength)

        return moduleF * (this.y-otherY)/line.length
    }

    fun addCon(line: Line) {
        con.add(line)
    }

    fun render(renderer: ShapeRenderer) {
        with(renderer) {
            set(ShapeRenderer.ShapeType.Filled)
            setColor(this@Ball.color)
            circle(x, y, radius)
        }
    }
}