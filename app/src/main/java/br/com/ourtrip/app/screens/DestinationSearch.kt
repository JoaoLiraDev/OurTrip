package br.com.ourtrip.app.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import br.com.ourtrip.app.components.ExpandableCardComponent
import br.com.ourtrip.app.components.LoadingAnimation
import br.com.ourtrip.app.model.DestinationViewModel
import br.com.ourtrip.app.network.destinations.Destinations

@Composable
fun DestinationSearchScreen(navController: NavController, viewModel: DestinationViewModel = viewModel()) {
    val data by viewModel.data
    val loading by viewModel.loading

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        if (loading) {
            LoadingAnimation()
        } else {
            DestinationList(destinations = data, navController = navController)
        }
    }
}

@Composable
fun DestinationList(
    modifier: Modifier = Modifier,
    navController: NavController,
    destinations: List<Destinations>
) {
    LazyColumn(modifier = modifier.padding(vertical = 4.dp, horizontal = 6.dp)) {
        items(items = destinations) { destinations ->
            println(destinations)
            ExpandableCardComponent(destinations, navController)
        }
    }
}