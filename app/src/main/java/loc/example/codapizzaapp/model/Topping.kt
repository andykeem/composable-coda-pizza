package loc.example.codapizzaapp.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import loc.example.codapizzaapp.R

enum class Topping(
    @StringRes val toppingName: Int,
    @DrawableRes val pizzaOverlayImage: Int? = null
) {
    Bacon(R.string.topping_bacon),
    Basil(R.string.topping_basil, R.drawable.topping_basil),
    Beef(R.string.topping_beef),
    Chicken(R.string.topping_chicken),
    Extra_Cheese(R.string.topping_extra_cheese),
    Ham(R.string.topping_ham),
    Ham_and_Pineapple(R.string.topping_ham_and_pineapple),
    Mushroom(R.string.topping_mushroom, R.drawable.topping_mushroom),
    Olive(R.string.topping_olive, R.drawable.topping_olive),
    Onion(R.string.topping_onion),
    Pepperoni(R.string.topping_pepperoni, R.drawable.topping_pepperoni),
    Peppers(R.string.topping_peppers, R.drawable.topping_peppers),
    Pineapple(R.string.topping_pineapple, R.drawable.topping_pineapple),
    Pesto(R.string.topping_pesto),
    Sausage(R.string.topping_sausage),
    Spicy_Pork(R.string.topping_spicy_pork),
    Spinach(R.string.topping_spinach),
    Tomato_and_Basil(R.string.topping_tomato_and_basil)
}
