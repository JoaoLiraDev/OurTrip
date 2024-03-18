package br.com.ourtrip.app.components

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.ourtrip.app.R
import br.com.ourtrip.app.model.Destination
import br.com.ourtrip.app.ui.theme.QuickSand
import coil.compose.AsyncImage
import coil.request.CachePolicy
import coil.request.ImageRequest

@Composable
fun ExpandableCardComponent(
    destination: Destination,
    navController: NavController
) {
    var expanded by remember { mutableStateOf(false) }

    Card(
        shape = RoundedCornerShape(5.dp),
        elevation = CardDefaults.cardElevation(5.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Box(modifier = Modifier.height(200.dp)) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(destination.imageUrl)
                    .networkCachePolicy(CachePolicy.ENABLED)
                    .diskCachePolicy(CachePolicy.DISABLED)
                    .memoryCachePolicy(CachePolicy.ENABLED)
                    .build(),
                placeholder = painterResource(id = R.drawable.broken_image),
                error = painterResource(id = R.drawable.broken_image),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
            Box(
                modifier = Modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.TopEnd
            ) {
                IconButton(onClick = { expanded = !expanded }) {
                    Icon(
                        tint = Color.White,
                        imageVector = if (expanded) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown,
                        contentDescription = if (expanded) {
                            "Mostrar mais"
                        } else {
                            "Mostrar menos"
                        }
                    )
                }
            }

            Box(
                modifier = Modifier
                .fillMaxSize(),
                contentAlignment = Alignment.Center) {
                Text(
                    text = destination.destinationName,
                    fontWeight = FontWeight.Bold,
                    fontFamily = QuickSand,
                    color = Color.White,
                    fontSize = 18.sp,
                )
            }

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                Color.Black
                            ),
                            startY = 300f
                        )
                    ),
                contentAlignment = Alignment.BottomStart
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    Row (horizontalArrangement = Arrangement.SpaceBetween){
                        Text(
                            text = destination.starNumber,
                            fontWeight = FontWeight.Bold,
                            fontFamily = QuickSand,
                            color = Color.White,
                            fontSize = 10.sp,
                            modifier = Modifier.padding(end = 5.dp)
                        )
                        Icon(
                            imageVector = Icons.Default.Star,
                            tint = colorResource(id = R.color.primary_100),
                            modifier = Modifier
                                .size(10.dp)
                                .align(Alignment.Bottom),
                            contentDescription = "icone de estrela",
                        )
                    }
                    Box {
                        Text(
                            text = "R$ ${destination.destinationPrice}",
                            fontWeight = FontWeight.Bold,
                            fontFamily = QuickSand,
                            color = Color.White,
                            fontSize = 10.sp,
                        )
                    }
                }
            }
        }
        CardContent(expanded, destination, navController)
    }
    Spacer(modifier = Modifier.padding(5.dp))
}

@Composable
fun CardContent(
    expanded: Boolean = false,
    destination: Destination,
    navController: NavController
) {
    Row(
        modifier = Modifier
            .animateContentSize()
    ) {
        if (expanded) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(12.dp)
            ) {
                Text(text = destination.destinationName)
                Spacer(modifier = Modifier.padding(5.dp))
                Text(text = destination.description)

                Row(modifier = Modifier.fillMaxWidth().padding(top = 10.dp), horizontalArrangement = Arrangement.End) {
                    Button(
                        onClick = { navController.navigate("Payment?destinationId=${destination.id}") },
                        modifier = Modifier,
                        shape = RoundedCornerShape(16.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.primary_100)),

                    ) {
                        Text(
                            text = "Comprar plano",
                            fontWeight = FontWeight.Bold,
                            fontFamily = QuickSand,
                            color = Color.White,
                            fontSize = 13.sp
                        )
                        Icon(
                            modifier = Modifier.size(25.dp).padding(start = 5.dp),
                            painter = painterResource(id = R.drawable.shopping_cart),
                            contentDescription = null
                        )
                    }
                }
            }
        }

    }
}
