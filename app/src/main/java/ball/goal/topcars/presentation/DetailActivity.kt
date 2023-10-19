package ball.goal.topcars.presentation

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import ball.goal.topcars.R
import ball.goal.topcars.databinding.ActivityDetailBinding
import ball.goal.topcars.db.SaveShared
import ball.goal.topcars.db.model.FavoriteCar
import ball.goal.topcars.presentation.models.Car
import ball.goal.topcars.viewmodels.MyViewModel

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    private val myViewModel: MyViewModel by viewModels()
    private var isFavourite = false
    private lateinit var currentCar: FavoriteCar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val car = intent.getSerializableExtra("car") as? Car
        if (car != null) {
            currentCar = FavoriteCar(
                title = car.name,
                desc = car.desc,
                images = car.images,
                points = car.points
            )
        }
        initial()
    }

    private fun initial() {
        val valueBool = SaveShared.getFavourite(this, currentCar.title)

        if (valueBool == true) {
            binding.favouriteImg.setImageResource(R.drawable.ic_favourite_active)
        } else {
            binding.favouriteImg.setImageResource(R.drawable.ic_favourite_inactive)
        }

        binding.itemTitle.text = currentCar.title
        binding.itemDescription.text = currentCar.desc
        binding.itemImage1.setImageResource(currentCar.images[0])
        binding.itemImage2.setImageResource(currentCar.images[1])
        binding.itemImage3.setImageResource(currentCar.images[2])

        binding.favouriteImg.setOnClickListener {
            if (isFavourite == valueBool) {
                myViewModel.insert(currentCar) {}
                SaveShared.setFavourite(this, currentCar.title, true)
                binding.favouriteImg.setImageResource(R.drawable.ic_favourite_active)
                Toast.makeText(this, getString(R.string.added), Toast.LENGTH_SHORT).show()
            } else {
                binding.favouriteImg.setImageResource(R.drawable.ic_favourite_inactive)
                myViewModel.delete(currentCar) {}
                SaveShared.setFavourite(this, currentCar.title, false)
                Toast.makeText(this, getString(R.string.deleted), Toast.LENGTH_SHORT).show()
                isFavourite = false
            }
        }
    }
}
