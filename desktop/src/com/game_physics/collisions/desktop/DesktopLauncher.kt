package com.game_physics.collisions.desktop

import com.badlogic.gdx.backends.lwjgl.LwjglApplication
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration
import com.game_physics.collisions.RestoringForceGame

object DesktopLauncher {
    @JvmStatic
    fun main(arg: Array<String>) {
        val config = LwjglApplicationConfiguration()
        with(config) {
            title = "Collisions"
            width = 1280
            height = 720
            resizable = false
//            vSyncEnabled = false
//            foregroundFPS = 0
//            backgroundFPS = 0
            LwjglApplication(RestoringForceGame(), config)
        }
    }
}