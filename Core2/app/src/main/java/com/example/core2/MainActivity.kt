package com.example.core2
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private var chad: Picture = Picture("Shopping Center", "Chadstone","21/09/2021", 5, 1)
    private var flinder: Picture = Picture("Station", "Flinder Street Station", "21/09/2021", 3, 2)
    private var woolworth: Picture = Picture("Groceries", "Woolworth","21/09/2021", 4, 3)
    private var swin: Picture = Picture("University", "Swinburne Uni", "21/09/2021", 5, 4)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val chadImage = findViewById<ImageButton>(R.id.imageButton)
        val chadName = findViewById<TextView>(R.id.name1)
        chadName.text = chad.name
        val chadRate = findViewById<TextView>(R.id.rate1)
        chadRate.text = chad.star.toString()
        chadImage.setOnClickListener(){
            val i = Intent(this, Flinder::class.java).apply{
                putExtra(PICTURE, chad)
            }
            startActivityForResult(i, 0)
        }

        val flinderImage = findViewById<ImageButton>(R.id.imageButton2)
        val flinderName = findViewById<TextView>(R.id.name2)
        flinderName.text = flinder.name
        val flinderRate = findViewById<TextView>(R.id.rate2)
        flinderRate.text = flinder.star.toString()
        flinderImage.setOnClickListener(){
            val i = Intent(this, Flinder::class.java).apply{
                putExtra(PICTURE, flinder)
            }
            startActivityForResult(i, 1)
        }

        val woolworthImage = findViewById<ImageButton>(R.id.imageButton3)
        val woolworthName = findViewById<TextView>(R.id.name3)
        woolworthName.text = woolworth.name
        val woolworthRate = findViewById<TextView>(R.id.rate3)
        woolworthRate.text = woolworth.star.toString()
        woolworthImage.setOnClickListener(){
            val i = Intent(this, Flinder::class.java).apply{
                putExtra(PICTURE, woolworth)
            }
            startActivityForResult(i, 2)
        }

        val swinImage = findViewById<ImageButton>(R.id.imageButton4)
        val swinName = findViewById<TextView>(R.id.name4)
        swinName.text = swin.name
        val swinRate = findViewById<TextView>(R.id.rate4)
        swinRate.text = swin.star.toString()
        swinImage.setOnClickListener(){
            val i = Intent(this, Flinder::class.java).apply{
                putExtra(PICTURE, swin)
            }
            startActivityForResult(i, 3)
        }
        Log.d("initializing", "Creating data")
    }



    override fun onActivityResult(requestCode: Int, resultCode: Int, intent: Intent?) {

        super.onActivityResult(requestCode, resultCode, intent)
        if (intent == null) Log.i("MAIN IS RECEIVING", "IS NULL")
        if (resultCode != Activity.RESULT_OK) return
        if (requestCode == 0) {
            val data = intent?. getParcelableExtra<Picture>("returnDetail")
            val name1 = findViewById<TextView>(R.id.name1)
            val star1 = findViewById<TextView>(R.id.rate1)
            data?.let{
                chad.name = data.name
                chad.star = data.star
                star1.text = chad.star.toString()
                name1.text = chad.name
                chad.description = data.description
                chad.date = data.date
            }
        }

        else if (requestCode == 1) {
            val data = intent?. getParcelableExtra<Picture>("returnDetail")
            val name2 = findViewById<TextView>(R.id.name2)
            val star2 = findViewById<TextView>(R.id.rate2)
            data?.let {
                flinder.name = data.name
                flinder.star = data.star
                star2.text = flinder.star.toString()
                name2.text = flinder.name
                flinder.description = data.description
                flinder.date = data.date
            }
        }

        else if (requestCode == 2) {
            val data = intent?. getParcelableExtra<Picture>("returnDetail")
            val name3 = findViewById<TextView>(R.id.name3)
            val star3 = findViewById<TextView>(R.id.rate3)
            data?.let{
                woolworth.name = data.name
                woolworth.star = data.star
                star3.text = woolworth.star.toString()
                name3.text = woolworth.name
                woolworth.description = data.description
                woolworth.date = data.date
            }
        }

        else if (requestCode == 3) {
            val data = intent?. getParcelableExtra<Picture>("returnDetail")
            val name4 = findViewById<TextView>(R.id.name4)
            val star4 = findViewById<TextView>(R.id.rate4)
            data?.let {
                swin.name = data.name
                swin.star = data.star
                star4.text = swin.star.toString()
                name4.text = swin.name
                swin.description = data.description
                swin.date = data.date
            }
        }

        else {
            Log.e("Intent", "Failed retrieval")
        }
    }



    companion object {
        const val PICTURE = "info"
    }
}

