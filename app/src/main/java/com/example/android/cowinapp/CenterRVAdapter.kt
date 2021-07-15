package com.example.android.cowinapp

import android.graphics.Color
import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

// on below line we are creating our adapter class
// in this class we are passing our array list
// and our View Holder class which we have created.
class CenterRVAdapter(private val centerList: List<CenterRvModal>) :
    RecyclerView.Adapter<CenterRVAdapter.CenterRVViewHolder>() {

    // on below line we are creating our view holder class which will
    // be used to initialize each view of our layout file.
    class CenterRVViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // on below line we are initializing all our text views along with  its ids.
        val centerNameTV: TextView = itemView.findViewById(R.id.idTVCenterName)
        val centerAddressTV: TextView = itemView.findViewById(R.id.idTVCenterAddress)
        val centerTimings: TextView = itemView.findViewById(R.id.idTVCenterTimings)
        val vaccineNameTV: TextView = itemView.findViewById(R.id.idTVVaccineName)
        val centerAgeLimitTV: TextView = itemView.findViewById(R.id.idTVAgeLimit)
        val centerFeeTypeTV: TextView = itemView.findViewById(R.id.idTVFeeType)
        val avalabilityTV: TextView = itemView.findViewById(R.id.idTVAvaliablity)
    }

    // below method is for on Create Vew Holder.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CenterRVViewHolder {
        // this method is use to inflate the layout file
        // which we have created for our recycler view.
        // on below line we are inflating our layout file.
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.center_rv_item,
            parent, false
        )
        // at last we are returning our view holder
        // class with our item View File.
        return CenterRVViewHolder(itemView)
    }

    // this method is to count the size of our array list.
    override fun getItemCount(): Int {

        // on below line we are returning
        // the size of our array list.
        return centerList.size
    }

    // below method is to set the data to each view of our recycler view item.
    override fun onBindViewHolder(holder: CenterRVViewHolder, position: Int) {

        // on below line we are getting item
        // from our list along with its position.
        val currentItem = centerList[position]
        holder.centerNameTV.setTextColor(Color.WHITE)
        holder.centerAddressTV.setTextColor(Color.WHITE)
        holder.centerAgeLimitTV.setTextColor(Color.WHITE)
        holder.centerFeeTypeTV.setTextColor(Color.WHITE)
        holder.avalabilityTV.setTextColor(Color.WHITE)
        holder.vaccineNameTV.setTextColor(Color.WHITE)
        holder.centerTimings.setTextColor(Color.WHITE)
        holder.centerTimings.setTypeface(null,Typeface.BOLD)
        holder.vaccineNameTV.setTypeface(null,Typeface.BOLD)
        holder.avalabilityTV.setTypeface(null,Typeface.BOLD)
        holder.centerFeeTypeTV.setTypeface(null,Typeface.BOLD)
        holder.centerAgeLimitTV.setTypeface(null,Typeface.BOLD)
        holder.centerAddressTV.setTypeface(null,Typeface.BOLD)
        holder.centerNameTV.setTypeface(null,Typeface.BOLD)
        // after getting current item we are setting
        // data from our list to our text views.
        holder.vaccineNameTV.text = currentItem.vaccineName
        holder.centerNameTV.text = currentItem.centerName
        holder.centerAddressTV.text = currentItem.centerAddress
        holder.centerTimings.text = ("From: " + currentItem.centerFromTime + "\t \t \t\t\t To: " + currentItem.centerToTime)

        if(currentItem.ageLimit.toString()=="18")
            holder.centerAgeLimitTV.text = "Age : " + currentItem.ageLimit.toString()+" - 45"
        else
            holder.centerAgeLimitTV.text = "Age : " + currentItem.ageLimit.toString()+"+"

        holder.centerFeeTypeTV.text = currentItem.fee_type
        holder.avalabilityTV.text = "Availability : " + currentItem.availableCapacity.toString()
    }
}