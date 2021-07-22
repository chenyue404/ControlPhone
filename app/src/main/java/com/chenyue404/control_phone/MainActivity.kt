package com.chenyue404.control_phone

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

class MainActivity : AppCompatActivity() {

    private val bt01: Button by lazy { findViewById(R.id.bt01) }
    private val myServer: MyWebServer by lazy { MyWebServer(3081) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lifecycle.addObserver(object : LifecycleObserver {
            @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
            fun onDestroy() {
                myServer.stop()
            }
        })

        bt01.setOnClickListener {
            myServer.apply {
                if (isAlive) stop() else start()
            }
        }
    }
}