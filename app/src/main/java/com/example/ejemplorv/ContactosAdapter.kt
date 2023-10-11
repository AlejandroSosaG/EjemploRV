package com.example.ejemplorv

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ejemplorv.databinding.ItemContactoBinding
import android.view.LayoutInflater

class ContactosAdapter(private val contactos: List<Contacto>,
                       private val contactoPulsadoListener : ContactoPulsadoListener) : RecyclerView.Adapter<ContactosAdapter.ViewHolder>() {
    class ViewHolder(private val binding : ItemContactoBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind (contacto:Contacto){
            binding.Nombre.text = contacto.nombre
            binding.Telefono.text = contacto.tlfn
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemContactoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }



    override fun getItemCount(): Int = contactos.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(contactos[position])
        holder.itemView.setOnClickListener{
            contactoPulsadoListener.contactoPulsado((contactos[position]))
        }
    }
}