package lucassamel.br.tp3_smpa.ui.empresa.list

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import lucassamel.br.tp3_smpa.R

class ListEmpresaFragment : Fragment() {

    companion object {
        fun newInstance() = ListEmpresaFragment()
    }

    private lateinit var viewModel: ListEmpresaViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.list_empresa_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ListEmpresaViewModel::class.java)
        // TODO: Use the ViewModel
    }

}