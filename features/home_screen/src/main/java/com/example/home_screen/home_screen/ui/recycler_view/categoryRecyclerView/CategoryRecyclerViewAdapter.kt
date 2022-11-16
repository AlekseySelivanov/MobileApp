package com.example.home_screen.home_screen.ui.recycler_view.categoryRecyclerView

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.home_screen.R
import com.example.home_screen.databinding.RvCategoryItemBinding
import com.example.home_screen.home_screen.domain.model.CategoryModel

class CategoryRecyclerViewAdapter(
    val listener: (Int) -> Unit,
) : RecyclerView.Adapter<CategoryRecyclerViewAdapter.ViewHolder>() {

    var listOffers = listOf<CategoryModel>()
    var row_index = 0

    override fun getItemCount() = listOffers.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        RvCategoryItemBinding.bind(
            LayoutInflater.from(parent.context).inflate(
                R.layout.rv_category_item,
                parent,
                false
            )
        )
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listOffers[position])
        val circleImageView: ImageView = holder.itemView.findViewById(R.id.circleImageView)
        holder.itemView.setOnClickListener {
            row_index = position
            notifyDataSetChanged()
        }

        if(row_index == position) {
            circleImageView.setBackgroundResource(R.drawable.ellipse_activate)
        } else {
            circleImageView.setBackgroundResource(R.drawable.ellipse_not_activate)
        }
    }

    fun setData(list: List<CategoryModel>) {
        val diff = DiffUtilsTemplates(listOffers, list)
        val diffResult = DiffUtil.calculateDiff(diff)
        listOffers = list
        diffResult.dispatchUpdatesTo(this)
        notifyDataSetChanged()
    }

    inner class ViewHolder(private val binding: RvCategoryItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            binding.root.setOnClickListener {
                listener.invoke(adapterPosition)
            }
        }

        fun bind(template: CategoryModel) {
            binding.apply {
                with(template) {
                    mainTextView.text = title
                    if (icon != null) {
                        iconImageView.setBackgroundResource(icon)
                    }
                    if (background != null) {
                        circleImageView.setBackgroundResource(background)
                    }
                }
            }
        }
    }
}