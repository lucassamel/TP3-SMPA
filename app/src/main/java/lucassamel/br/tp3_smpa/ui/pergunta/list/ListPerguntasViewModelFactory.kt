package lucassamel.br.tp3_smpa.ui.pergunta.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import lucassamel.br.tp3_smpa.dao.pergunta.PerguntaDao

class ListPerguntasViewModelFactory(private val perguntaDao: PerguntaDao
                                    )
    : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ListPerguntasViewModel::class.java))
            return ListPerguntasViewModel(perguntaDao) as T
        throw IllegalArgumentException("Classe ViewModel desconhecida.")
    }
}