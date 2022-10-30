package loc.example.codapizzaapp.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import loc.example.codapizzaapp.R
import loc.example.codapizzaapp.model.Topping
import loc.example.codapizzaapp.model.ToppingPlacement

private const val TAG = "ToppingPlacementDialog"

@Composable
fun ToppingPlacementDialog(
    onDismissRequest: () -> Unit,
    topping: Topping,
    onPlacementClick: (ToppingPlacement?) -> Unit,
    modifier: Modifier = Modifier
) {
    Dialog(onDismissRequest = onDismissRequest) {
//        Box(modifier = modifier.background(color = Color.Red).size(64.dp))
        Card {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = modifier
                    .fillMaxWidth()
                    .background(color = MaterialTheme.colors.surface)
                    .padding(16.dp)
            ) {
                Text(
                    stringResource(
                        R.string.topping_dialog_question,
                        stringResource(id = topping.toppingName)
                    ),
                    style = MaterialTheme.typography.subtitle1,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(8.dp)
                )
                
                ToppingPlacement.values().toList().plus(null).onEach { placement ->
                    ToppingPlacementClickableText(
                        placement = placement,
                        onClick = {
                            onPlacementClick(it)
                            onDismissRequest()
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun ToppingPlacementClickableText(
    placement: ToppingPlacement?,
    onClick: (ToppingPlacement?) -> Unit,
    modifier: Modifier = Modifier
) {
    ClickableText(
        text = AnnotatedString(
            text = stringResource(id = placement?.label ?: R.string.topping_placement_none),
            spanStyle = SpanStyle(color = MaterialTheme.colors.primaryVariant),
            paragraphStyle = ParagraphStyle(textAlign = TextAlign.Center)
        ),
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp),
        onClick = { onClick(placement) },
    )
}

@Preview
@Composable
fun ToppingPlacementDialogPreview() {
    ToppingPlacementDialog(
        onDismissRequest = {},
        topping = Topping.Pepperoni,
        onPlacementClick = {})
}