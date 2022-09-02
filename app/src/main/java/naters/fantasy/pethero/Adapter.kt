package naters.fantasy.pethero

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import naters.fantasy.pethero.model.PetData
/*

class Adapter(
    private val context: Context,
    private val dataset: Dataset:List<PetData>
    ):RecyclerView.Adapter<Adapter.ItemViewHolder>() {

    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val petName: TextView = view.findViewById(R.id.card_pet_name)
        val petGender: ImageView = view.findViewById(R.id.card_pet_gender)
        val petBirthDate: TextView = view.findViewById(R.id.card_birthday_value)
        val petAgeToHumanAge: TextView = view.findViewById(R.id.card_human_age_value)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.pet_card_view,parent,false)
        return ItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        */
/*val item = dataset[position]
        holder.textView.text = context.resources.getString(item.stringResourceId)*//*


        holder.petName.text = dataset[position].petName

        holder.petBirthDate.text = dataset[position].petBirthDate
        holder.petAgeToHumanAge.text = dataset[position].petAgeToHumanAge


        var genderIcon:Int? = null
        when(dataset[position].petGender!!.toLowercase()){
            "female" -> {
                genderIcon = R.drawable.ic_baseline_female_24
            } else -> {
                TODO("Change to male sign later")
                genderIcon = R.drawable.ic_baseline_emoji_people_24
            }
        }
        holder.petGender.setImageResource(genderIcon!!)

    }

    override fun getItemCount(): Int {
       return dataset.size
    }
}*/
