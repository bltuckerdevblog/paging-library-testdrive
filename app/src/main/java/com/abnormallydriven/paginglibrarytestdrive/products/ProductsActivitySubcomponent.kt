package com.abnormallydriven.paginglibrarytestdrive.products

import dagger.Subcomponent
import dagger.android.AndroidInjector

@Subcomponent(modules = [(ProductsActivityModule::class)])
interface ProductsActivitySubcomponent : AndroidInjector<ProductsActivity> {

    @Subcomponent.Builder
    abstract class Builder: AndroidInjector.Builder<ProductsActivity>(){}
}
