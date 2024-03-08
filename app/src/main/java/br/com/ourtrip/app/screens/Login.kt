package br.com.ourtrip.app.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.ourtrip.app.R
import br.com.ourtrip.app.ui.theme.InriaSerif
import br.com.ourtrip.app.ui.theme.QuickSand

@Composable
fun LoginScreen(navController: NavController) {
    Box() {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.6f)
                    .align(Alignment.CenterHorizontally),
                colors = CardDefaults.cardColors(containerColor = Color(0xFFF0F0F0)),
                shape = RoundedCornerShape(bottomStart = 150.dp, bottomEnd = 150.dp)
            ) {
                Image(
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(top = 35.dp),
                    painter = painterResource(id = R.drawable.travel_together_image),
                    contentDescription = "Imagem de dois bonecos apertando as mão com um mapa mundi ao fundo"
                )
                Spacer(modifier = Modifier.height(40.dp))
                Text(
                    text = stringResource(id = R.string.app_name),
                    fontFamily = InriaSerif,
                    fontSize = 52.sp,
                    fontWeight = FontWeight.Normal,
                    modifier = Modifier.align(Alignment.CenterHorizontally)

                )
            }
            Spacer(modifier = Modifier.height(20.dp))
            Column(modifier = Modifier.fillMaxWidth()) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.CenterHorizontally),
                    colors = CardDefaults.cardColors(containerColor = Color(0x00FFFFFF))
                ) {
                    Column(
                        modifier = Modifier.padding(
                            vertical = 16.dp, horizontal = 32.dp
                        )
                    ) {

                        Text(
                            text = "Insira seu e-mail e senha",
                            modifier = Modifier.fillMaxWidth(),
                            fontSize = 10.sp,
                            color = colorResource(id = R.color.primary_100),
                            textAlign = TextAlign.Start
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        OutlinedTextField(value = "",
                            onValueChange = {},
                            modifier = Modifier
                                .fillMaxWidth(),
                            placeholder = {
                                Text(
                                    text = "E-mail",
                                    fontFamily = QuickSand,
                                    fontWeight = FontWeight.SemiBold,
                                    fontSize = 10.sp,
                                    color = colorResource(id = R.color.primary_75)
                                )
                            },
                            colors = OutlinedTextFieldDefaults.colors(
                                unfocusedBorderColor = colorResource(id = R.color.primary_50),
                                focusedBorderColor = colorResource(id = R.color.primary_100)
                            ),
                            shape = RoundedCornerShape(16.dp),
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
                        )

                        Spacer(modifier = Modifier.height(16.dp))

                        OutlinedTextField(value = "",
                            onValueChange = {},
                            modifier = Modifier.fillMaxWidth(),
                            placeholder = {
                                Text(
                                    text = "Senha",
                                    fontFamily = QuickSand,
                                    fontWeight = FontWeight.SemiBold,
                                    fontSize = 10.sp,
                                    color = colorResource(id = R.color.primary_75)
                                )
                            },
                            colors = OutlinedTextFieldDefaults.colors(
                                unfocusedBorderColor = colorResource(id = R.color.primary_50),
                                focusedBorderColor = colorResource(id = R.color.primary_100)
                            ),
                            shape = RoundedCornerShape(16.dp),
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                            trailingIcon = {
                                Icon(
                                    painter = painterResource(id = R.drawable.visibility),
                                    contentDescription = null
                                )
                            })
                        Spacer(modifier = Modifier.height(16.dp))
                        Button(
                            onClick = {},
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(48.dp),
                            shape = RoundedCornerShape(16.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.primary_100))
                        ) {
                            Text(
                                text = "Login",
                                fontWeight = FontWeight.Bold,
                                fontFamily = QuickSand,
                                color = Color.White,
                                fontSize = 23.sp
                            )
                        }
                        Spacer(modifier = Modifier.height(8.dp))
                        ClickableText(
                            text = AnnotatedString(text = "Não tem conta? Cadastre-se!"),
                            onClick = {navController.navigate("Registry")},
                            modifier = Modifier.align(Alignment.CenterHorizontally),
                            style = TextStyle(
                                fontWeight = FontWeight.Bold,
                                fontFamily = QuickSand,
                                color = colorResource(id = R.color.primary_100),
                                fontSize = 12.sp,
                                textDecoration = TextDecoration.Underline
                            )
                        )
                    }
                }
            }
        }
    }
}