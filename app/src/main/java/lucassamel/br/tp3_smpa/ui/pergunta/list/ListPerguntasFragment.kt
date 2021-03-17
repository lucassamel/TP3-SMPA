package lucassamel.br.tp3_smpa.ui.pergunta.list

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import lucassamel.br.tp3_smpa.R

class ListPerguntasFragment : Fragment() {

    companion object {
        fun newInstance() = ListPerguntasFragment()
    }

    private lateinit var viewModel: ListPerguntasViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.list_perguntas_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ListPerguntasViewModel::class.java)
        // TODO: Use the ViewModel
    }

}