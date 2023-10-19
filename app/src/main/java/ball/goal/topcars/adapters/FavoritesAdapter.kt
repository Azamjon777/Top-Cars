package ball.goal.topcars.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.view.marginStart
import androidx.core.view.setPadding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ball.goal.topcars.R
import ball.goal.topcars.databinding.ItemFavoriteBinding
import ball.goal.topcars.db.model.FavoriteCar

class FavoritesAdapter(
    private val onItemClickListener: (FavoriteCar) -> Unit,
    private val onDeleteClickListener: (FavoriteCar) -> Unit
) : ListAdapter<FavoriteCar, FavoritesAdapter.FavoriteViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteViewHolder {
        val binding =
            ItemFavoriteBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FavoriteViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FavoriteViewHolder, position: Int) {
        val favoriteItem = getItem(position)
        holder.bind(favoriteItem)
    }

    inner class FavoriteViewHolder(private val binding: ItemFavoriteBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(favoriteItem: FavoriteCar) {
            binding.itemTitle.text = favoriteItem.title
            binding.itemDescription.text = favoriteItem.desc

            val imageContainer = binding.imageContainer
            imageContainer.removeAllViews()

            favoriteItem.images.forEach { imageResId ->
                val imageView = ImageView(imageContainer.context)
                imageView.layoutParams = LinearLayout.LayoutParams(
                    600,
                    LinearLayout.LayoutParams.MATCH_PARENT
                )
                imageView.setImageResource(imageResId)
                imageView.scaleType = ImageView.ScaleType.FIT_CENTER
                imageView.setBackgroundResource(R.drawable.car_card_bg)
                imageView.setPadding(12)
                imageContainer.addView(imageView)
            }

            binding.root.setOnClickListener {
                onItemClickListener(favoriteItem)
            }
            binding.delete.setOnClickListener {
                onDeleteClickListener(favoriteItem)
            }
        }
    }

    companion object {
        private val DiffCallback = object : DiffUtil.ItemCallback<FavoriteCar>() {
            override fun areItemsTheSame(oldItem: FavoriteCar, newItem: FavoriteCar): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: FavoriteCar, newItem: FavoriteCar): Boolean {
                return oldItem == newItem
            }
        }
    }
}