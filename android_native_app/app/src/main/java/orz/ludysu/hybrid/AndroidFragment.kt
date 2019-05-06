package orz.ludysu.hybrid

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_android.*

/**
 * @author Ludy Su
 */
class AndroidFragment: Fragment() {

    companion object {
        fun newInstance(): AndroidFragment {
            return AndroidFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_android, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_go.setOnClickListener {
            fragmentManager?.beginTransaction()?.add(R.id.container, FlutterHostFragment.newInstance())
                ?.addToBackStack("FlutterHostFragment")?.commit()
        }

        (activity as AppCompatActivity).supportActionBar?.apply {
            title = "Android Native"
        }
    }

}