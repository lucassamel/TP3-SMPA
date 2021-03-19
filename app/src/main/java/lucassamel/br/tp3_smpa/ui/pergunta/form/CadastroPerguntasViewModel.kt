package lucassamel.br.tp3_smpa.ui.pergunta.form

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import lucassamel.br.tp3_smpa.dao.empresa.EmpresaDaoFirestore
import lucassamel.br.tp3_smpa.dao.pergunta.PerguntaDao
import lucassamel.br.tp3_smpa.model.AppUtil
import lucassamel.br.tp3_smpa.model.Empresa
import lucassamel.br.tp3_smpa.model.Pergunta

class CadastroPerguntasViewModel(
        private val perguntaDao: PerguntaDao
) : ViewModel() {

    private val _status = MutableLiveData<Boolean>()
    val status: LiveData<Boolean> = _status

    private val _msg = MutableLiveData<String?>()
    val msg: MutableLiveData<String?> = _msg

    private var empresa: Empresa? = null

    private lateinit var empresaSelecionada : EmpresaDaoFirestore

    init {
        _status.value = false
        _msg.value = null
         empresaSelecionada = EmpresaDaoFirestore()

    }

//    fun empresaSelecionanda(empresa: String) {
//        this.empresa = empresa
//    }

    fun insertPergunta(titulo: String, pontuacao: Int, comentario: String) {

        val empresaS = AppUtil.empresaSelecionada?.nomeEmpresa

        if (empresaS == null){
            _status.value = true
        }

        var empresaAtual = empresaS?.let {
            FirebaseFirestore.getInstance()
                .collection("empresas")
                .document(it)
        }

        val pergunta = Pergunta(titulo, pontuacao, empresaAtual, comentario)

        perguntaDao.insert(pergunta)
                .addOnSuccessListener {
                    _status.value = true
                    _msg.value = "Persistência realizada com sucesso."
                }
                .addOnFailureListener {
                    _msg.value = "${it.message}"
                }
    }

}