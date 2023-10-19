package ball.goal.topcars.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import ball.goal.topcars.db.dao.FavoriteItemDao
import ball.goal.topcars.db.model.FavoriteCar

@Database(entities = [FavoriteCar::class], version = 1)
@TypeConverters(IntegerListConverter::class)
abstract class FavouriteRoomDatabase : RoomDatabase() {

    abstract fun getBasicDao(): FavoriteItemDao

    companion object {
        private var database: FavouriteRoomDatabase? = null

        fun getInstance(context: Context): FavouriteRoomDatabase {
            return if (database == null) {
                database = Room.databaseBuilder(context, FavouriteRoomDatabase::class.java, "db")
                    .build()
                database as FavouriteRoomDatabase
            } else {
                database as FavouriteRoomDatabase
            }
        }
    }
}