package com.raqun.movies.shows.domain

import com.raqun.movies.core.domain.Interactor
import io.reactivex.Observable
import javax.inject.Inject

class PopularTvShowsInteractor @Inject constructor(private val tvShowsRepository: TvShowsRepository) :
    Interactor.ReactiveRetrieveInteractor<PopularTvShowsInteractor.PopularTvShowsParams, PagedTvShows> {

    override fun execute(params: PopularTvShowsParams): Observable<PagedTvShows> {
        if (params.page < 0) {
            return Observable.error(IllegalArgumentException("Invalid current page number"))
        }

        if (params.page >= params.totalPage) {
            return Observable.error(IllegalStateException("No more pages available!"))
        }

        return tvShowsRepository.getPopularTShows(params.page).toObservable()
    }

    class PopularTvShowsParams(val page: Int, val totalPage: Int) : Interactor.Params()
}