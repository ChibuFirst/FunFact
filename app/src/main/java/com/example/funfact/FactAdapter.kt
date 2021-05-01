package com.example.funfact

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class FactAdapter(context: Context, factList: List<FactModel>) :
    ArrayAdapter<FactModel>(context, 0, factList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var view = convertView
        val fact = getItem(position)
        if (view == null) {
            view = LayoutInflater.from(parent.context).inflate(R.layout.fact_item, parent, false)
        }
        val imageLogo = view?.findViewById<ImageView>(R.id.imageLogo)
        val textName = view?.findViewById<TextView>(R.id.textName)

        fact?.logo?.let { imageLogo?.setImageResource(it) }
        textName?.text = fact?.name

        view?.setOnClickListener {
            val intent = Intent(parent.context, DetailActivity::class.java)
            intent.putExtra(LOGO_EXTRAS, fact?.logo)
            intent.putExtra(NAME_EXTRAS, fact?.name)
            intent.putExtra(FACT_EXTRAS, fact?.fact)
            parent.context.startActivity(intent)
        }

        return view!!
    }

    companion object {
        const val LOGO_EXTRAS = "logo_extras"
        const val NAME_EXTRAS = "name_extras"
        const val FACT_EXTRAS = "fact_extras"
    }

}