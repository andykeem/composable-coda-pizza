package loc.example.codapizzaapp.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import loc.example.codapizzaapp.R
import loc.example.codapizzaapp.model.Pizza
import loc.example.codapizzaapp.model.Topping
import loc.example.codapizzaapp.model.ToppingPlacement.*

@Composable
fun PizzaHeroImage(pizza: Pizza, modifier: Modifier = Modifier) {
    Box(modifier = modifier.aspectRatio(1.0f)) {
        Image(
            painter = painterResource(id = R.drawable.pizza_crust),
            contentDescription = stringResource(R.string.pizza_preview),
            modifier = Modifier
                .fillMaxSize()
        )
        pizza.toppings.forEach { (topping, placement) ->
            topping.pizzaOverlayImage?.let {
                Image(
                    painter = painterResource(id = it),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    alignment = when (placement) {
                        Left -> Alignment.TopStart
                        Right -> Alignment.TopEnd
                        All -> Alignment.Center
                    },
                    modifier = Modifier
                        .focusable(enabled = false)
                        .aspectRatio(
                            ratio = when (placement) {
                                Left, Right -> 0.5f
                                All -> 1.0f
                            }
                        )
                        .align(
                            alignment = when (placement) {
                                Left -> Alignment.CenterStart
                                Right -> Alignment.CenterEnd
                                All -> Alignment.Center
                            }
                        )
                )
            }
        }
    }
}

@Preview
@Composable
fun PizzaHeroImagePreview() {
    PizzaHeroImage(
        pizza = Pizza(
            toppings = mapOf(
                Topping.Pepperoni to Left,
                Topping.Pineapple to Right,
                Topping.Olive to All
            )
        )
    )
}