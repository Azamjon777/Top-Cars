package ball.goal.topcars.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ball.goal.topcars.REALISATION
import ball.goal.topcars.db.model.FavoriteCar
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MyViewModel : ViewModel() {

    fun insert(itemModel: FavoriteCar, onSuccess: () -> Unit) =
        viewModelScope.launch(Dispatchers.IO) {
            REALISATION.insertBasicItem(itemModel) {
                onSuccess()
            }
        }

    fun delete(itemModel: FavoriteCar, onSuccess: () -> Unit) =
        viewModelScope.launch(Dispatchers.IO) {
            REALISATION.deleteBasicItem(itemModel) {
                onSuccess()
            }
        }
}
