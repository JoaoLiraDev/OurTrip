package br.com.ourtrip.app.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.ourtrip.app.components.ExpandableCardComponent

@Composable
fun DestinationSearchScreen(navController: NavController) {
    DestinationList()
}

@Composable
fun DestinationList(
    modifier: Modifier = Modifier,
    destionations: List<String> = List(10) {"$it"}
) {
    LazyColumn(modifier = modifier.padding(vertical = 4.dp, horizontal = 6.dp)) {
        items(items = destionations) {
            destionations -> ExpandableCardComponent()
        }
    }
}