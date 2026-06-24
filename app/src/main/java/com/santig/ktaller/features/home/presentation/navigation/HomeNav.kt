package com.santig.ktaller.features.home.presentation.navigation

sealed class HomeNav(val route: String) {
    data object HomeScreen : HomeNav(route = "home")
    data object ConfigurationScreen : HomeNav(route = "configuration")
    data object OrderDetailScreen : HomeNav(
        route = "order_detail/{${HomeConstants.ID_DETAIL}}"
    ){
        fun createRoute(id: Int) = "order_detail/$id"
    }
}

object HomeConstants {
    const val ID_DETAIL = "id_detail"
}
