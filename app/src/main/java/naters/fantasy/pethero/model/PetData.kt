package naters.fantasy.pethero.model

import android.os.Parcel
import android.os.Parcelable

data class PetData(
    val id: Int?,
    val petName:String?,
    val petBirthDate:String?,
    val petAge:Int?,
    val humanAge:Int?,
    val petGender:String?
):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString()
    )

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(id)
        parcel.writeString(petName)
        parcel.writeString(petBirthDate)
        parcel.writeValue(petAge)
        parcel.writeValue(humanAge)
        parcel.writeString(petGender)
    }
    companion object CREATOR : Parcelable.Creator<PetData> {
        override fun createFromParcel(parcel: Parcel): PetData {
            return PetData(parcel)
        }

        override fun newArray(size: Int): Array<PetData?> {
            return arrayOfNulls(size)
        }
    }
}
