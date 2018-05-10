package com.bmpl.firebaseapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_register.*
import android.widget.Toast
import jdk.nashorn.internal.runtime.ECMAException.getException
import org.junit.experimental.results.ResultMatchers.isSuccessful
import android.support.annotation.NonNull
import android.R.attr.password
import android.support.v4.app.FragmentActivity
import android.util.Log


class RegisterActivity : AppCompatActivity() {

    //FirebaseAuth --> Predefiend class --> Firebase Auth add in project

    //write data into database --> name, phn, address

    lateinit var firebaseAuth : FirebaseAuth

    lateinit var firebaseDatabase : FirebaseDatabase
    lateinit var databaseReference : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        firebaseAuth = FirebaseAuth.getInstance()   // predefined  -->

        // take user information and pass to firebase for account creation
        registerButton.setOnClickListener {
            // new View.OnClickListner(){}
            var userName = name.text.toString()
            var userEmail = email.text.toString()
            var userPassword = password.text.toString()

            // now do validation work with these fields
                                                // email, password
            firebaseAuth.createUserWithEmailAndPassword(userEmail, userPassword)
                    .addOnCompleteListener(this@RegisterActivity)
                    {
                        fun onComplete(task: Task<AuthResult>) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                Log.d(FragmentActivity.TAG, "createUserWithEmail:success")
                                val user = mAuth.getCurrentUser()
                                updateUI(user)
                            } else {
                                // If sign in fails, display a message to the user.
                                Log.w(FragmentActivity.TAG, "createUserWithEmail:failure", task.getException())
                                Toast.makeText(this@EmailPasswordActivity, "Authentication failed.",
                                        Toast.LENGTH_SHORT).show()
                                updateUI(null)
                            }

                            // ...
                        }
                    }


        }

        loginButton.setOnClickListener {

            // intent to redirect user on another screen
            // New Screen -->
        }


    }
}
