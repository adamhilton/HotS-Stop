package net.adamhilton.hotsstop.ui.main

import io.reactivex.Observable
import io.reactivex.subjects.BehaviorSubject
import net.adamhilton.hotsstop.data.remote.DataService
import javax.inject.Inject

class MainScreenViewModel @Inject constructor(private val dataService: DataService){

    private val dataSubject = BehaviorSubject.create<String>()

    fun loadData(): Observable<String> {
        return dataService
                .getData()
                .doOnNext { it -> dataSubject.onNext(it) }
    }

    fun dataObservable(): Observable<String> {
        return dataSubject
    }

}
