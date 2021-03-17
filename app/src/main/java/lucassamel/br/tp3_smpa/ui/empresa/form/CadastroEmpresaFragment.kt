package lucassamel.br.tp3_smpa.ui.empresa.form

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import lucassamel.br.tp3_smpa.R

class CadastroEmpresaFragment : Fragment() {

    companion object {
        fun newInstance() = CadastroEmpresaFragment()
    }

    private lateinit var viewModel: CadastroEmpresaViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.cadastro_empresa_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(CadastroEmpresaViewModel::class.java)
        // TODO: Use the ViewModel
    }

}