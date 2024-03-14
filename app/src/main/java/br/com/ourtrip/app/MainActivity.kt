package br.com.ourtrip.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.ourtrip.app.screens.DestinationSearchScreen
import br.com.ourtrip.app.screens.LoginScreen
import br.com.ourtrip.app.screens.PaymentScreen
import br.com.ourtrip.app.screens.RecoveryScreen
import br.com.ourtrip.app.screens.RegistryScreen
import br.com.ourtrip.app.screens.UserFeedbackScreen
import br.com.ourtrip.app.ui.theme.OurTripTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OurTripTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = "Login",
                        enterTransition = {
                            slideIntoContainer(towards = AnimatedContentTransitionScope.SlideDirection.Start, animationSpec = tween(600))
                        },
                        exitTransition = {
                            slideOutOfContainer(towards = AnimatedContentTransitionScope.SlideDirection.End, animationSpec = tween(600))
                        }
                    ){
                        composable(route =  "Login") { LoginScreen(navController) }
                        composable(route =  "Recovery") { RecoveryScreen(navController) }
                        composable(route =  "Registry") { RegistryScreen(navController) }
                        composable(route =  "Destination-Search") { DestinationSearchScreen(navController) }
                        composable(route =  "Payment") { PaymentScreen(navController) }
                        composable(route =  "User-Feedback") { UserFeedbackScreen(navController) }
                    }
                }
            }
        }
    }
}
