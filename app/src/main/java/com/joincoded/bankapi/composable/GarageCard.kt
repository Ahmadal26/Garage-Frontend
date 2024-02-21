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
import com.joincoded.bankapi.model.GarageBranch
import com.joincoded.bankapi.R

@Composable
fun BranchCard(
    modifier: Modifier = Modifier,
    garageBranch: GarageBranch,
    onDetailsClick: () -> Unit
) {
    var favorite by remember { mutableStateOf(garageBranch.favorite) }
    val elevation by animateFloatAsState(if (favorite) 8f else 4f)

    Card(
        modifier = modifier
            .fillMaxWidth()
            .clickable { onDetailsClick() },
        shape = RoundedCornerShape(8.dp),
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
                contentDescription = "Branch",
            )

            Spacer(modifier = Modifier.width(16.dp))

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
                    text = "${garageBranch.type}",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Spacer(modifier = Modifier.height(4.dp))

            }
            IconButton(
                onClick = { /* Handle location button click */ },
                modifier = Modifier
                    .size(50.dp)
                    .padding(4.dp)
            ) {
                Icon(
                    Icons.Filled.LocationOn,
                    contentDescription = "Location",
                    tint = MaterialTheme.colorScheme.primary
                )
            }



            IconButton(
                onClick = { favorite = !favorite },
                modifier = Modifier.size(30.dp)
                    .background(
                        color = if (favorite) MaterialTheme.colorScheme.primary else Color.Transparent,
                        shape = RoundedCornerShape(4.dp)
                    )
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.star),
                    contentDescription = "Favorite",
                    tint = if (favorite) Color.White else MaterialTheme.colorScheme.onSurface
                )


            }
        }
    }
}
