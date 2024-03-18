package br.com.ourtrip.app.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.ourtrip.app.R
import br.com.ourtrip.app.ui.theme.QuickSand

@Composable
fun PaymentScreen(navController: NavController, destinationId: String?) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Não Implementado...",
            fontWeight = FontWeight.Bold,
            fontFamily = QuickSand,
            color = colorResource(id = R.color.primary_100),
            fontSize = 30.sp,
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {navController.navigate("Destination-Search")},
            modifier = Modifier
                .fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.primary_100))
        ) {
            Text(
                text = "Retornar",
                fontWeight = FontWeight.Bold,
                fontFamily = QuickSand,
                color = Color.White,
                fontSize = 16.sp
            )
        }
    }
}