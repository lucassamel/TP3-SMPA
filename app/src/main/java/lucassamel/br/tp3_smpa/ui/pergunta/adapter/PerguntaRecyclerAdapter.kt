package lucassamel.br.tp3_smpa.ui.pergunta.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.list_empresa_recycler.view.*
import kotlinx.android.synthetic.main.list_pergunta_recycler.view.*
import lucassamel.br.tp3_smpa.R
import lucassamel.br.tp3_smpa.model.Empresa
import lucassamel.br.tp3_smpa.model.Pergunta
import lucassamel.br.tp3_smpa.ui.empresa.adapter.EmpresaRecyclerAdapter

class PerguntaRecyclerAdapter(
        private val perguntas: List<Pergunta>,
        private val actionClick: (Pergunta) -> Unit
) : RecyclerView.Adapter<PerguntaRecyclerAdapter.PerguntaViewHolder>() {

    class PerguntaViewHolder(itemView: View)
        : RecyclerView.ViewHolder(itemView) {
        val textComentario: TextView = itemView.textViewPeruntaComentario
        val textPontuacao: TextView = itemView.textViewPerguntaPontuacao
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PerguntaViewHolder {
        val view = LayoutInflater
                .from(parent.context)
                .inflate(
                        R.layout.list_empresa_recycler,
                        parent, false
                )
        return PerguntaViewHolder(view)
    }

    override fun onBindViewHolder(holder: PerguntaViewHolder, position: Int) {
        val pergunta = perguntas[position]
        holder.textComentario.text = pergunta.comentario
        holder.textPontuacao.text = pergunta.pontuacao.toString()
        holder.itemView.btnDeletePergunta.setOnClickListener {
            deletePergunta(pergunta)
        }

//        holder.itemView.btnAvaliacoes.setOnClickListener {
//            Navigation.createNavigateOnClickListener(R.id.action_listEmpresaFragment_to_listPerguntasFragment).onClick(holder.itemView)
//        }

        holder.itemView.setOnClickListener {
            actionClick(pergunta)

        }
    }

    override fun getItemCount(): Int = perguntas.size

    private fun deletePergunta(pergunta: Pergunta): Task<Void> {
        val collection = FirebaseFirestore.getInstance().collection("perguntas")

        return collection
                .document(pergunta.empresa!!.toString())
                .delete()
    }
}