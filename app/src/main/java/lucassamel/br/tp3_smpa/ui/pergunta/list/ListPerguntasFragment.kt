package lucassamel.br.tp3_smpa.ui.pergunta.list

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.list_perguntas_fragment.*
import lucassamel.br.tp3_smpa.R
import lucassamel.br.tp3_smpa.dao.pergunta.PerguntaDaoFirestore
import lucassamel.br.tp3_smpa.model.AppUtil
import lucassamel.br.tp3_smpa.model.Pergunta
import lucassamel.br.tp3_smpa.ui.empresa.list.ListEmpresaViewModel
import lucassamel.br.tp3_smpa.ui.pergunta.adapter.PerguntaRecyclerAdapter

class ListPerguntasFragment : Fragment() {

    private lateinit var viewModel: ListPerguntasViewModel
    private lateinit var viewModelEmpresa : ListEmpresaViewModel

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        val application = requireActivity().application

        val firebaseAuth = FirebaseAuth.getInstance()
//        val firebaseUser = firebaseAuth.currentUser
//        if (firebaseUser == null)
//            findNavController().popBackStack()


        val listPerguntas = ListPerguntasViewModelFactory(PerguntaDaoFirestore())

        viewModel = ViewModelProvider(this, listPerguntas)
                .get(ListPerguntasViewModel::class.java)

        viewModel.perguntas.observe(viewLifecycleOwner) {
            setupListViewEmpresas(it)
        }

        viewModel.atualizarQuantidade()

        return inflater.inflate(R.layout.list_perguntas_fragment, container, false)
    }

    private fun setupListViewEmpresas(perguntas: List<Pergunta>) {
        listPerguntas.adapter = PerguntaRecyclerAdapter(perguntas) {
            AppUtil.perguntaSelecionada = it
//            findNavController().navigate(R.id.)
        }
        listPerguntas.layoutManager = LinearLayoutManager(requireContext())
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fabPerguntaCadastro.setOnClickListener {
            findNavController().navigate(R.id.action_listPerguntasFragment_to_cadastroPerguntasFragment)
        }

    }

}