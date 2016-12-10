package net.adamhilton.hotsstop.data.remote

import io.reactivex.Observable

interface DataService {
    fun getData() : Observable<String>
}
