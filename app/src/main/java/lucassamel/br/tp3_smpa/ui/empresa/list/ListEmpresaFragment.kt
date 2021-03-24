package lucassamel.br.tp3_smpa.ui.empresa.list

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.list_empresa_fragment.*
import lucassamel.br.tp3_smpa.R
import lucassamel.br.tp3_smpa.dao.empresa.EmpresaDaoFirestore
import lucassamel.br.tp3_smpa.model.AppUtil
import lucassamel.br.tp3_smpa.model.Empresa
import lucassamel.br.tp3_smpa.ui.empresa.adapter.EmpresaRecyclerAdapter

class ListEmpresaFragment : Fragment() {

    private lateinit var viewModel: ListEmpresaViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val application = requireActivity().application

        val firebaseAuth = FirebaseAuth.getInstance()
        val firebaseUser = firebaseAuth.currentUser
        if (firebaseUser == null)
            findNavController().popBackStack()

       val listEmpresas = ListEmpresaViewModelFactory(EmpresaDaoFirestore())

        viewModel = ViewModelProvider(this,listEmpresas)
            .get(ListEmpresaViewModel::class.java)

        viewModel.empresas.observe(viewLifecycleOwner){
            setupListViewEmpresas(it)
        }

        viewModel.atualizarQuantidade()

        return inflater.inflate(R.layout.list_empresa_fragment, container, false)
    }


    private fun setupListViewEmpresas(empresas: List<Empresa>) {
        empresasList.adapter = EmpresaRecyclerAdapter(empresas) {
            AppUtil.empresaSelecionada = it

           findNavController().navigate(R.id.action_listEmpresaFragment_to_listPerguntasFragment)
        }
        empresasList.layoutManager = LinearLayoutManager(requireContext())
    }




    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val firebaseAuth = FirebaseAuth.getInstance()
        val firebaseUser = firebaseAuth.currentUser

        fabCadastroEmpresa.setOnClickListener {
            findNavController().navigate(R.id.action_listEmpresaFragment_to_cadastroEmpresaFragment)
        }

        fabLogout.setOnClickListener {
            firebaseAuth.signOut()
            findNavController().navigate(R.id.action_listEmpresaFragment_to_loginFragment)
        }
    }

}