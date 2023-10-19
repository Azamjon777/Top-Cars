package ball.goal.topcars.db.repository

import androidx.lifecycle.LiveData
import ball.goal.topcars.db.model.FavoriteCar

interface FavouriteRepository {
    val allBasicCourses: LiveData<List<FavoriteCar>>

    suspend fun insertBasicItem(basicItemModel: FavoriteCar, onSuccess: () -> Unit)
    suspend fun deleteBasicItem(basicItemModel: FavoriteCar, onSuccess: () -> Unit)
}
