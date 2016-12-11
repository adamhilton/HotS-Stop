package com.nonnulldev.hotsstop.data.api

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import com.nonnulldev.hotsstop.data.model.Hero
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Inject

class HotSLogsClient @Inject constructor() {

    private val hotsLogsApi: HotSLogsApi

    init {
        val retrofit = Retrofit.Builder()
                .baseUrl("https://api.hotslogs.com")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(MoshiConverterFactory.create())
                .build()

        hotsLogsApi = retrofit.create(HotSLogsApi::class.java)
    }

    fun getHeroes(): Observable<List<Hero>> {
        return hotsLogsApi.getHeroes()
    }
}
