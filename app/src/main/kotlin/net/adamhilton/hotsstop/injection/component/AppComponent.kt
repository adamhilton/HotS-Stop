package net.adamhilton.hotsstop.injection.component

import dagger.Component
import net.adamhilton.hotsstop.injection.module.DataModule
import net.adamhilton.hotsstop.injection.scope.PerApplication
import net.adamhilton.hotsstop.data.remote.DataService

@PerApplication
@Component(modules = arrayOf(DataModule::class))
interface AppComponent {

    fun dataService(): DataService

}

