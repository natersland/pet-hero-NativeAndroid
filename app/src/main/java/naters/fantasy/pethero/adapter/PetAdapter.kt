package com.example.affirmations.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import naters.fantasy.pethero.R
import naters.fantasy.pethero.model.PetData

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
//        val petBirthDate: TextView = view.findViewById(R.id.card_birthday_value)
//        val petHumanAge: TextView = view.findViewById(R.id.card_human_age_value)

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
//        holder.petBirthDate.text = item.petBirthDate
//        holder.petHumanAge.text = "${item.humanAge}"
    }

    /**
     * Return the size of your dataset (invoked by the layout manager)
     */
    override fun getItemCount() = dataset.size
}