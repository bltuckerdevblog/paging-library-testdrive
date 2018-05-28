package com.abnormallydriven.paginglibrarytestdrive.products

import android.app.Activity
import dagger.Binds
import dagger.Module
import dagger.android.ActivityKey
import dagger.android.AndroidInjector
import dagger.multibindings.IntoMap

@Module(subcomponents = [(ProductsActivitySubcomponent::class)])
abstract class ProductsActivityInjectorModule{

    @Binds
    @IntoMap
    @ActivityKey(ProductsActivity::class)
    abstract fun bindInjectorFactory(builder : ProductsActivitySubcomponent.Builder) : AndroidInjector.Factory<out Activity>
}