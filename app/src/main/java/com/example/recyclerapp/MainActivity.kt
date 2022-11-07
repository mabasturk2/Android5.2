package com.example.recyclerapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var productList: ArrayList<Product> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadProducts()

        // Set the Layout Manager
        recyclerView.layoutManager = GridLayoutManager(this, 2)
        // Create an object for the MyAdapter
        val adapter = MyAdapter(productList)
        // Set adapter to your RecyclerView
        recyclerView.adapter = adapter

        adapter.onItemClick = { product ->
            val rintent = Intent(this, DescriptionActivity::class.java)
            rintent.putExtra("product", product)
            startActivity(rintent)
        }
    }

    fun loadProducts(){
        val titles = resources.getStringArray(R.array.product_titles)
        val desc = resources.getStringArray(R.array.product_desc)
        val images = resources.obtainTypedArray(R.array.product_image)
        val price = resources.getStringArray(R.array.product_price)
        val color = resources.getStringArray(R.array.product_color)

        for (i in titles.indices) {
            productList.add(Product(titles[i], price[i].toDouble() ,color[i], images.getResourceId(i, 0),""+i,desc[i]))
        }
        images.recycle()
    }
}