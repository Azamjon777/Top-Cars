package ball.goal.topcars.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ball.goal.topcars.databinding.CarItemBinding
import ball.goal.topcars.presentation.models.Car

class CarsAdapter : ListAdapter<Car, CarsAdapter.ViewHolder>(CarDiffCallback()) {

    interface OnCarClickListener {
        fun onCarClick(car: Car)
    }

    private var clickListener: OnCarClickListener? = null

    inner class ViewHolder(private val binding: CarItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(car: Car) {
            binding.carImageView.setImageResource(car.images[0])
            binding.carNameTextView.text = car.name
            binding.carPointsTextView.text = car.points.toString()
            itemView.setOnClickListener {
                clickListener?.onCarClick(car)
            }
        }
    }

    fun setOnCarClickListener(listener: OnCarClickListener) {
        this.clickListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            CarItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val car = getItem(position)
        holder.bind(car)
    }
}

class CarDiffCallback : DiffUtil.ItemCallback<Car>() {
    override fun areItemsTheSame(oldItem: Car, newItem: Car): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: Car, newItem: Car): Boolean {
        return oldItem == newItem
    }
}