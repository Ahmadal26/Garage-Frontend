package com.joincoded.bankapi

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.joincoded.bankapi.data.VehicleType
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VehicleTypeDropdown(
    selectedVehicleType: VehicleType,
    onVehicleTypeSelected: (VehicleType) -> Unit
) {
    val vehicleTypes = VehicleType.values()

    Box {
        Text(
            text = "Select Vehicle Type: ${selectedVehicleType.name.lowercase().capitalize()}",
            modifier = Modifier.padding(8.dp)
        )
        DropdownMenu(
            expanded = false, // Set to true when clicked
            onDismissRequest = { /* Dismiss */ },
            modifier = Modifier.padding(8.dp)
        ) {
            vehicleTypes.forEach { vehicleType ->
                DropdownMenuItem(
                    text =  {
                        Text(vehicleType.name.lowercase().capitalize(Locale.ROOT)) // Capitalize first letter
                    },
                    onClick = {
                        onVehicleTypeSelected(vehicleType)
                    }
                )
            }
        }
    }
}
