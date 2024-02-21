import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.RequestPage
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.joincoded.bankapi.R
import com.joincoded.bankapi.model.GarageBranch
import com.joincoded.bankapi.ui.theme.Disabled
import com.joincoded.bankapi.ui.theme.Gold
import com.joincoded.bankapi.viewmodel.GarageViewModel


data class Review(val userName: String, val comment: String, val rating: Int)
@Composable
fun GarageDetails(branch: GarageBranch?, viewModel: GarageViewModel) {
    val localUriHandler = LocalUriHandler.current
    val isRequested = remember { mutableStateOf(false) }
    val favorite = remember { mutableStateOf(false) }
    val reviews = listOf(
        Review("Ahmed", "Great service!", 5),
        Review("Mubarak", "Excellent experience", 4),
        Review("Aseel", "Could be better", 3)
    )


    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.surface, RoundedCornerShape(16.dp))
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {
        Image(
            painter = painterResource(id = branch!!.imageURI),
            contentDescription = "Branch",
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .clip(RoundedCornerShape(16.dp))
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = branch.name,
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.weight(1f)
            )


            IconButton(
                onClick = { favorite.value = !favorite.value },
                modifier = Modifier.size(30.dp)
                    .background(
                        color = if (favorite.value) Color.Transparent else Color.Transparent,
                        shape = MaterialTheme.shapes.medium
                    )
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.star),
                    contentDescription = "Favorite",
                    tint = if (favorite.value) Color.Yellow else Color.Gray
                )
            }





        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Working Hours: ${branch.workingHours}",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurface
        )

        Text(
            text = "Type: ${branch.type}",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurface
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Address: ${branch.address}",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurface
        )

        Text(
            text = "Phone: ${branch.phone}",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurface
        )

        Spacer(modifier = Modifier.height(16.dp))


        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {



        }


        IconButton(
            onClick = {
                localUriHandler.openUri(branch.location)
            },
            modifier = Modifier.size(48.dp)
        ) {
            Icon(
                Icons.Filled.LocationOn,
                contentDescription = "Location",
                tint = Color.Red
            )
        }


        Spacer(modifier = Modifier.height(16.dp))
        // Floating "Request" button
        FloatingActionButton(
            modifier = Modifier
                .fillMaxWidth(),
            onClick = { isRequested.value = !isRequested.value },
            containerColor = if (isRequested.value) Color.Gray else MaterialTheme.colorScheme.primary
        ) {
            Text(text = "Request", color = Color.White)
        }
    }
}
