package br.com.ourtrip.app.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.ourtrip.app.components.ExpandableCardComponent
import br.com.ourtrip.app.components.LoadingAnimation
import br.com.ourtrip.app.model.Destination
import br.com.ourtrip.app.repository.getAllDestinations
import kotlinx.coroutines.async

@Composable
fun DestinationSearchScreen(navController: NavController) {
    var destinations by remember { mutableStateOf<List<Destination>>(emptyList()) }
    var isLoading by remember { mutableStateOf(true) }

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        LaunchedEffect(Unit) {
            val destinationsResult = async { getAllDestinations() }
            destinations = destinationsResult.await()
            isLoading = false
        }

        if (isLoading) {
            LoadingAnimation()
        } else {
            DestinationList(destinations = destinations, navController = navController)
        }
    }
}

@Composable
fun DestinationList(
    modifier: Modifier = Modifier,
    navController: NavController,
    destinations: List<Destination>
) {
    LazyColumn(modifier = modifier.padding(vertical = 4.dp, horizontal = 6.dp)) {
        items(items = destinations) { destinations ->
            ExpandableCardComponent(destinations, navController)
        }
    }
}