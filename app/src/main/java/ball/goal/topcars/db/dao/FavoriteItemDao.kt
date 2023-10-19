package ball.goal.topcars.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ball.goal.topcars.db.model.FavoriteCar

@Dao
interface FavoriteItemDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(basicItemModel: FavoriteCar)

    @Delete
    suspend fun delete(basicItemModel: FavoriteCar)

    @Query("SELECT * FROM basic_item_table")
    fun getAllBasicItems(): LiveData<List<FavoriteCar>>
}