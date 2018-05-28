package com.abnormallydriven.paginglibrarytestdrive.products

import android.arch.lifecycle.ViewModel
import com.abnormallydriven.paginglibrarytestdrive.common.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
abstract class ProductsActivityModule {

    @Module
    companion object {

        @Provides
        @JvmStatic
        fun provideSearchTerm(): String {
            return "Wine"
        }
    }



    @Binds
    @IntoMap
    @ViewModelKey(ProductsViewModel::class)
    abstract fun bindProductsViewModel(productsViewModel: ProductsViewModel): ViewModel
}
