package lucassamel.br.tp3_smpa.model

import com.google.firebase.firestore.DocumentId
import com.google.firebase.firestore.DocumentReference

class Pergunta(
        @DocumentId
        val titutlo: String? = null,
        val pontuacao: Int? = null,
        val empresa: DocumentReference? = null,
        val comentario: String? = null
) {
}