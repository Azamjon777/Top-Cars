package ball.goal.topcars.db

import androidx.room.TypeConverter

class IntegerListConverter {

    @TypeConverter
    fun fromIntegerList(value: List<Int>?): String? {
        return value?.joinToString(",")
    }

    @TypeConverter
    fun toIntegerList(value: String?): List<Int>? {
        return value?.split(',')?.map { it.toInt() }
    }
}
