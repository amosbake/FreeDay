package mopel.io.freeday.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.ActivityOptionsCompat
import android.support.v4.app.ActivityCompat
import android.app.Activity
import mopel.io.freeday.R
import mopel.io.freeday.fragment.SignInFragment
import mopel.io.freeday.helper.Prefs


class SignInActivity : AppCompatActivity() {
    companion object Instance{
        private val TAG = "log"

        fun start(activity: Activity, edit: Boolean?) {
            val starter = Intent(activity, SignInActivity::class.java)
            ActivityCompat.startActivity(activity,
                    starter,
                    ActivityOptionsCompat.makeSceneTransitionAnimation(activity).toBundle())
        }
    }

    val prefs:Prefs by lazy{
        Prefs(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        if (savedInstanceState==null){
            supportFragmentManager.beginTransaction()
                    .replace(R.id.sign_in_container, SignInFragment())
                    .commit()
        }
    }

    override fun onStop() {
        super.onStop()
        if (prefs.login){
            finish()
        }
    }
}
