package com.nonnulldev.hotsstop.ui.main

import com.nonnulldev.hotsstop.data.api.HotSLogsClient
import com.nonnulldev.hotsstop.data.model.Hero
import io.reactivex.Observable
import io.reactivex.subjects.BehaviorSubject
import javax.inject.Inject

class MainScreenViewModel @Inject constructor(private val hotsLogsClient: HotSLogsClient){

    private val heroesSubject = BehaviorSubject.create<List<Hero>>()

    fun loadHeroes(): Observable<List<Hero>> {
        return hotsLogsClient
                .getHeroes()
                .doOnNext { it -> heroesSubject.onNext(it) }
    }

    fun heroesObservable(): Observable<List<Hero>> {
        return heroesSubject
    }

}
