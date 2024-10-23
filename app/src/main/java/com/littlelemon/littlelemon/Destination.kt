package com.littlelemon.littlelemon

interface Destination {
    val route:String

    object Onboarding : Destination{
        override val route = "Onboarding"
    }

    object Home : Destination{
        override val route = "Home"
    }

    object ProfileScreen : Destination{
        override val route = "ProfileScreen"
    }
}