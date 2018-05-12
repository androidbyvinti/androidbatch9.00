package com.bmpl.firebaseapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_register.*
import android.widget.Toast
import jdk.nashorn.internal.runtime.ECMAException.getException
import org.junit.experimental.results.ResultMatchers.isSuccessful
import android.support.annotation.NonNull
import android.R.attr.password
import android.content.Intent
import android.support.v4.app.FragmentActivity
import android.util.Log


class RegisterActivity : AppCompatActivity() {

    //FirebaseAuth --> Predefiend class --> Firebase Auth add in project

    //write data into database --> name, phn, address

    lateinit var firebaseUser : FirebaseUser    // Current User --> unique key --> Information


    lateinit var firebaseAuth : FirebaseAuth

    lateinit var firebaseDatabase : FirebaseDatabase
    lateinit var databaseReference : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        firebaseAuth = FirebaseAuth.getInstance()   // predefined  -->

        databaseReference.addValueEventListener(object : ValueEventListener {
            // update into database
            override fun onDataChange(dataSnapshot: DataSnapshot) {

                if (dataSnapshot.child("counter").exists()) {
                    var c: Int = dataSnapshot.child("counter").value.toString().toInt()

                    counter = c

                    Log.i("MainActivity", "Counter value  = $counter")
                }
            }

            override fun onCancelled(error: DatabaseError) {

            }
        })


        // take user information and pass to firebase for account creation
        registerButton.setOnClickListener {
            // new View.OnClickListner(){}
            var userName = name.text.toString()
            var userEmail = email.text.toString()
            var userPassword = password.text.toString()

            // now do validation work with these fields
                                                // email, password
            firebaseAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this@MainActivity) { task ->
                        if (task.isSuccessful) {

                                    firebaseUser = firebaseAuth.currentUser!!


                            // either write the data on the key or update the data if the key is already created
                            //databaseReference.setValue(name)

                            databaseReference.child("Customer" + counter).child("name").setValue(name)
                            databaseReference.child("Customer" + counter).child("phn").setValue("986556565")
                            databaseReference.child("Customer" + counter).child("address").setValue("Delhi")
                            counter++
                            // counter : 2
                            databaseReference.child("counter").setValue(counter)


                                   databaseReference.child(firebaseUser.uid).child("name").setValue(name)
                                    databaseReference.child(firebaseUser.uid).child("phn").setValue("981254764")


                            Toast.makeText(this@MainActivity, "Account Created",
                                    Toast.LENGTH_SHORT).show()

                            Log.d("MainActivity", "createUserWithEmail:success")
                            startActivity(Intent(this@MainActivity, WelcomeActivity::class.java))
                        } else {
                            Log.w("MainActivity", "createUserWithEmail:failure", task.exception)
                            Toast.makeText(this@MainActivity, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show()

                        }
                    }


        }

        loginButton.setOnClickListener {

            // intent to redirect user on another screen
            // New Screen -->
        }


    }
}
