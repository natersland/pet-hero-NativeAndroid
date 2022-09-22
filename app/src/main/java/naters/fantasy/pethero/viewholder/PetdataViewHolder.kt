package naters.fantasy.pethero.viewholder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import naters.fantasy.pethero.R

class PetdataViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
    var petCard = itemView.findViewById<CardView>(R.id.pet_card)
    var petAvatar = itemView.findViewById<ImageView>(R.id.card_pet_avatar)
    var petName = itemView.findViewById<TextView>(R.id.card_pet_name)
    var petBirthDate = itemView.findViewById<TextView>(R.id.card_birthday_value)
    var petAgeToHuman = itemView.findViewById<TextView>(R.id.card_human_age_value)

    init {
        itemView.setOnClickListener{
            Toast.makeText(itemView.context, "hi $petName.text", Toast.LENGTH_SHORT).show()
        }
    }

}