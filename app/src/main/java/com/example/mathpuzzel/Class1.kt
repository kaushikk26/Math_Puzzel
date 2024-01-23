package com.example.mathpuzzel

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListAdapter
import android.widget.TextView

class Class1(var puzzeles: Puzzeles,var array: Array<String>) : BaseAdapter() {
    override fun getCount(): Int {
        return array.size
}

    override fun getItem(position: Int): Any {
        return position
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var card : TextView

        var view = LayoutInflater.from(puzzeles).inflate(R.layout.puzzelbutton, parent, false)
        card=view.findViewById(R.id.card)
        var current = FrontPage.sp.getInt("mylevel",0)


        var check =FrontPage.sp.getString("mylevel${position+1}","lock")
        if(check.equals(FrontPage.complete))
        {
            card.setText(array[position])
            card.setBackgroundResource(R.drawable.done)
        }
        else if(check.equals(FrontPage.skip)){
            card.setText(array[position])

        }
        else if(position==current)
        {
            card.setText(array[position])
        }
        else{
            card.setBackgroundResource(R.drawable.lock)
        }
        return view
    }


}
