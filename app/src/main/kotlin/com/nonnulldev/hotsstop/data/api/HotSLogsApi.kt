package com.nonnulldev.hotsstop.data.api

import com.nonnulldev.hotsstop.data.model.Hero
import io.reactivex.Observable
import retrofit2.http.GET

interface HotSLogsApi {

    @GET("/Public/Data/Heroes")
    fun getHeroes(): Observable<List<Hero>>


}
