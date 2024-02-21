import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.RequestPage
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.joincoded.bankapi.R
import com.joincoded.bankapi.model.GarageBranch
import com.joincoded.bankapi.ui.theme.Disabled
import com.joincoded.bankapi.ui.theme.Gold
import com.joincoded.bankapi.viewmodel.GarageViewModel

@Composable
fun GarageDetails(branch: GarageBranch?, viewModel: GarageViewModel) {
    val localUriHandler = LocalUriHandler.current
    val isRequested = remember { mutableStateOf(false) }


    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
    ) {
        Spacer(modifier = Modifier.height(16.dp))

        Image(
            painter = painterResource(id = branch!!.imageURI),
            contentDescription = "Branch",
            modifier = Modifier
                .size(120.dp)
                .align(Alignment.CenterHorizontally)
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
                onClick = { /* Handle favorite button click */ },
                modifier = Modifier.size(24.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.star),
                    contentDescription = "Favorite",
                    tint = if (branch.favorite) Gold else Disabled
                )
            }

            IconButton(
                onClick = {
                    localUriHandler.openUri(branch.location)
                },
                modifier = Modifier.size(24.dp)
            ) {
                Icon(
                    Icons.Filled.LocationOn,
                    contentDescription = "Location",
                    tint = MaterialTheme.colorScheme.primary
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

        // Floating "Request" button
        FloatingActionButton(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            onClick = { isRequested.value = !isRequested.value },
            containerColor = if (isRequested.value) Color.Gray else MaterialTheme.colorScheme.primary
        ) {
            Icon(
                Icons.Filled.RequestPage,
                contentDescription = "Request",
                tint = Color.White
            )
        }
    }
}
