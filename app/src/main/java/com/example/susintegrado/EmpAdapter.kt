package com.example.susintegrado

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView



class EmpAdapter (private val empList: ArrayList<EmployeeModel>) : RecyclerView.Adapter<EmpAdapter.ViewHolder>(){
    class ViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvEmpName : TextView = itemView.findViewById(R.id.tvEmpName)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.activity_emp_list_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentEmp = empList[position]
        holder.tvEmpName.text = currentEmp.empNomeUbs
    }

    override fun getItemCount(): Int {
        return empList.size
    }
}