package ball.goal.topcars.db.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "basic_item_table")
data class FavoriteCar(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val title: String,
    val images: List<Int>,
    val desc: String,
    val points: Int
)