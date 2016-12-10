package net.adamhilton.hotsstop.injection.module

import dagger.Binds
import dagger.Module
import net.adamhilton.hotsstop.data.remote.DataService
import net.adamhilton.hotsstop.data.remote.LocalDataService

@Module
abstract class DataModule {
    @Binds
    abstract fun bindDataService(dataService: LocalDataService) : DataService
}
