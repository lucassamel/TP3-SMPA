package lucassamel.br.tp3_smpa.dao.pergunta

import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.QuerySnapshot
import lucassamel.br.tp3_smpa.model.Empresa
import lucassamel.br.tp3_smpa.model.Pergunta

interface PerguntaDao {

    fun insert(pergunta: Pergunta): Task<Void>

    fun delete(pergunta: Pergunta) : Task<Void>

    fun get(titulo: String): Task<DocumentSnapshot>

    fun selectByTitulo(titulo: String): Task<QuerySnapshot>

    fun all(): CollectionReference
}