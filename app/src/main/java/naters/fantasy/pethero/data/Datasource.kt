package naters.fantasy.pethero.data

import naters.fantasy.pethero.model.PetData

class Datasource {
    fun loadPetLists(): List<PetData>{

        val rv_dataLists = mutableListOf<PetData>()

        return listOf<PetData>(
        PetData(1,"Sunny","09/11/2019", 3.0,40.0,"female"),
        PetData(2,"Fuji","09/11/2019", 3.0,40.0,"female"),
        PetData(3,"Token","09/11/2019", 3.0,40.0,"male")
        )
    }
}