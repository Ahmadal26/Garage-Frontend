import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.joincoded.bankapi.viewmodel.GarageViewModel

//@Composable
//fun ProfilePage(
//    viewModel: GarageViewModel,
//    modifier: Modifier = Modifier
//) {
//    val requests = viewModel.requests
//
//    Column(
//        modifier = modifier
//            .padding(16.dp)
//            .fillMaxSize()
//    ) {
//        Text("Your Previous Requests:", style = MaterialTheme.typography.headlineSmall)
//        Spacer(modifier = Modifier.height(8.dp))
//        if (requests.isEmpty()) {
//            Text("No previous requests")
//        } else {
//            requests.forEach { request ->
//                Text(request)
//                Spacer(modifier = Modifier.height(4.dp))
//            }
//        }
//    }
//}



@Composable
fun ProfilePage(
    viewModel: GarageViewModel,
    modifier: Modifier = Modifier
) {
    val requests = viewModel.requests

    // Using MaterialTheme for consistent theming across the app
    MaterialTheme {
        Column(
            modifier = modifier
                .padding(16.dp)
                .fillMaxSize()
                .verticalScroll(rememberScrollState()), // Allow scrolling when content exceeds screen size
            verticalArrangement = Arrangement.spacedBy(12.dp) // Add space between children
        ) {
            Text(
                "Your Previous Requests:",
                style = MaterialTheme.typography.headlineMedium, // Use a larger, more prominent style for the headline
                color = MaterialTheme.colorScheme.primary // Use theme's primary variant color for the text
            )
            Spacer(modifier = Modifier.height(8.dp))
            if (requests.isEmpty()) {
                EmptyRequestsMessage() // Extract to a separate composable for better readability
            } else {
                RequestsList(requests) // Extract requests list to a separate composable
            }
        }
    }
}

@Composable
fun EmptyRequestsMessage() {
    Box(
        contentAlignment = Alignment.Center, // Center the message within the Box
        modifier = Modifier.fillMaxWidth() // Ensure the Box fills the available width
    ) {
        Text(
            "No previous requests",
            style = MaterialTheme.typography.bodyMedium, // Use a subtle, styled text
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f) // Use onSurface color with reduced opacity for better contrast
        )
    }
}

@Composable
fun RequestsList(requests: List<String>) {
    requests.forEach { request ->
        Card(
            modifier = Modifier.fillMaxWidth(), // Make the card fill the width
            shape = RoundedCornerShape(8.dp) // Round the corners for a softer look
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp) // Add padding inside the card for content
            ) {
                Text(request, style = MaterialTheme.typography.bodyMedium) // Display request in body1 typography
                Spacer(modifier = Modifier.height(4.dp))
            }
        }
        Spacer(modifier = Modifier.height(8.dp)) // Space between cards
    }
}