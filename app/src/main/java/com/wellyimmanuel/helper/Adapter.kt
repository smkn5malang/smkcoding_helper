//package com.wellyimmanuel.helper
//
//import android.content.Context
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.ArrayAdapter
//import android.widget.EditText
//import android.widget.Spinner
//import android.widget.TextView
//import kotlinx.android.synthetic.main.activity_register.view.*
//
//class Adapter(val mCtx: Context, val layoutResId: Int, val list: List<Users> )
//    : ArrayAdapter<Users>(mCtx,layoutResId,list){
//
//    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
//        val layoutInflater: LayoutInflater = LayoutInflater.from(mCtx)
//        val view: View = layoutInflater.inflate(layoutResId,null)
//
//        val textNama = view.findViewById<EditText>(R.id.inputName)
//        val textNumber = view.findViewById<EditText>(R.id.inputNumberPhone)
//        val textWork = view.findViewById<TextView>(R.id.spinnerWork)
//
//        val user = list[position]
//
//        textNama.text = user.nama
//        textNumber.text = user.Number
//        textWork.text = user.Work
//
//        return view
//
//    }
//}