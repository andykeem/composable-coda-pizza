package loc.example.codapizzaapp.model

import androidx.annotation.StringRes
import loc.example.codapizzaapp.R

enum class ToppingPlacement(@StringRes val label: Int) {
    Left(R.string.topping_placement_left),
    Right(R.string.topping_placement_right),
    All(R.string.topping_placement_all)
}
