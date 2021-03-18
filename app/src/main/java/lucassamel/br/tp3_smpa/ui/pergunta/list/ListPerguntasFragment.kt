package lucassamel.br.tp3_smpa.ui.pergunta.list

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.list_empresa_fragment.*
import lucassamel.br.tp3_smpa.R
import lucassamel.br.tp3_smpa.dao.pergunta.PerguntaDaoFirestore
import lucassamel.br.tp3_smpa.model.AppUtil
import lucassamel.br.tp3_smpa.model.Empresa
import lucassamel.br.tp3_smpa.model.Pergunta
import lucassamel.br.tp3_smpa.ui.empresa.adapter.EmpresaRecyclerAdapter
import lucassamel.br.tp3_smpa.ui.empresa.list.ListEmpresaViewModelFactory
import lucassamel.br.tp3_smpa.ui.pergunta.adapter.PerguntaRecyclerAdapter

class ListPerguntasFragment : Fragment() {

    private lateinit var viewModel: ListPerguntasViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val application = requireActivity().application

        val firebaseAuth = FirebaseAuth.getInstance()
//        val firebaseUser = firebaseAuth.currentUser
//        if (firebaseUser == null)
//            findNavController().popBackStack()

        val listCarros = ListPerguntasViewModelFactory(PerguntaDaoFirestore())
        viewModel = ViewModelProvider(this,listCarros)
                .get(ListPerguntasViewModel::class.java)

        viewModel.carros.observe(viewLifecycleOwner){
            setupListViewEmpresas(it)
        }

        viewModel.atualizarQuantidade()

        return inflater.inflate(R.layout.list_perguntas_fragment, container, false)
    }

    private fun setupListViewEmpresas(perguntas: List<Pergunta>) {
        empresasList.adapter = PerguntaRecyclerAdapter(perguntas) {
            AppUtil.perguntaSelecionada = it
//            findNavController().navigate(R.id.)
        }
        empresasList.layoutManager = LinearLayoutManager(requireContext())
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

}