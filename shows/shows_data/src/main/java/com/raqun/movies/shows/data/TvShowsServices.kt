package com.raqun.movies.shows.data

import com.raqun.movies.core.data.api.ApiConstants
import com.raqun.movies.core.data.api.PagedApiResponse
import com.raqun.movies.shows.domain.TvShow
import com.raqun.movies.shows.domain.TvShowDetail
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TvShowsServices {
    @GET("/3/tv/popular?api_key=${ApiConstants.API_KEY}")
    fun getPopularTvShows(@Query("page") page: Int = 1): Single<PagedApiResponse<List<TvShow>>>

    @GET("/tv/{tv_id}?api_key=${ApiConstants.API_KEY}")
    fun getTvShowDetail(@Path("tv_id") id: Int): Single<TvShowDetail>
}