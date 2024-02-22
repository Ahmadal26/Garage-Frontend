import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.joincoded.bankapi.R
import com.joincoded.bankapi.model.GarageBranch

@Composable
fun BranchCard(
    modifier: Modifier = Modifier,
    garageBranch: GarageBranch,
    onDetailsClick: () -> Unit
) {
    var favorite by remember { mutableStateOf(garageBranch.favorite) }
    Card(
        modifier = modifier
            .fillMaxWidth()
            .clickable { onDetailsClick() },
        shape = RoundedCornerShape(16.dp),

        ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(16.dp)
        ) {
            Image(
                modifier = Modifier
                    .size(100.dp)
                    .clip(RoundedCornerShape(20.dp)),
                painter = painterResource(id = garageBranch.imageURI),
                contentDescription = "Branch"
            )

            Spacer(modifier = Modifier.width(16.dp))

            // Branch details
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = garageBranch.name,
                    style = MaterialTheme.typography.headlineSmall,
                    color = MaterialTheme.colorScheme.primary
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = garageBranch.workingHours,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = garageBranch.type.toString(),
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurface
                )
            }

            Spacer(modifier = Modifier.width(16.dp))

            // Location button
            IconButton(
                onClick = { /* Handle location button click */ },
                modifier = Modifier.size(40.dp)
            ) {
                Icon(
                    Icons.Filled.LocationOn,
                    contentDescription = "Location",
                    tint = Color.Red
                )
            }

            // Favorite button
            IconButton(
                onClick = { favorite = !favorite },
                modifier = Modifier.size(40.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.star),
                    contentDescription = "Favorite",
                    tint = if (favorite) Color.Yellow else Color.Black
                )
            }
        }
    }
}
