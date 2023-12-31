package ball.goal.topcars.viewmodels

import android.content.Context
import androidx.lifecycle.ViewModel
import ball.goal.topcars.R
import ball.goal.topcars.REALISATION
import ball.goal.topcars.db.FavouriteRoomDatabase
import ball.goal.topcars.db.repository.FavouriteRepositoryRealization
import ball.goal.topcars.presentation.models.Car
import ball.goal.topcars.presentation.models.CarsPojo

class DataViewModel(context: Context) : ViewModel() {

    init {
        val daoBasic = FavouriteRoomDatabase.getInstance(context).getBasicDao()
        REALISATION = FavouriteRepositoryRealization(daoBasic)
    }

    val carsData = mutableListOf(
        CarsPojo(
            context.getString(R.string.tesla),
            listOf(
                Car(
                    context.getString(R.string.model_s),
                    listOf(
                        R.drawable.tesla_model_s,
                        R.drawable.tesla_model_s2,
                        R.drawable.tesla_model_s3
                    ),
                    context.getString(R.string.t_desc1),
                    5
                ),
                Car(
                    context.getString(R.string.model_3),
                    listOf(
                        R.drawable.tesla_model_3,
                        R.drawable.tesla_model_32,
                        R.drawable.tesla_model_33
                    ),
                    context.getString(R.string.t_desc2),
                    4
                ),
                Car(
                    context.getString(R.string.model_x),
                    listOf(
                        R.drawable.tesla_model_x,
                        R.drawable.tesla_model_x2,
                        R.drawable.tesla_model_x3
                    ),
                    context.getString(R.string.t_desc3),
                    4
                ),
                Car(
                    context.getString(R.string.model_y),
                    listOf(
                        R.drawable.tesla_model_y,
                        R.drawable.tesla_model_y2,
                        R.drawable.tesla_model_y3
                    ),
                    context.getString(R.string.t_desc4),
                    4
                ),
                Car(
                    context.getString(R.string.roadster),
                    listOf(
                        R.drawable.tesla_roadster,
                        R.drawable.tesla_roadster2,
                        R.drawable.tesla_roadster3
                    ),
                    context.getString(R.string.t_desc5),
                    5
                ),
                Car(
                    context.getString(R.string.semi_truck),
                    listOf(
                        R.drawable.tesla_cybertruck,
                        R.drawable.tesla_cybertruck2,
                        R.drawable.tesla_cybertruck3
                    ),
                    context.getString(R.string.t_desc7),
                    4
                ),
                Car(
                    context.getString(R.string.model_a),
                    listOf(
                        R.drawable.tesla_model_a,
                        R.drawable.tesla_model_a2,
                        R.drawable.tesla_model_a3
                    ),
                    context.getString(R.string.t_desc8),
                    5
                ),
                Car(
                    context.getString(R.string.model_b),
                    listOf(
                        R.drawable.tesla_model_b,
                        R.drawable.tesla_model_b2,
                        R.drawable.tesla_model_b3
                    ),
                    context.getString(R.string.t_desc9),
                    5
                ),
                Car(
                    context.getString(R.string.model_c),
                    listOf(
                        R.drawable.tesla_model_c,
                        R.drawable.tesla_model_c2,
                        R.drawable.tesla_model_c3
                    ),
                    context.getString(R.string.t_desc10),
                    5
                )
            )
        ),
        CarsPojo(
            context.getString(R.string.ferrari),
            listOf(
                Car(
                    context.getString(R.string.ferrari_488_gtb),
                    listOf(
                        R.drawable.ferrari_488_gtb,
                        R.drawable.ferrari_488_gtb2,
                        R.drawable.ferrari_488_gtb3
                    ),
                    context.getString(R.string.f_desc1),
                    5
                ),
                Car(
                    context.getString(R.string.ferrari_portofino),
                    listOf(
                        R.drawable.ferrari_portofino,
                        R.drawable.ferrari_portofino2,
                        R.drawable.ferrari_portofino3
                    ),
                    context.getString(R.string.f_desc2),
                    4
                ),
                Car(
                    context.getString(R.string.ferrari_f8_tributo),
                    listOf(
                        R.drawable.ferrari_f8_tributo,
                        R.drawable.ferrari_f8_tributo2,
                        R.drawable.ferrari_f8_tributo3
                    ),
                    context.getString(R.string.f_desc3),
                    5
                ),
                Car(
                    context.getString(R.string.ferrari_gtc4lusso),
                    listOf(
                        R.drawable.ferrari_gtc4lusso,
                        R.drawable.ferrari_gtc4lusso2,
                        R.drawable.ferrari_gtc4lusso3
                    ),
                    context.getString(R.string.f_desc4),
                    4
                ),
                Car(
                    context.getString(R.string.ferrari_812_superfast),
                    listOf(
                        R.drawable.ferrari_812_superfast,
                        R.drawable.ferrari_812_superfast2,
                        R.drawable.ferrari_812_superfast3
                    ),
                    context.getString(R.string.f_desc5),
                    5
                ),
                Car(
                    context.getString(R.string.ferrari_roma),
                    listOf(
                        R.drawable.ferrari_roma,
                        R.drawable.ferrari_roma2,
                        R.drawable.ferrari_roma3
                    ),
                    context.getString(R.string.f_desc6),
                    4
                ),
                Car(
                    context.getString(R.string.ferrari_sf90_stradale),
                    listOf(
                        R.drawable.ferrari_sf90_stradale,
                        R.drawable.ferrari_sf90_stradale2,
                        R.drawable.ferrari_sf90_stradale3
                    ),
                    context.getString(R.string.f_desc7),
                    5
                ),
                Car(
                    context.getString(R.string.ferrari_laferrari),
                    listOf(
                        R.drawable.ferrari_laferrari,
                        R.drawable.ferrari_laferrari2,
                        R.drawable.ferrari_laferrari3
                    ),
                    context.getString(R.string.f_desc8),
                    5
                ),
                Car(
                    context.getString(R.string.ferrari_enzo),
                    listOf(
                        R.drawable.ferrari_enzo,
                        R.drawable.ferrari_enzo2,
                        R.drawable.ferrari_enzo3
                    ),
                    context.getString(R.string.f_desc9),
                    4
                ),
                Car(
                    context.getString(R.string.ferrari_testarossa),
                    listOf(
                        R.drawable.ferrari_testarossa,
                        R.drawable.ferrari_testarossa2,
                        R.drawable.ferrari_testarossa3
                    ),
                    context.getString(R.string.f_desc10),
                    4
                )
            )
        ),
        CarsPojo(
            context.getString(R.string.bmw),
            listOf(
                Car(
                    context.getString(R.string.bmw_3_series),
                    listOf(
                        R.drawable.bmw_3_series,
                        R.drawable.bmw_3_series2,
                        R.drawable.bmw_3_series3
                    ),
                    context.getString(R.string.b_desc1),
                    5
                ),
                Car(
                    context.getString(R.string.bmw_5_series),
                    listOf(
                        R.drawable.bmw_5_series,
                        R.drawable.bmw_5_series2,
                        R.drawable.bmw_5_series3
                    ),
                    context.getString(R.string.b_desc2),
                    4
                ),
                Car(
                    context.getString(R.string.bmw_x3),
                    listOf(R.drawable.bmw_x3, R.drawable.bmw_x32, R.drawable.bmw_x33),
                    context.getString(R.string.b_desc3),
                    4
                ),
                Car(
                    context.getString(R.string.bmw_x5),
                    listOf(R.drawable.bmw_x5, R.drawable.bmw_x52, R.drawable.bmw_x53),
                    context.getString(R.string.b_desc4),
                    4
                ),
                Car(
                    context.getString(R.string.bmw_7_series),
                    listOf(
                        R.drawable.bmw_7_series,
                        R.drawable.bmw_7_series2,
                        R.drawable.bmw_7_series3
                    ),
                    context.getString(R.string.b_desc5),
                    5
                ),
                Car(
                    context.getString(R.string.bmw_m3),
                    listOf(R.drawable.bmw_m3, R.drawable.bmw_m32, R.drawable.bmw_m33),
                    context.getString(R.string.b_desc6),
                    5
                ),
                Car(
                    context.getString(R.string.bmw_m5),
                    listOf(R.drawable.bmw_m5, R.drawable.bmw_m52, R.drawable.bmw_m53),
                    context.getString(R.string.b_desc7),
                    5
                ),
                Car(
                    context.getString(R.string.bmw_i3),
                    listOf(R.drawable.bmw_i3, R.drawable.bmw_i32, R.drawable.bmw_i33),
                    context.getString(R.string.b_desc8),
                    4
                ),
                Car(
                    context.getString(R.string.bmw_i8),
                    listOf(R.drawable.bmw_i8, R.drawable.bmw_i82, R.drawable.bmw_i83),
                    context.getString(R.string.b_desc9),
                    5
                ),
                Car(
                    context.getString(R.string.bmw_z4),
                    listOf(R.drawable.bmw_z4, R.drawable.bmw_z42, R.drawable.bmw_z43),
                    context.getString(R.string.b_desc10),
                    4
                )
            )
        )
    )
}