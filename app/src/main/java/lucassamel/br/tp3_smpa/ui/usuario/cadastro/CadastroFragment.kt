package lucassamel.br.tp3_smpa.ui.usuario.cadastro

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.cadastro_fragment.*
import lucassamel.br.tp3_smpa.R

class CadastroFragment : Fragment() {

    private lateinit var viewModel: CadastroViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this).get(CadastroViewModel::class.java)

        viewModel.status.observe(viewLifecycleOwner, Observer {
            if (it)
                findNavController().popBackStack()
        })

        viewModel.msg.observe(viewLifecycleOwner, Observer {
            if (!it.isNullOrBlank())
                Toast
                    .makeText(
                        requireContext(),
                        it,
                        Toast.LENGTH_LONG
                    ).show()

        })

        return inflater.inflate(R.layout.cadastro_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnCadastrar.setOnClickListener {
            val email = editTextCadastrarEmail.text.toString()
            val senha = editTextCadastrarSenha.text.toString()
            val resenha = editTextCadastrarRepetirSenha.text.toString()
            if (senha == resenha){
                viewModel.salvarCadastro(email,senha)
            } else {
                viewModel.alterarMsg("Senhas não conferem")
            }
        }
    }

}