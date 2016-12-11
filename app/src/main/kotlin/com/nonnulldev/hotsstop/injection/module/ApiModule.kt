package com.nonnulldev.hotsstop.injection.module

import com.nonnulldev.hotsstop.data.api.HotSLogsClient
import dagger.Binds
import dagger.Module

@Module
abstract class ApiModule {
    @Binds
    abstract fun bindDataService(hotsLogsClient: HotSLogsClient) : HotSLogsClient
}
