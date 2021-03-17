package lucassamel.br.tp3_smpa.model

import com.google.firebase.firestore.DocumentId

class Empresa(
    @DocumentId
    val nomeEmpresa: String? = null,
    val bairro: String? = null

) {
}