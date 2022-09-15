package naters.fantasy.pethero.data

import naters.fantasy.pethero.model.PetData
import naters.fantasy.pethero.model.PetType

class Datasource {
    fun loadPetLists(): List<PetData>{

        val rv_dataLists = mutableListOf<PetData>()

        return listOf<PetData>(
        PetData(1,PetType.cat,"Sunny","09/11/2019", 3.0,"female"),
        PetData(2,PetType.cat,"09/11/2019", "09/11/2019",40.0,"female"),
        PetData(3,PetType.dog,"09/11/2019", "09/11/2019",40.0,"male")
        )
    }
}