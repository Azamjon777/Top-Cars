package ball.goal.topcars.db

import android.content.Context
import android.preference.PreferenceManager

@Suppress("DEPRECATION")
class SaveShared {
    companion object {
        fun setFavourite(context: Context?, key: String, value: Boolean) {
            val setFavouriteShared = PreferenceManager.getDefaultSharedPreferences(context)
            setFavouriteShared.edit().putBoolean(key, value).apply()
        }

        fun getFavourite(context: Context?, key: String): Boolean {
            val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
            return sharedPreferences.getBoolean(key, false)
        }
    }
}