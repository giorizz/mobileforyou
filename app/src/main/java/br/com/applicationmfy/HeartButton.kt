package br.com.applicationmfy

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import xyz.hanks.library.bang.SmallBangView

class HeartButton : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.heart_button)

        val imageView = findViewById<SmallBangView>(R.id.imageViewAnimation)

        imageView.setOnClickListener {
            if (imageView.isSelected) {
                imageView.isSelected = false
//                imageView.likeAnimation()
            } else {
                // if not selected only
                // then show animation.
                imageView.isSelected = true
                imageView.likeAnimation()
            }
        }
    }
}