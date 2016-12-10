package net.adamhilton.hotsstop.injection.component

import dagger.Component
import net.adamhilton.hotsstop.injection.scope.PerActivity
import net.adamhilton.hotsstop.ui.main.MainActivity

@PerActivity
@Component(dependencies = arrayOf(AppComponent::class))
interface MainScreenComponent {
    fun inject(activity: MainActivity)
}
