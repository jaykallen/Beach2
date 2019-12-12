package com.jaykallen.beach2

import android.app.Application
import timber.log.Timber

/**
 * Created by Jay Kallen on 6/13/18.
 */

class StartApp: Application() {
    companion object {
        lateinit var instance: StartApp
            private set
    }

    override fun onCreate() {
        instance = this
        super.onCreate()
        Timber.plant(object : Timber.DebugTree() {
            override fun log(priority: Int, tag: String?, message: String, t:Throwable?) {
                super.log(priority, tag!! + "~!@", message, t)
            }
        })
    }
}
