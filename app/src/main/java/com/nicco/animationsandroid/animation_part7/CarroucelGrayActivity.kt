package com.nicco.animationsandroid.animation_part7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.DrawableRes
import com.nicco.animationsandroid.R
import kotlinx.android.synthetic.main.activity_carroucel_gray.*

class CarroucelGrayActivity : AppCompatActivity() {

    private val itemAdapter by lazy {
        ItemAdapter { position: Int, item: Item ->
            Toast.makeText(this@CarroucelGrayActivity, "Pos ${position}", Toast.LENGTH_LONG).show()
            item_list.smoothScrollToPosition(position)
        } }
    private val possibleItems = listOf(
        Item("Robot Android", R.drawable.robot_android),
        Item("Cars", R.drawable.robot_android),
        Item("Food", R.drawable.robot_android),
        Item("Gas", R.drawable.robot_android),
        Item("Home", R.drawable.robot_android)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_carroucel_gray)

        item_list.initialize(itemAdapter)
        item_list.setViewsToChangeColor(listOf(R.id.list_item_background, R.id.list_item_text))
        itemAdapter.setItems(getLargeListOfItems())
    }

    private fun getLargeListOfItems(): List<Item> {
        val items = mutableListOf<Item>()
        (0..40).map { items.add(possibleItems.random()) }
        return items
    }
}

data class Item(
    val title: String,
    @DrawableRes val icon: Int
)
