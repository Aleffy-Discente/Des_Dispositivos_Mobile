import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.at8.HomeFragmentDirections
import com.example.at8.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonGoToDetails.setOnClickListener {
            // ID do item que queremos passar
            val itemId = "123-ABC"

            // Use a classe Directions gerada pelo Safe Args
            val action = HomeFragmentDirections.actionHomeFragmentToDetailFragment(itemId)

            // Navegue usando a ação
            findNavController().navigate(action)
        }
    }
    // ... Boilerplate de ViewBinding
}