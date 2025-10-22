import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.at8.DetailFragmentArgs
import com.example.at8.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {

    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!

    // Delegado de propriedade para obter os argumentos de forma segura
    private val args: DetailFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Acesse o argumento de forma segura
        val receivedItemId = args.itemId
        binding.textViewDetail.text = "Detalhes do item: $receivedItemId"
    }
    // ... Boilerplate de ViewBinding
}