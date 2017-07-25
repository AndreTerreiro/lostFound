package com.example.andreterreiro.lostfound;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.andreterreiro.lostfound.models.Categoria;
import com.example.andreterreiro.lostfound.models.objetoEncontrado;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class AddFoundObj extends AppCompatActivity implements View.OnClickListener {
    private Button addObj;
    private EditText nome;
    private EditText desc;
    private EditText location;
    private Spinner cat;
    private EditText keywords;
    private String date;
    private ProgressDialog pd;
    private DatabaseReference db;
    private FirebaseAuth mAuth;
    private static final String TAG = "ERRO";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_found_obj);

        addObj = (Button) findViewById(R.id.addFobj);
        nome = (EditText) findViewById(R.id.etNome);
        desc = (EditText) findViewById(R.id.etDesc);
        location = (EditText) findViewById(R.id.etLocation);
        cat = (Spinner) findViewById(R.id.spinner2);
        keywords = (EditText) findViewById(R.id.etKeywords);

        addObj.setOnClickListener(this);

        DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
        date = df.format(Calendar.getInstance().getTime());

        Categoria categoria = new Categoria();
        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item, categoria.getCat());

        aa.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);
        cat.setAdapter(aa);
    }
    public void onClick(View view){
        if(view.getId() == R.id.addFobj){
            if (!validateForm()) {
                return;
            }
            else{

                pd.setMessage("Publishing.");
                pd.show();

                Log.d(TAG,"ENTROU");
               String key = db.push().getKey();
                objetoEncontrado obj = new objetoEncontrado(nome.getText().toString(),date,location.getText().toString(),cat.getSelectedItem().toString(),desc.getText().toString(),keywords.getText().toString());
                db.child("objFound").child(key).setValue(obj);
                pd.dismiss();

                Intent gh = new Intent(AddFoundObj.this,objRelated.class);
                startActivity(gh);

            }
        }

    }

    private boolean validateForm() {
        boolean valid = true;

        if(TextUtils.isEmpty(nome.getText().toString())){
            nome.setError("Required.");
            valid = false;
        }else {
            nome.setError(null);
        }

        if (TextUtils.isEmpty(desc.getText().toString())) {
            desc.setError("Required.");
            valid = false;
        } else {
            desc.setError(null);
        }
        if (TextUtils.isEmpty(location.getText().toString())) {
            location.setError("Required.");
            valid = false;
        } else {
            location.setError(null);
        }
        if (TextUtils.isEmpty(keywords.getText().toString())) {
            keywords.setError("Required.");
            valid = false;
        } else {
            keywords.setError(null);
        }
        return valid;
    }
}
