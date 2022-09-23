package naters.fantasy.pethero.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.io.Serializable
import kotlin.math.ln

@Parcelize
data class PetData(
    val petType: PetType,
    val petName: String,
    val petAge: Int,
    val petGender: String,
    val petBirthDate: Long,
    val aboutPet: String,
    var lovePoint: Int,
    val humanAge: String = when (petType) {
        PetType.dog -> {
            when (petAge) {
                0 -> "อายุคน: น้อยกว่า 31 ปี"
                else -> "อายุคน: ${Math.round((16 * ln(petAge.toDouble())) + 31)} ปี"
            }
        }
        else -> when(petAge) {
            0 -> "อายุคน: น้อยกว่า 18 ปี"
            in 1..5 -> "อายุคน: ${((petAge * 19) / 3) + 1} ปี"
            else -> "อายุคน: ${((petAge - 6) * 4) + 40} ปี"
        }
    }
) : Parcelable, Serializable {

}

enum class PetType {
    dog, cat
}