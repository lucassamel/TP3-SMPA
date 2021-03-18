package lucassamel.br.tp3_smpa.ui.pergunta.form

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import lucassamel.br.tp3_smpa.R
import lucassamel.br.tp3_smpa.dao.empresa.EmpresaDaoFirestore
import lucassamel.br.tp3_smpa.dao.pergunta.PerguntaDaoFirestore
import lucassamel.br.tp3_smpa.ui.empresa.form.CadastroEmpresaViewModel
import lucassamel.br.tp3_smpa.ui.empresa.form.CadastroEmpresaViewModelFactory

class CadastroPerguntasFragment : Fragment() {

    private lateinit var viewModel: CadastroPerguntasViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val application = requireActivity().application

        val cadastroPerguntaViewModelFactory = CadastroPerguntasViewModelFactory(
                PerguntaDaoFirestore(),
                application)

        viewModel = ViewModelProvider(this, cadastroPerguntaViewModelFactory)
                .get(CadastroPerguntasViewModel::class.java)

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

        return inflater.inflate(R.layout.cadastro_perguntas_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



    }

}