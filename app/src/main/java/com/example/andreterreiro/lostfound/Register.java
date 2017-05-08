package com.example.andreterreiro.lostfound;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Register extends AppCompatActivity implements View.OnClickListener {

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private String nUser;
    private String p1;
    private String p2;
    private String mail;
    private String nome;
    private Button reg;
    public EditText u = (EditText) findViewById(R.id.num_aluno);
    public EditText pa1 = (EditText) findViewById(R.id.pass1);
    public EditText pa2 = (EditText) findViewById(R.id.pass2);
    public EditText name = (EditText) findViewById(R.id.nome);
    public EditText m = (EditText) findViewById(R.id.mail);
    private static final String TAG = "Firebase";
    private String passF;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        reg = (Button) findViewById(R.id.register);
        nUser = ((EditText) findViewById(R.id.num_aluno)).getText().toString();
        p1 = ((EditText) findViewById(R.id.pass1)).getText().toString().trim();
        p2 = ((EditText) findViewById(R.id.pass2)).getText().toString().trim();
        mail = ((EditText) findViewById(R.id.mail)).getText().toString().trim();
        nome = ((EditText) findViewById(R.id.nome)).getText().toString().trim();

        if (p1.equals(p2)){
            passF = p1;
        }

        reg.setOnClickListener(this);
    }

    private boolean validateForm() {
        boolean valid = true;


        if(TextUtils.isEmpty(nUser)){
            u.setError("Required.");
            valid = false;
        }else {
            u.setError(null);
        }

        if (TextUtils.isEmpty(p1)) {
            pa1.setError("Required.");
            valid = false;
        } else {
            pa1.setError(null);
        }
        if (TextUtils.isEmpty(p2)) {
            pa2.setError("Required.");
            valid = false;
        } else {
            pa2.setError(null);
        }
        if (TextUtils.isEmpty(nome)) {
            name.setError("Required.");
            valid = false;
        } else {
            name.setError(null);
        }
        if (TextUtils.isEmpty(mail)) {
            m.setError("Required.");
            valid = false;
        } else {
            m.setError(null);
        }

        if (p1.equals(p2)) {
            pa1.setError(null);
        } else {
            pa1.setError("Required.");
            pa2.setError("Required.");
            valid = false;
        }

        return valid;
    }

    @Override
    public void onClick(View v) {


        if (!validateForm()) {
            return;
        }
        if(TextUtils.isEmpty(passF)){
            return;
        }else {
            mAuth.createUserWithEmailAndPassword(mail,passF )
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            // If sign in fails, display a message to the user. If sign in succeeds
                            // the auth state listener will be notified and logic to handle the
                            // signed in user can be handled in the listener.
                            if (!task.isSuccessful()) {
                                Log.w(TAG, "signInWithEmail:failed", task.getException());
                                Toast.makeText(Register.this, "ERRO REGISTO", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }
    }
}
