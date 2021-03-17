package lucassamel.br.tp3_smpa.ui.usuario.login

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.login_fragment.*
import lucassamel.br.tp3_smpa.R

class LoginFragment : Fragment() {

    private lateinit var viewModel: LoginViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)

        viewModel.status.observe(viewLifecycleOwner, Observer {
            if (it){
                findNavController().navigate(R.id.action_loginFragment_to_listPerguntasFragment)
            }
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

        return inflater.inflate(R.layout.login_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnLoginEntrar.setOnClickListener {
            val email = editTextLoginEmail.text.toString()
            val senha = editTextLoginSenha.text.toString()
            viewModel.verificarUsuario(email,senha)
        }
        btnLoginCadastrar.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_cadastroFragment)
        }
    }

}