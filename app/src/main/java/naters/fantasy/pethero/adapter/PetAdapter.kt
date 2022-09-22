package com.example.affirmations.adapter

import android.graphics.PorterDuff
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import naters.fantasy.pethero.R
import naters.fantasy.pethero.model.PetData
import naters.fantasy.pethero.model.PetType
import java.security.AccessController.getContext
import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.ln

/**
 * Adapter for the [RecyclerView] in [MainActivity]. Displays [Affirmation] data object.
 */
class PetAdapter(
    private val context: FragmentActivity?,
    private val dataset: List<PetData>

) : RecyclerView.Adapter<PetAdapter.ItemViewHolder>() {

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder.
    // Each data item is just an Affirmation object.
    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val petName: TextView = view.findViewById(R.id.card_pet_name)
        val petAvatar: ImageView = view.findViewById(R.id.card_pet_avatar)
        val genderSign: ImageView = view.findViewById(R.id.card_pet_gender)
        val heart1: ImageView = view.findViewById(R.id.ic_heart1)
        val heart2: ImageView = view.findViewById(R.id.ic_heart2)
        val heart3: ImageView = view.findViewById(R.id.ic_heart3)
        val heart4: ImageView = view.findViewById(R.id.ic_heart4)
        val heart5: ImageView = view.findViewById(R.id.ic_heart5)
        val heart6: ImageView = view.findViewById(R.id.ic_heart6)
        val petBirthDate: TextView = view.findViewById(R.id.card_birthday_value)
        val petHumanAge: TextView = view.findViewById(R.id.card_human_age_value)

    }

    /**
     * Create new views (invoked by the layout manager)
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        // create a new view
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_pet_card, parent, false)

        return ItemViewHolder(adapterLayout)
    }

    /**
     * Replace the contents of a view (invoked by the layout manager)
     */
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]

        holder.petName.text = item.petName
        holder.petAvatar.setImageResource(when(item.petType){
            PetType.cat -> R.drawable.cool
            else-> R.drawable.corgi
        })
        holder.genderSign.setImageResource(when(item.petGender){
            "female" -> R.drawable.ic_baseline_female_24
            else-> R.drawable.ic_baseline_male_24
        })
        // set birthdate
        val sdf = SimpleDateFormat("EEE, d MMM yyyy")
        var myCalendar = Calendar.getInstance()
        var year=myCalendar.get(Calendar.YEAR)
        var month=myCalendar.get(Calendar.MONTH)
        var day=myCalendar.get(Calendar.DAY_OF_MONTH)

        val dob = Calendar.getInstance()
        dob.timeInMillis = item.petBirthDate

        var age = myCalendar.get(Calendar.YEAR) - dob.get(Calendar.YEAR)
        holder.petBirthDate.text = "${sdf.format(dob.time)} ($age ปี)"

        // set human age
        fun log2(n: Int): Double {
            return ln(n.toDouble()) / ln(2.0)
        }
        holder.petHumanAge.text = when(item.petType){
            PetType.dog -> {
                when(age){
                    0 -> "อายุคน: น้อยกว่า 31 ปี"
                    else -> "อายุคน: ${Math.round((16 * ln(age.toDouble())) + 31)} ปี"
                }
            }
            else -> {
                when(age){
                    0 -> "อายุคน: น้อยกว่า 18 ปี"
                    in 1..5 -> "อายุคน: ${((age * 19)/3)+1} ปี"
                    else -> "อายุคน: ${((age-6)*4)+40} ปี"
                }
            }
        }
//        ({
//            when(age){
//                in 0..5 -> ((age * 19)/3)+1
//                else -> ((age-6)*4)+40
//            }
//        }).toString()
        // Set hearts icon
        if (item.lovePoint in 10..19){
            holder.heart1.setImageResource(R.drawable.ic_baseline_favorite_24_pink)
        } else if(item.lovePoint in 20..29){
            holder.heart1.setImageResource(R.drawable.ic_baseline_favorite_24_pink)
            holder.heart2.setImageResource(R.drawable.ic_baseline_favorite_24_pink)
        } else if(item.lovePoint in 30..39){
            holder.heart1.setImageResource(R.drawable.ic_baseline_favorite_24_pink)
            holder.heart2.setImageResource(R.drawable.ic_baseline_favorite_24_pink)
            holder.heart3.setImageResource(R.drawable.ic_baseline_favorite_24_pink)
        } else if(item.lovePoint in 40..49){
            holder.heart1.setImageResource(R.drawable.ic_baseline_favorite_24_pink)
            holder.heart2.setImageResource(R.drawable.ic_baseline_favorite_24_pink)
            holder.heart3.setImageResource(R.drawable.ic_baseline_favorite_24_pink)
            holder.heart4.setImageResource(R.drawable.ic_baseline_favorite_24_pink)
        } else if(item.lovePoint in 50..59){
            holder.heart1.setImageResource(R.drawable.ic_baseline_favorite_24_pink)
            holder.heart2.setImageResource(R.drawable.ic_baseline_favorite_24_pink)
            holder.heart3.setImageResource(R.drawable.ic_baseline_favorite_24_pink)
            holder.heart4.setImageResource(R.drawable.ic_baseline_favorite_24_pink)
            holder.heart5.setImageResource(R.drawable.ic_baseline_favorite_24_pink)
        } else if(item.lovePoint >= 60){
            holder.heart1.setImageResource(R.drawable.ic_baseline_favorite_24_pink)
            holder.heart2.setImageResource(R.drawable.ic_baseline_favorite_24_pink)
            holder.heart3.setImageResource(R.drawable.ic_baseline_favorite_24_pink)
            holder.heart4.setImageResource(R.drawable.ic_baseline_favorite_24_pink)
            holder.heart5.setImageResource(R.drawable.ic_baseline_favorite_24_pink)
            holder.heart6.setImageResource(R.drawable.ic_baseline_favorite_24_pink)
        }

    }

    /**
     * Return the size of your dataset (invoked by the layout manager)
     */
    override fun getItemCount() = dataset.size
}