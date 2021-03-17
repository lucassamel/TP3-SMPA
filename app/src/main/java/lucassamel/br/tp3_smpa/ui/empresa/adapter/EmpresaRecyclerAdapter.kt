package lucassamel.br.tp3_smpa.ui.empresa.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.list_empresa_recycler.view.*
import lucassamel.br.tp3_smpa.R
import lucassamel.br.tp3_smpa.model.Empresa

class EmpresaRecyclerAdapter(private val empresas: List<Empresa>,
                             private val actionClick: (Empresa) -> Unit
): RecyclerView.Adapter<EmpresaRecyclerAdapter.EmpresaViewHolder>() {

    class EmpresaViewHolder(itemView: View)
        : RecyclerView.ViewHolder(itemView) {
        val textMarca: TextView = itemView.textViewNomeEmpresa
        val textModelo: TextView = itemView.textViewBairroEmpresa
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmpresaViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(
                R.layout.list_empresa_recycler,
                parent, false
            )
        return EmpresaViewHolder(view)
    }

    override fun onBindViewHolder(holder: EmpresaViewHolder, position: Int) {
        val empresa = empresas[position]
        holder.textMarca.text = empresa.nomeEmpresa
        holder.textModelo.text = empresa.bairro
        holder.itemView.btnDeleteEmpresa.setOnClickListener {
            deleteEmpresa(empresa)
        }

        holder.itemView.btnAvaliacoes.setOnClickListener {
            Navigation.createNavigateOnClickListener(R.id.action_listEmpresaFragment_to_listPerguntasFragment).onClick(holder.itemView)
        }

        holder.itemView.setOnClickListener {
            actionClick(empresa)

        }
    }

//    private fun avalaiacoesEmpresa(empresa: Empresa): Task<Void> {
//        val collection = FirebaseFirestore.getInstance().collection("empresas")
//
//        return
//
//    }

    override fun getItemCount(): Int = empresas.size

    private fun deleteEmpresa(empresa: Empresa): Task<Void> {
        val collection = FirebaseFirestore.getInstance().collection("empresas")

        return collection
            .document(empresa.nomeEmpresa!!)
            .delete()
    }
}