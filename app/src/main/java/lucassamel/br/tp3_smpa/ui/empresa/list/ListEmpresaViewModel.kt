package lucassamel.br.tp3_smpa.ui.empresa.list

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import lucassamel.br.tp3_smpa.dao.empresa.EmpresaDao
import lucassamel.br.tp3_smpa.model.Empresa

class ListEmpresaViewModel(
    private val empresaDao: EmpresaDao
) : ViewModel() {

    private val _empresas = MutableLiveData<List<Empresa>>()
    val empresas: LiveData<List<Empresa>> = _empresas

    fun atualizarQuantidade() {
        empresaDao.all() // task<>
            .addSnapshotListener { snapshot, error ->
                if (error != null)
                    Log.i("LstCarroVMSnapshotError", "${error.message}")
                else
                    if (snapshot != null && !snapshot.isEmpty)
                        _empresas.value = snapshot.toObjects(Empresa::class.java)
            }
    }

}