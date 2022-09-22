package naters.fantasy.pethero.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.io.Serializable

@Parcelize
data class PetData(
    val petType: PetType,
    val petName: String,
    val petAge: Int,
    val petGender: String,
    val petBirthDate: String,
    val aboutPet: String,
    val lovePoint: Int,
) : Parcelable, Serializable {

    val humanAge get() = petAge.times(2)
}

enum class PetType {
    dog, cat
}