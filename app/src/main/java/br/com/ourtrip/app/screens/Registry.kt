package br.com.ourtrip.app.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusEvent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.ourtrip.app.R
import br.com.ourtrip.app.components.PasswordInputComponent
import br.com.ourtrip.app.ui.theme.QuickSand
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.TimeZone

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegistryScreen(navController: NavController) {
    var fullName by remember {
        mutableStateOf("")
    }
    var email by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }
    var confirmPassword by remember {
        mutableStateOf("")
    }
    Box() {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(modifier = Modifier.fillMaxWidth()) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .align(Alignment.CenterHorizontally),
                    colors = CardDefaults.cardColors(containerColor = Color(0x00FFFFFF))
                ) {
                    Column(
                        modifier = Modifier.padding(
                            vertical = 16.dp, horizontal = 32.dp
                        )
                    ) {
                        OutlinedTextField(
                            value = fullName,
                            onValueChange = { fullName = it},
                            modifier = Modifier
                                .fillMaxWidth(),
                            placeholder = {
                                Text(
                                    text = "Nome Completo",
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

                        Spacer(modifier = Modifier.height(10.dp))

                        val focusManager = LocalFocusManager.current
                        var showDatePickerDialog by remember {
                            mutableStateOf(false)
                        }
                        val datePickerState = rememberDatePickerState()
                        var selectedDate by remember {
                            mutableStateOf("")
                        }

                        if (showDatePickerDialog) {
                            DatePickerDialog(
                                onDismissRequest = { showDatePickerDialog = false },
                                confirmButton = {
                                    Button(
                                        onClick = {
                                            datePickerState
                                                .selectedDateMillis?.let { millis ->
                                                    selectedDate = millis.toBrazilianDateFormat()
                                                }
                                            showDatePickerDialog = false
                                        }) {
                                        Text(text = "Escolher data")
                                    }
                                }) {
                                DatePicker(state = datePickerState)
                            }
                        }
                        OutlinedTextField(
                            value = selectedDate,
                            onValueChange = { },
                            colors = OutlinedTextFieldDefaults.colors(
                                unfocusedBorderColor = colorResource(id = R.color.primary_50),
                                focusedBorderColor = colorResource(id = R.color.primary_100)
                            ),
                            shape = RoundedCornerShape(16.dp),
                            modifier = Modifier
                                .fillMaxWidth()
                                .onFocusEvent {
                                    if (it.isFocused) {
                                        showDatePickerDialog = true
                                        focusManager.clearFocus(force = true)
                                    }
                                },
                            label = {
                                Text(
                                    text = "Data de Nascimento",
                                    fontFamily = QuickSand,
                                    fontWeight = FontWeight.SemiBold,
                                    fontSize = 10.sp,
                                    color = colorResource(id = R.color.primary_75)
                                )
                            },
                            readOnly = true
                        )

                        Spacer(modifier = Modifier.height(10.dp))

                        OutlinedTextField(
                            value = email,
                            onValueChange = {email = it},
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

                        PasswordInputComponent(placeholder = "Senha", value = password, updateValue = { password = it })


                        Spacer(modifier = Modifier.height(16.dp))

                        PasswordInputComponent(placeholder = "Senha", value = confirmPassword, updateValue = { confirmPassword = it })

                        Spacer(modifier = Modifier.height(16.dp))

                        Button(
                            onClick = {navController.navigate("Login")},
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(48.dp),
                            shape = RoundedCornerShape(16.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.primary_100))
                        ) {
                            Text(
                                text = "Cadastrar-se",
                                fontWeight = FontWeight.Bold,
                                fontFamily = QuickSand,
                                color = Color.White,
                                fontSize = 23.sp
                            )
                        }
                    }
                }
            }
        }
    }
}

fun Long.toBrazilianDateFormat(
    pattern: String = "dd/MM/yyyy"
): String {
    val date = Date(this)
    val formatter = SimpleDateFormat(
        pattern, Locale("pt-br")
    ).apply {
        timeZone = TimeZone.getTimeZone("GMT")
    }
    return formatter.format(date)
}