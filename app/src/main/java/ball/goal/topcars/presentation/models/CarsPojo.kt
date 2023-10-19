package ball.goal.topcars.presentation.models

import java.io.Serializable

data class CarsPojo(
    val brandName: String,
    val carsList: List<Car>
) : Serializable
