package ball.goal.topcars.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ball.goal.topcars.REALISATION
import ball.goal.topcars.db.model.FavoriteCar

class FavouriteViewModel : ViewModel() {
    private val allBasicCourses: LiveData<List<FavoriteCar>> = REALISATION.allBasicCourses

    private val filteredBasics: MutableLiveData<List<FavoriteCar>> = MutableLiveData()

    fun getAllBasics(): LiveData<List<FavoriteCar>> {
        return allBasicCourses
    }

    fun getFilteredBasics(searchText: String): LiveData<List<FavoriteCar>> {
        val filteredList = allBasicCourses.value?.filter { favoriteCar ->
            favoriteCar.title.contains(searchText, ignoreCase = true)
        } ?: emptyList()
        filteredBasics.postValue(filteredList)
        return filteredBasics
    }
}