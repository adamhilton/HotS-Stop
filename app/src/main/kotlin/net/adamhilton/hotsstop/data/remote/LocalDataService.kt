package net.adamhilton.hotsstop.data.remote

import io.reactivex.Observable
import net.adamhilton.hotsstop.injection.scope.PerApplication
import javax.inject.Inject

@PerApplication
class LocalDataService @Inject constructor() : DataService {
    override fun getData(): Observable<String> {
        return Observable.just("Hello from LocalDataService class!")
    }
}
