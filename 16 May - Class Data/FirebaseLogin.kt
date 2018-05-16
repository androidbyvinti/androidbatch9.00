class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


loginButton.setOnClickListener {
            name = nameEditText.text.toString()
            email = emailEditText.text.toString()
            password = passwordEditText.text.toString()

            firebaseAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this@MainActivity) { task ->
                        if (task.isSuccessful) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("MainActivity", "signInWithEmail:success")
                            startActivity(Intent(this@MainActivity, WelcomeActivity::class.java))
                        } else {
                            Log.w("MainActivity", "signInWithEmail:failure", task.exception)
                            Toast.makeText(this@MainActivity, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show()
                        }
                    }
        }
    }
