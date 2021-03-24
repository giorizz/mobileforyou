package br.com.applicationmfy.services

import br.com.applicationmfy.models.MovieResponse
import retrofit2.Call
import retrofit2.http.GET

interface MovieApiInterface {
    @GET( "/3/movie/504/similar?api_key=b5563738d8dee19c975e11bcfb11ba38")
    fun getMovieList() : Call<MovieResponse>
}