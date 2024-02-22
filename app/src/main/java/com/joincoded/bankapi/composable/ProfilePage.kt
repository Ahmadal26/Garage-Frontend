import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.joincoded.bankapi.viewmodel.GarageViewModel

@Composable
fun ProfilePage(
    viewModel: GarageViewModel = viewModel(),
    modifier: Modifier = Modifier,
    onDetailsClick: () -> Unit
) {
    val requests = viewModel.requests

    Column(
        modifier = modifier
            .padding(16.dp)
            .fillMaxSize()
    ) {
        Text("Your Previous Requests:", style = MaterialTheme.typography.headlineSmall)
        Spacer(modifier = Modifier.height(8.dp))
        if (requests.isEmpty()) {
            Text("No previous requests")
        } else {
            requests.forEach { request ->
                Text(request)
                Spacer(modifier = Modifier.height(4.dp))
            }
        }
    }
}
