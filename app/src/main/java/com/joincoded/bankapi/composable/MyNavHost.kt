package com.joincoded.bankapi.composable

import GarageDetails
import ProfilePage
import GarageList
import HomePageScreen
import SignInScreen
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.joincoded.bankapi.utils.Routes
import com.joincoded.bankapi.viewmodel.GarageViewModel

@Composable
fun MyNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    val viewModel: GarageViewModel = viewModel()


    if (viewModel.token?.token != null) {
        navController.navigate(Routes.transactionRoute)

    }


    NavHost(
        navController = navController,
        startDestination = Routes.garageListRoute,
        modifier = modifier
    ) {
        composable(Routes.garageListRoute) {
            GarageList(viewModel, onDetailsClick = { navController.navigate(Routes.garageDetails) })
        }
        composable(Routes.garageDetails) {
            GarageDetails(branch = viewModel.currentSelectedGarage, viewModel = viewModel)
        }
        composable(Routes.homeRoute) {
            HomePageScreen(
                viewModel,
                onSignInClicked = { navController.navigate(Routes.singInRoute) },
                onSignUpClicked = { navController.navigate(Routes.signupRoute) }
            )
        }

        composable(Routes.singInRoute) {
            ProfilePage(viewModel, onDetailsClick = { navController.navigate(Routes.profileRoute) })
        }

        composable(Routes.singInRoute) {
            SignInScreen(viewModel)
        }
        composable(Routes.signupRoute) {
            SignUpComposable(viewModel,
                onSignInClicked = { navController.navigate(Routes.singInRoute) },
                onSignUpClicked = { navController.navigate(Routes.signupRoute) }
            )
        }


    }
}

