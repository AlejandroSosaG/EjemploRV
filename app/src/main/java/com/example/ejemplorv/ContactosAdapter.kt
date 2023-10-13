package com.example.ejemplorv

import android.transition.TransitionInflater
import android.transition.TransitionManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ejemplorv.databinding.ItemContactoBinding

class ContactosAdapter(private val contactos: List<Contacto>,
                       private val contactoPulsadoListener : ContactoPulsadoListener) : RecyclerView.Adapter<ContactosAdapter.ViewHolder>() {
    class ViewHolder(private val binding : ItemContactoBinding) : RecyclerView.ViewHolder(binding.root){
        var completo = false
        fun bind (contacto:Contacto){
            if (contacto.genero.equals("Mujer"))
                binding.Foto.setImageResource(R.drawable.avatarfemenino)
            val array = contacto.nombre.split(" ")
            var iniciales : String = array[0][0].plus(array[1].substring(0,1)).plus(array[2].substring(0,1))
            binding.Telefono.text = ""
            binding.Nombre.text = contacto.nombre
            binding.Foto.setOnClickListener(object : View.OnClickListener{
                override fun onClick(v: View?) {
                    if (completo.equals(false)){
                        binding.Nombre.text = contacto.nombre
                        binding.Telefono.text = contacto.tlfn
                        completo = true
                    }else{
                        binding.Nombre.text = contacto.nombre.subSequence(0,1)
                        binding.Telefono.text = ""
                        completo = false
                    }
                }
            })
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemContactoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }
    override fun getItemCount(): Int = contactos.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val transition = TransitionInflater.from(holder.itemView.context).inflateTransition(android.R.transition.fade)

        TransitionManager.beginDelayedTransition(holder.itemView as ViewGroup?, transition)
        holder.bind(contactos[position])
        holder.itemView.setOnClickListener{
            contactoPulsadoListener.contactoPulsado((contactos[position]))
        }
    }
}