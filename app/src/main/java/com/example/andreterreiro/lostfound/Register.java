package com.example.andreterreiro.lostfound;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.andreterreiro.lostfound.models.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Register extends AppCompatActivity implements View.OnClickListener {

    private FirebaseAuth mAuth;
    private Button reg;
    public EditText u;
    public EditText pa1;
    public EditText pa2;
    public EditText name;
    public EditText m;
    private static final String TAG = "Firebase";
    private String passF;
    DatabaseReference db;
    private ProgressDialog pd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        pd = new ProgressDialog(this);

        reg = (Button) findViewById(R.id.register);

        u = (EditText) findViewById(R.id.num_aluno);
        pa1 = (EditText) findViewById(R.id.pass1);
        pa2 = (EditText) findViewById(R.id.pass2);
        name = (EditText) findViewById(R.id.nome);
        m = (EditText) findViewById(R.id.mail);

        db = FirebaseDatabase.getInstance().getReference();
        mAuth = FirebaseAuth.getInstance();

        reg.setOnClickListener(this);
    }

    private boolean validateForm() {
        boolean valid = true;

        if(TextUtils.isEmpty(u.getText().toString())){
            u.setError("Required.");
            valid = false;
        }else {
            u.setError(null);
        }

        if (TextUtils.isEmpty(pa1.getText().toString())) {
            pa1.setError("Required.");
            valid = false;
        } else {
            pa1.setError(null);
        }
        if (TextUtils.isEmpty(pa2.getText().toString())) {
            pa2.setError("Required.");
            valid = false;
        } else {
            pa2.setError(null);
        }
        if (TextUtils.isEmpty(name.getText().toString())) {
            name.setError("Required.");
            valid = false;
        } else {
            name.setError(null);
        }
        if (TextUtils.isEmpty(m.getText().toString())) {
            m.setError("Required.");
            valid = false;
        } else {
            m.setError(null);
        }

        if (pa1.getText().toString().equals(pa2.getText().toString())) {
            pa1.setError(null);
            passF = pa1.getText().toString();
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
        else if(TextUtils.isEmpty(passF)){
            return;
        }else {
            pd.setMessage("Registing.");
            pd.show();
            mAuth.createUserWithEmailAndPassword(m.getText().toString(),passF)
                    .addOnCompleteListener( this,new OnCompleteListener<AuthResult>() {

                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if (task.isSuccessful()) {
                                Log.d(TAG, "createUserWithEmail:success");

                                String id = db.push().getKey();
                                String tc = "Normal";

                                TelephonyManager tm = (TelephonyManager)getSystemService(TELEPHONY_SERVICE);
                                String n = tm.getLine1Number();

                                Toast.makeText(Register.this, "Registo concluído!", Toast.LENGTH_SHORT).show();

                                User user = new User(Integer.parseInt(u.getText().toString()),name.getText().toString(), m.getText().toString(),passF,tc,n);

                                db.child("Users").child(id).setValue(user);
                                pd.dismiss();

                                Intent gh = new Intent(Register.this,StartActivity.class);
                                startActivity(gh);


                            } else {
                                // If sign in fails, display a message to the user.
                                Log.w(TAG, "createUserWithEmail:failure", task.getException());
                                Toast.makeText(Register.this, "Erro Registo", Toast.LENGTH_SHORT).show();

                            }
                        }
                    });
        }
    }
}
