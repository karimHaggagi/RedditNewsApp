package com.example.redditnews.presentation

import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.core.presentation.model.NewsUiModel
import com.example.core.presentation.utils.CustomNavType
import com.example.core.presentation.Screens
import com.example.details.DetailsRoute
import com.example.home.presentation.HomeRoute
import kotlin.reflect.typeOf

/**
 * created by Karim Haggagi Hassan Elsayed on 5/13/25
 **/
@Composable
fun RedditNewsNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        modifier = modifier.statusBarsPadding(),
        navController = navController,
        startDestination = Screens.Home
    ) {

        composable<Screens.Home> {
            HomeRoute(onItemClick = { item ->
                navController.navigate(Screens.Details(item))
            })
        }

        composable<Screens.Details>(
            typeMap = mapOf(typeOf<NewsUiModel>() to CustomNavType.newsModelType)
        ) {
            DetailsRoute(onNavigateUp = { navController.navigateUp() })
        }
    }
}