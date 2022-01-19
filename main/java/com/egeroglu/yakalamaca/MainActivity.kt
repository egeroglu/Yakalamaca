package com.egeroglu.yakalamaca

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    var score = 0
    var imageArray = ArrayList<ImageView>()
    var handler = Handler()
    var runnable = Runnable{}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageArray.add(imageView)
        imageArray.add(imageView2)
        imageArray.add(imageView3)
        imageArray.add(imageView4)
        imageArray.add(imageView5)
        imageArray.add(imageView6)
        imageArray.add(imageView7)
        imageArray.add(imageView8)
        imageArray.add(imageView9)
        imageArray.add(imageView10)
        imageArray.add(imageView11)
        imageArray.add(imageView12)
        imageArray.add(imageView13)
        imageArray.add(imageView14)
        imageArray.add(imageView15)
        imageArray.add(imageView16)
        imageArray.add(imageView17)
        imageArray.add(imageView18)
        imageArray.add(imageView19)
        imageArray.add(imageView20)

        hideImages()


        object:CountDownTimer(20500,1000){
            override fun onFinish() {


                timetext.text = "Time : 0"
                handler.removeCallbacks(runnable)
                for(image in imageArray){
                    image.visibility = View.INVISIBLE
                }

                val alert = AlertDialog.Builder(this@MainActivity)

                alert.setTitle("Game is Over")
                alert.setMessage("Restart the Game?")
                alert.setPositiveButton("yes"){dialog, which ->
                    //restart
                    val intent = intent
                    finish()
                    startActivity(intent)
                }


                alert.setNegativeButton("No"){dialog, which ->
                    Toast.makeText(this@MainActivity,"Exitting...",Toast.LENGTH_LONG).show()
                }
                alert.show()
            }

            override fun onTick(millisUntilFinished: Long) {
             timetext.text = "Time: " + millisUntilFinished/1000
            }

        }.start()
    }

    fun hideImages(){
        runnable = object : Runnable {
            override fun run() {
                for(image in imageArray) {
                    image.visibility = View.INVISIBLE
                }

                val random = java.util.Random()
                val randomIndex = random.nextInt(20)
                imageArray[randomIndex].visibility = View.VISIBLE

                handler.postDelayed(runnable,400)
            }

        }
        handler.post ( runnable )

    }
    fun increaseScore(view: View){
        score++
        scoretext.text = "Score: $score"

    }
}
