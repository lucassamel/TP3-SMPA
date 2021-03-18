package lucassamel.br.tp3_smpa.dao.pergunta

import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QuerySnapshot
import lucassamel.br.tp3_smpa.model.Empresa
import lucassamel.br.tp3_smpa.model.Pergunta

class PerguntaDaoFirestore : PerguntaDao {

    private val collection = FirebaseFirestore
            .getInstance()
            .collection("perguntas")

    override fun insert(pergunta: Pergunta): Task<Void> {
        return collection
                .document(pergunta.titutlo!!)
                .set(pergunta)
    }

    override fun delete(pergunta: Pergunta): Task<Void> {
        return collection
                .document(pergunta.titutlo!!)
                .delete()
    }

    override fun get(titulo: String): Task<DocumentSnapshot> {
        return collection
                .document(titulo)
                .get()
    }

    override fun selectByTitulo(titulo: String): Task<QuerySnapshot> {
        return collection
                .whereEqualTo("titulo", titulo)
                .get()
    }

    override fun all(): CollectionReference {
        return collection
    }
}