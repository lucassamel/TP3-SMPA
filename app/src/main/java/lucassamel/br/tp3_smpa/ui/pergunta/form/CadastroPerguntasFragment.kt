package lucassamel.br.tp3_smpa.ui.pergunta.form

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import lucassamel.br.tp3_smpa.R

class CadastroPerguntasFragment : Fragment() {

    companion object {
        fun newInstance() = CadastroPerguntasFragment()
    }

    private lateinit var viewModel: CadastroPerguntasViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.cadastro_perguntas_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(CadastroPerguntasViewModel::class.java)
        // TODO: Use the ViewModel
    }

}