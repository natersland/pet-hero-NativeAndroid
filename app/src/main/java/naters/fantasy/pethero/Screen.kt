package naters.fantasy.pethero

sealed class Screen(val route:String){
    object Home: Screen(route = "home_screen")
    object CreatePet: Screen(route = "create_pet_screen")
    object EditPet: Screen(route = "edit_pet_screen")
    object PetDetail: Screen(route = "pet_detail_screen")
}
