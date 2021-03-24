package br.com.applicationmfy

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.applicationmfy.models.MovieResponse
import br.com.applicationmfy.models.Movies
import br.com.applicationmfy.services.MovieApiInterface
import br.com.applicationmfy.services.MoviesApiService
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.image_screen.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import xyz.hanks.library.bang.SmallBangView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val msg_tst = "Belo clique no btnzinho :)"
        btn_back_screen.setOnClickListener {
            Toast.makeText(this, msg_tst, Toast.LENGTH_LONG).show()
        }

        heartButton()

        rv_list_main.layoutManager = LinearLayoutManager(this)
        rv_list_main.setHasFixedSize(true)
        getMovieData { movies: List<Movies> -> rv_list_main.adapter = MovieAdapter(movies) }
    }

    fun getMovieData(callback: (List<Movies>) -> Unit) {
        val apiService = MoviesApiService.getInstance().create(MovieApiInterface::class.java)
        apiService.getMovieList().enqueue(object : Callback<MovieResponse> {
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

    fun heartButton() {
        val imageView = findViewById<SmallBangView>(R.id.imageViewAnimation)
        imageView.setOnClickListener {
            if (imageView.isSelected) {
                imageView.isSelected = false
            } else {
                imageView.isSelected = true
                imageView.likeAnimation()
            }
        }
    }
}