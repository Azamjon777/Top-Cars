package ball.goal.topcars.db.repository

import androidx.lifecycle.LiveData
import ball.goal.topcars.db.dao.FavoriteItemDao
import ball.goal.topcars.db.model.FavoriteCar

class FavouriteRepositoryRealization(private val favoriteItemDao: FavoriteItemDao) :
    FavouriteRepository {
    override val allBasicCourses: LiveData<List<FavoriteCar>>
        get() = favoriteItemDao.getAllBasicItems()

    override suspend fun insertBasicItem(basicItemModel: FavoriteCar, onSuccess: () -> Unit) {
        favoriteItemDao.insert(basicItemModel)
        onSuccess()
    }

    override suspend fun deleteBasicItem(basicItemModel: FavoriteCar, onSuccess: () -> Unit) {
        favoriteItemDao.delete(basicItemModel)
        onSuccess()
    }
}