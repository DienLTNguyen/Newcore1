package com.example.core1

import android.annotation.SuppressLint
import android.graphics.Color
import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    private val KEY_TEXT_VALUE = "innit"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val innit = findViewById<TextView>(R.id.innit)
        val score = findViewById<Button>(R.id.score)
        val steal = findViewById<Button>(R.id.steal)
        val reset = findViewById<Button>(R.id.reset)


        score.setOnClickListener(onClickListener);
        steal.setOnClickListener(onClickListener);
        reset.setOnClickListener(onClickListener);

        if (savedInstanceState != null) {
            innit.text = savedInstanceState.getString("innit")
            var savedText = innit.text.toString().toInt()
            when (savedText){
                in 0..3 ->{
                    innit.setTextColor(Color.BLACK)
                }
                in 4..8 ->{
                    innit.setTextColor(Color.BLUE)
                }
                in 9..14 ->{
                    innit.setTextColor(Color.GREEN)
                }
            }
            Log.i("LIFECYCLE", "onSaveInstanceState")
        }
    }

    override fun onSaveInstanceState(outState: Bundle)
    {
        super.onSaveInstanceState(outState);
        outState.putString("innit",innit.text.toString())

    }

    override fun onStart(){
        super.onStart()
        Log.i("LIFECYCLE", "started")
    }

    override fun onResume() {
        super.onResume()
        Log.i("LIFECYCLE", "resumed")
    }


    override fun onPause(){
        super.onPause()
        Log.i("LIFECYCLE", "paused")
    }

    override fun onStop(){
        super.onStop()
        Log.i("LIFECYCLE", "stopped")
    }

    override fun onDestroy(){
        super.onDestroy()
        Log.i("LIFECYCLE", "destroyed")
    }


    private val onClickListener: View.OnClickListener = View.OnClickListener {

        score.setOnClickListener { _ ->
            when(innit.text.toString().toInt()){
                in 0..3 -> {
                    val result = scoreadd(innit.text.toString())
                    innit.text = result.toString()
                    innit.setTextColor(Color.BLACK)
                }
                in 4..8 -> {
                    val result = scoreadd(innit.text.toString())
                    innit.text = result.toString()
                    innit.setTextColor(Color.BLUE)
                }
                in 9..14 -> {
                    val result = scoreadd(innit.text.toString())
                    innit.text = result.toString()
                    innit.setTextColor(Color.GREEN)
                }
                in 15..15 -> {
                    val mediaPlayer = MediaPlayer.create(this, R.raw.hand_claps_close );
                    mediaPlayer.start()
                }
            }
        }

        reset.setOnClickListener { _ ->
            when (innit.text.toString().toInt()) {
                in 0..14 -> {
                    val result = resetall(innit.text.toString())
                    innit.text = result.toString()
                    innit.setTextColor(Color.BLACK)
                }
            }
        }


        steal.setOnClickListener { _ ->
            when(innit.text.toString().toInt()){
                in 1..3 -> {
                    val result = stealminus(innit.text.toString())
                    innit.text = result.toString()
                    innit.setTextColor(Color.BLACK)
                }
                in 4..8 -> {
                    val result = stealminus(innit.text.toString())
                    innit.text = result.toString()
                    innit.setTextColor(Color.BLUE)
                }
                in 9..14 -> {
                    val result = stealminus(innit.text.toString())
                    innit.text = result.toString()
                    innit.setTextColor(Color.GREEN)
                }
            }
        }

    }
}


private fun stealminus(innit: String) = innit.toInt() - 1
private fun scoreadd(innit: String) = innit.toInt() + 1
private fun resetall(innit: String) = innit.toInt() * 0
