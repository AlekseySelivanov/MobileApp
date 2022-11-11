package com.example.home_screen.home_screen.recycler_view.categoryRecyclerView

import androidx.recyclerview.widget.DiffUtil
import com.example.home_screen.home_screen.model.CategoryModel

class DiffUtilsTemplates(
    private val oldList: List<CategoryModel>,
    private val newList: List<CategoryModel>
) :
    DiffUtil.Callback() {

    override fun getOldListSize() = oldList.size

    override fun getNewListSize() = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        oldList[oldItemPosition].id == newList[newItemPosition].id

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return when {
            oldList[oldItemPosition] != newList[newItemPosition] -> {
                return false
            }
            oldList[oldItemPosition] != newList[newItemPosition] -> {
                return false
            }
            else -> true
        }
    }
}
