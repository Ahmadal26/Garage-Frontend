package com.joincoded.bankapi.composable

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.joincoded.bankapi.data.VehicleType
import com.joincoded.bankapi.viewmodel.GarageViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpComposable(
    viewModel: GarageViewModel, onSignInClicked: () -> Unit,
) {
    var user by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var vehicleType by remember { mutableStateOf("") }
    var vehicleYear by remember { mutableStateOf("") }
    var vehicleModel by remember { mutableStateOf("") }
    var expanded by remember { mutableStateOf(false) }

    var selectedVehicleType by remember { mutableStateOf(VehicleType.car) }

    val vehicleTypes = VehicleType.values()


    var confirmPassword by remember { mutableStateOf("") }
    var isPasswordVisible by remember { mutableStateOf(false) }

    if (viewModel.token?.token != null){
        onSignInClicked()
    }

    Scaffold(
        modifier = Modifier.fillMaxWidth(),
    ) {


        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        )

        {

            Icon(
                Icons.Default.Person,
                contentDescription = "Profile",
                tint = MaterialTheme.colorScheme.primary,
                modifier = Modifier
                    .size(120.dp)
                    .clip(CircleShape)
            )


            Spacer(modifier = Modifier.height(16.dp))


            OutlinedTextField(
                value = user,
                onValueChange = { newUser -> user = newUser },
                label = { Text("Username") },
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Email,
                    imeAction = ImeAction.Next
                ),
                leadingIcon = { Icon(Icons.Default.Person, contentDescription = null) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            )

            OutlinedTextField(
                value = email,
                onValueChange = { newEmail -> email = newEmail },
                label = { Text("Email") },
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Email,
                    imeAction = ImeAction.Next
                ),
                leadingIcon = { Icon(Icons.Default.Person, contentDescription = null) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            )
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Password") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    IconButton(onClick = { isPasswordVisible = !isPasswordVisible }) {
                        Icon(
                            if (isPasswordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                            contentDescription = null
                        )
                    }
                }
            )



            OutlinedTextField(
                value = vehicleYear,
                onValueChange = { newYear -> vehicleYear = newYear },
                label = { Text("Year") },
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Next
                ),

                leadingIcon = { Icon(Icons.Default.DateRange, contentDescription = null) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            )

            OutlinedTextField(
                value = vehicleModel,
                onValueChange = { newModel -> vehicleModel = newModel },
                label = { Text("Model") },
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Email,
                    imeAction = ImeAction.Next
                ),
                leadingIcon = { Icon(Icons.Default.Add, contentDescription = null) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            )


            // Vehicle Type Dropdown
            Column(
                modifier = Modifier.padding(8.dp)
            ) {


                Spacer(modifier = Modifier.height(4.dp))
                Box(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Vehicle Type", style = MaterialTheme.typography.bodyMedium)
                    TextButton(
                        onClick = { expanded = !expanded },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(selectedVehicleType.name)
                    }
                    DropdownMenu(
                        expanded = expanded,
                        onDismissRequest = { expanded = false },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        VehicleType.values().forEach { vehicleType ->
                            DropdownMenuItem(onClick = {
                                selectedVehicleType = vehicleType
                                expanded = false
                            }, text = {
                                Text(text = vehicleType.name)


                            })
                        }
                    }
                }
            }









            Spacer(modifier = Modifier.height(16.dp))


            Button(
                onClick = {

                    viewModel.signup(
                        username = user,
                        password = password,
                        vehicleType = vehicleTypes,
                        vehicleYear = vehicleYear,
                        vehicleModel = vehicleModel
                    )

                },
                modifier = Modifier
                    .fillMaxWidth().padding(20.dp),

                colors = ButtonDefaults.buttonColors()

            ) {
                Icon(Icons.Default.Done, contentDescription = null)
                Spacer(modifier = Modifier.width(8.dp))
                Text("Sign Up")


            }


        }


    }

}


