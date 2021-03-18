package lucassamel.br.tp3_smpa.ui.pergunta.form

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import lucassamel.br.tp3_smpa.dao.pergunta.PerguntaDao
import lucassamel.br.tp3_smpa.ui.empresa.form.CadastroEmpresaViewModel

class CadastroPerguntasViewModelFactory(private val perguntaDao: PerguntaDao,
                                        private val application: Application)
    : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CadastroPerguntasViewModel::class.java))
            return CadastroPerguntasViewModel(perguntaDao) as T
        throw IllegalArgumentException("Classe ViewModel desconhecida.")
    }
}