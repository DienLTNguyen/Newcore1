package com.example.core2
//extension included
import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.w3c.dom.Text

class Chad : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chad)

        info = intent.getParcelableExtra(MainActivity.PICTURE)!!

        val name = findViewById<EditText>(R.id.name)
        val ratingBar = findViewById<RatingBar>(R.id.ratingBar)
        val description = findViewById<EditText>(R.id.description)
        val date = findViewById<EditText>(R.id.date)


        name.setText(info.name)
        ratingBar.rating = info.star.toFloat()
        description.setText(info.description)
        date.setText(info.date)



        when (info.id) {
            1 -> R.id.imageButton
        }
    }

    //when back button is pressed
    override fun onBackPressed() {

        info.name = findViewById<EditText>(R.id.name).text.toString()
        info.star = findViewById<RatingBar>(R.id.ratingBar).rating.toDouble().toInt()
        info.description = findViewById<EditText>(R.id.description).text.toString()
        info.date = findViewById<EditText>(R.id.date).text.toString()


        //validation of name & email
        if (info.name == "") {
            Toast.makeText(this, "Please enter name", Toast.LENGTH_SHORT).show()
        }
        else {
            val i = intent.apply{
                putExtra(RETURN_PICTURE, info)
            }
            setResult(Activity.RESULT_OK, i)
            super.onBackPressed()
        }
    }



    companion object {
        var RETURN_PICTURE = "returnDetail"
        const val P = "picture"
        lateinit var info: Picture
    }
}
