package lucassamel.br.tp3_smpa.ui.empresa.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import lucassamel.br.tp3_smpa.dao.empresa.EmpresaDaoFirestore

class ListEmpresaViewModelFactory(
    private val empresaDao: EmpresaDaoFirestore
): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ListEmpresaViewModel::class.java))
            return ListEmpresaViewModel(empresaDao) as T
        throw IllegalArgumentException("Classe ViewModel desconhecida.")
    }

}