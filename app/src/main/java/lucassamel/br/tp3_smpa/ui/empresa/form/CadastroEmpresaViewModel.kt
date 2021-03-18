package lucassamel.br.tp3_smpa.ui.empresa.form

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import lucassamel.br.tp3_smpa.dao.empresa.EmpresaDao
import lucassamel.br.tp3_smpa.dao.pergunta.PerguntaDao
import lucassamel.br.tp3_smpa.model.Empresa

class CadastroEmpresaViewModel(
    private val empresaDao: EmpresaDao
) : ViewModel() {

    private val _status = MutableLiveData<Boolean>()
    val status: LiveData<Boolean> = _status

    private val _msg = MutableLiveData<String?>()
    val msg: MutableLiveData<String?> = _msg

    init {
        _status.value = false
        _msg.value = null
    }

    fun inserCarro(nomeEmpresa: String, bairro: String) {
        val empresa = Empresa(nomeEmpresa,bairro)
        empresaDao.insert(empresa)
            .addOnSuccessListener {
                _status.value = true
                _msg.value = "Persistência realizada com sucesso."
            }
            .addOnFailureListener {
                _msg.value = "${it.message}"
            }
    }
}