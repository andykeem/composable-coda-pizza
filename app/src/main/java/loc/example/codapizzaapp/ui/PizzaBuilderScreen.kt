package loc.example.codapizzaapp.ui

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Checkbox
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import loc.example.codapizzaapp.R
import loc.example.codapizzaapp.model.Pizza
import loc.example.codapizzaapp.model.Topping
import loc.example.codapizzaapp.model.ToppingPlacement
import java.text.NumberFormat

private const val TAG = "PizzaBuilderScreen"

@Preview
@Composable
fun PizzaBuilderScreen(modifier: Modifier = Modifier) {
    var pizza by rememberSaveable { mutableStateOf(Pizza()) }
    Column(modifier = modifier) {
        ToppingsList(pizza = pizza, modifier = modifier.weight(1f)) { pizza = it }
        OrderButton(pizza = pizza, modifier = modifier)
    }
}

@Composable
private fun ToppingsList(
    pizza: Pizza,
    modifier: Modifier = Modifier,
    onToppingChange: (pizza: Pizza) -> Unit
) {
    var selectedToppingState by rememberSaveable { mutableStateOf<Topping?>(null) }
    LazyColumn(modifier = modifier) {
        items(Topping.values()) { topping ->
            val isOnPizza = pizza.toppings.containsKey(topping)
            ToppingCell(
                topping = topping,
                placement = pizza.toppings[topping],
                checked = isOnPizza,
                onToppingChange = {
                    val updatedPizza = pizza.withTopping(
                        topping = topping,
                        placement = pizza.toppings[topping]
                    )
                    onToppingChange(updatedPizza)
                    selectedToppingState = topping
                }
            )

            selectedToppingState?.let { selectedTopping ->
                ToppingPlacementDialog(
                    onDismissRequest = {
                        selectedToppingState = null
                    },
                    topping = selectedTopping,
                    onPlacementClick = { selectedPlacement ->
                        val pizzaWithTopping = pizza.withTopping(selectedTopping, selectedPlacement)
                        onToppingChange(pizzaWithTopping)
                    }
                )
            }
        }
    }
}

@Composable
fun ToppingCell(
    topping: Topping,
    placement: ToppingPlacement?,
    checked: Boolean,
    modifier: Modifier = Modifier,
    onToppingChange: () -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .clickable { onToppingChange() }
    ) {
        Checkbox(checked = checked, onCheckedChange = { onToppingChange() })
        Column(modifier = Modifier.weight(1f)) {
            Text(stringResource(id = topping.toppingName))
            if (placement != null) {
                Text(stringResource(id = placement.label))
            }
        }
    }
}

@Composable
private fun OrderButton(pizza: Pizza, modifier: Modifier = Modifier) {
    Button(onClick = { /*TODO*/ }, modifier = modifier.fillMaxWidth()) {
        val currencyFormatter = remember { NumberFormat.getCurrencyInstance() }
        Log.d(TAG, "currencyFormatter: $currencyFormatter")
        val price = currencyFormatter.format(pizza.price)
        Text(stringResource(R.string.place_order, price))
    }
}

@Preview
@Composable
fun ToppingCellPreview() {
    ToppingCell(
        topping = Topping.Pepperoni,
        placement = ToppingPlacement.Left,
        checked = true,
        onToppingChange = {}
    )
}