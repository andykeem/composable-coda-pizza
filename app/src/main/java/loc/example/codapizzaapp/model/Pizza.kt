package loc.example.codapizzaapp.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import loc.example.codapizzaapp.model.ToppingPlacement.*

@Parcelize
data class Pizza(
    val toppings: Map<Topping, ToppingPlacement> = emptyMap()
) : Parcelable {
    val price: Double
        //        get() = if (toppings.isEmpty()) {
//            9.99
//        } else {
//            val whole =
//                toppings.filter { it.value == ToppingPlacement.All }.values.map { 1.00 }.sum()
//            val half = toppings.filter { it.value != ToppingPlacement.All }.map { 0.50 }.sum()
//            9.99 + whole + half
//        }
        get() = toppings.asSequence().sumOf { (_, placement) ->
            when (placement) {
                Left, Right -> 0.50
                All -> 1.00
            }
        } + 9.99

    fun withTopping(topping: Topping, placement: ToppingPlacement?): Pizza {
        return this.copy(
            toppings = if (placement == null) {
                toppings - topping
            } else {
                toppings + (topping to placement)
            }
        )
    }
}
