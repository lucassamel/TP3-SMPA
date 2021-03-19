package lucassamel.br.tp3_smpa.ui.pergunta.list

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import lucassamel.br.tp3_smpa.dao.pergunta.PerguntaDao
import lucassamel.br.tp3_smpa.model.Empresa
import lucassamel.br.tp3_smpa.model.Pergunta

class ListPerguntasViewModel(
        private val perguntaDao: PerguntaDao
) : ViewModel() {

    private val _perguntas = MutableLiveData<List<Pergunta>>()
    val perguntas: MutableLiveData<List<Pergunta>> = _perguntas

    fun atualizarQuantidade() {
        perguntaDao.all() // task<>
                .addSnapshotListener { snapshot, error ->
                    if (error != null)
                        Log.i("LstCarroVMSnapshotError", "${error.message}")
                    else
                        if (snapshot != null && !snapshot.isEmpty)
                            _perguntas.value = snapshot.toObjects(Pergunta::class.java)
                }
    }
}