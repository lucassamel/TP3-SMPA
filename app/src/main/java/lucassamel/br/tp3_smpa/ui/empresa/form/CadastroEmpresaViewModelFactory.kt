package lucassamel.br.tp3_smpa.ui.empresa.form

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import lucassamel.br.tp3_smpa.dao.empresa.EmpresaDaoFirestore

class CadastroEmpresaViewModelFactory(private val empresaDao: EmpresaDaoFirestore,
                                      private val application: Application
): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CadastroEmpresaViewModel::class.java))
            return CadastroEmpresaViewModel(empresaDao) as T
        throw IllegalArgumentException("Classe ViewModel desconhecida.")
    }
}