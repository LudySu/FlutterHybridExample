package orz.ludysu.hybrid

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import io.flutter.facade.Flutter
import io.flutter.view.FlutterView

/**
 * @author Ludy Su
 */
class FlutterHostFragment: Fragment() {

    companion object {
        fun newInstance(): FlutterHostFragment {
            return FlutterHostFragment()
        }
    }

    private var flutterView: FlutterView? = null


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        flutterView = Flutter.createView(activity as Activity, lifecycle, null)
        return flutterView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as AppCompatActivity).supportActionBar?.apply {
            title = "Flutter Fragment"
        }
    }

}
