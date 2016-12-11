package com.nonnulldev.hotsstop.injection.component

import dagger.Component
import com.nonnulldev.hotsstop.injection.scope.PerActivity
import com.nonnulldev.hotsstop.ui.main.MainActivity

@PerActivity
@Component(dependencies = arrayOf(AppComponent::class))
interface MainScreenComponent {
    fun inject(activity: MainActivity)
}
