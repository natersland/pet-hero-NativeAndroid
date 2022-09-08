package naters.fantasy.pethero.model

import android.os.Parcel
import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.io.Serializable
@Parcelize
data class PetData(
    val id: Int?,
    val petName: String?,
    val petBirthDate: String?,
    val petAge: Int?,
    val humanAge: Int?,
    val petGender: String?
) : Parcelable
