package mopel.io.freeday.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import mopel.io.freeday.R

/**
 * Enable selection of an {@link Avatar} and Email.
 */
class SignInFragment : Fragment() {
    

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater!!.inflate(R.layout.fragment_sign_in, container, false)
    }
}// Required empty public constructor
