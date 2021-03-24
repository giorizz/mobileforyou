package br.com.applicationmfy

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import br.com.applicationmfy.models.MovieResponse
import br.com.applicationmfy.models.Movies
import br.com.applicationmfy.services.MovieApiInterface
import br.com.applicationmfy.services.MoviesApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import xyz.hanks.library.bang.SmallBangView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        heartButton()


    }

    fun getMovieData(callback: (List<Movies>) -> Unit){
        val apiService = MoviesApiService.getInstance().create(MovieApiInterface::class.java)
        apiService.getMovieList().enqueue(object : Callback<MovieResponse>{
            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {

            }

            override fun onResponse(
                call: Call<MovieResponse>,
                response: Response<MovieResponse>
            ) {
                return callback(response.body()!!.movies)
            }

        })
    }

    fun heartButton(){
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
