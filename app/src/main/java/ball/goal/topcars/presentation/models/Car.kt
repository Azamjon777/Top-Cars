package ball.goal.topcars.presentation.models

import java.io.Serializable

data class Car(
    val name: String,
    val images: List<Int>,
    val desc: String,
    val points: Int
) : Serializable