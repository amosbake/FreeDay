package mopel.io.freeday.activity

import org.jetbrains.anko.toast

class MainActivity : android.support.v7.app.AppCompatActivity() {
    companion object {
        private val TAG = "log"
    }
    private val auth: com.google.firebase.auth.FirebaseAuth by lazy {
        com.google.firebase.auth.FirebaseAuth.getInstance()
    }

    private val authListener: com.google.firebase.auth.FirebaseAuth.AuthStateListener by lazy{
        com.google.firebase.auth.FirebaseAuth.AuthStateListener {
            val user = auth.currentUser
            if (user!=null){
                android.util.Log.d(mopel.io.freeday.activity.MainActivity.Companion.TAG, "onAuthStateChanged:signed_in:" + user.uid)
            }else{
                android.util.Log.d(mopel.io.freeday.activity.MainActivity.Companion.TAG, "onAuthStateChanged:signed_out");
            }

        }
    }

    override fun onCreate(savedInstanceState: android.os.Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mopel.io.freeday.R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        auth.addAuthStateListener(authListener)
    }

    override fun onStop() {
        super.onStop()
        auth.removeAuthStateListener(authListener)
    }

    private fun signInWithEmailAndPassword(email:String ,password:String){
        auth.signInWithEmailAndPassword(email,password)
                .addOnCompleteListener(this){
                    android.util.Log.d(mopel.io.freeday.activity.MainActivity.Companion.TAG, "signInWithEmail:onComplete:" + it.isSuccessful);
                    if (!it.isSuccessful){
                        android.util.Log.w(mopel.io.freeday.activity.MainActivity.Companion.TAG, "signInWithEmail:failed", it.exception)
                        toast("auth fail")
                    }
                }
    }
}
