package lucassamel.br.tp3_smpa.ui.empresa.form

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.cadastro_empresa_fragment.*
import lucassamel.br.tp3_smpa.R
import lucassamel.br.tp3_smpa.dao.empresa.EmpresaDaoFirestore

class CadastroEmpresaFragment : Fragment() {

    private lateinit var viewModel: CadastroEmpresaViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val application = requireActivity().application

        val cadastroEmpresaViewModelFactory = CadastroEmpresaViewModelFactory(
            EmpresaDaoFirestore(),
            application)

        viewModel = ViewModelProvider(this, cadastroEmpresaViewModelFactory)
            .get(CadastroEmpresaViewModel::class.java)

        viewModel.status.observe(viewLifecycleOwner, Observer { status ->
            if (status)
                findNavController().popBackStack()
        })
        viewModel.msg.observe(viewLifecycleOwner, Observer { msg ->
            if (!msg.isNullOrBlank())
                Toast.makeText(
                    requireContext(),
                    msg,
                    Toast.LENGTH_LONG
                ).show()
        })

        return inflater.inflate(R.layout.cadastro_empresa_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnEmpresaCadastro.setOnClickListener {
            val nomeEmpresa = editTextEmpresaNome.text.toString()
            val bairro = editTextEmpresaBairro.text.toString()
            viewModel.inserCarro(nomeEmpresa,bairro)
        }
    }

}