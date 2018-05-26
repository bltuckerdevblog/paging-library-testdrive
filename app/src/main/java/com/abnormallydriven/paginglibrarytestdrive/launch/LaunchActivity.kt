package com.abnormallydriven.paginglibrarytestdrive.launch

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.abnormallydriven.paginglibrarytestdrive.R
import com.abnormallydriven.paginglibrarytestdrive.names.NamesActivity
import com.abnormallydriven.paginglibrarytestdrive.products.ProductsActivity

class LaunchActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launch)


        findViewById<Button>(R.id.positional_data_source)
                .setOnClickListener { v ->
                    //launch activity for positional data source
                }


        findViewById<Button>(R.id.paged_key_data_source)
                .setOnClickListener { v ->
                    startActivity(Intent(this@LaunchActivity, ProductsActivity::class.java))
                }

        findViewById<Button>(R.id.item_keyed_data_source)
                .setOnClickListener { v ->
                    startActivity(Intent(this@LaunchActivity, NamesActivity::class.java))
                }


    }
}
