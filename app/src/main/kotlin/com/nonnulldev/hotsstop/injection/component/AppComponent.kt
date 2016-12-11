package com.nonnulldev.hotsstop.injection.component

import com.nonnulldev.hotsstop.data.api.HotSLogsClient
import com.nonnulldev.hotsstop.injection.module.ApiModule
import com.nonnulldev.hotsstop.injection.scope.PerApplication
import dagger.Component

@PerApplication
@Component(modules = arrayOf(ApiModule::class))
interface AppComponent {

}

