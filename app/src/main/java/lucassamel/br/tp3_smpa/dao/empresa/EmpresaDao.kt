package lucassamel.br.tp3_smpa.dao.empresa

import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.QuerySnapshot
import lucassamel.br.tp3_smpa.model.Empresa

interface EmpresaDao {

    fun insert(empresa: Empresa): Task<Void>

    fun delete(empresa: Empresa) : Task<Void>

    fun get(nomeEmpresa: String): Task<DocumentSnapshot>

    fun selectByMarca(bairro: String): Task<QuerySnapshot>

    fun all(): CollectionReference
}