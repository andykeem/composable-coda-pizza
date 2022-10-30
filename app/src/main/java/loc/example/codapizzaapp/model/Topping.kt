package loc.example.codapizzaapp.model

import androidx.annotation.StringRes
import loc.example.codapizzaapp.R

enum class Topping(@StringRes val toppingName: Int) {
    Pepperoni(R.string.topping_pepperoni),
    Sausage(R.string.topping_sausage),
    Mushroom(R.string.topping_mushroom),
    Bacon(R.string.topping_bacon),
    Onion(R.string.topping_onion),
    Extra_Cheese(R.string.topping_extra_cheese),
    Pepper(R.string.topping_pepper),
    Chicken(R.string.topping_chicken),
    Olive(R.string.topping_olive),
    Spinach(R.string.topping_spinach),
    Tomato_and_Basil(R.string.topping_tomato_and_basil),
    Beef(R.string.topping_beef),
    Ham(R.string.topping_ham),
    Pesto(R.string.topping_pesto),
    Spicy_Pork(R.string.topping_spicy_pork),
    Ham_and_Pineapple(R.string.topping_ham_and_pineapple)
}
