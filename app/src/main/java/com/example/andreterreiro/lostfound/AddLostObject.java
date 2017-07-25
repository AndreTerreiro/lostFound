package com.example.andreterreiro.lostfound;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;

import com.example.andreterreiro.lostfound.models.Categoria;
import com.example.andreterreiro.lostfound.models.objetoPerdido;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class AddLostObject extends AppCompatActivity implements View.OnClickListener  {

    private Button addObg;
    private EditText desc ;
    private EditText location;
    private EditText nome;
    private EditText keywords;
    private ImageButton img;
    private Spinner cat;
    private StorageReference mStorage;
    private String date;
    private Uri uri;
    private StorageReference filePath;
    private int nUser;
    private Uri dl;
    private DatabaseReference db;
    private int n;
    private ProgressDialog pd;
    private String key;
    private String status;
    private static final String TAG = "ERRO";
    private FirebaseAuth mAuth;

    private static final int REQUEST_IMAGE_GET = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_lost_object);

        db = FirebaseDatabase.getInstance().getReference();
        key = db.push().getKey();
        addObg = (Button) findViewById(R.id.btnAddObjLost);
        desc = (EditText) findViewById(R.id.oLdesc);
        location = (EditText) findViewById(R.id.oLlocation);
        nome = (EditText) findViewById(R.id.oLnome);
        keywords = (EditText) findViewById(R.id.oLkeywords);
        cat = (Spinner) findViewById(R.id.spinner);
        img = (ImageButton) findViewById(R.id.imageButton);

        DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
        date = df.format(Calendar.getInstance().getTime());

        img.setOnClickListener(this);
        addObg.setOnClickListener(this);

        mAuth = FirebaseAuth.getInstance();

        pd = new ProgressDialog(this);
        mStorage = FirebaseStorage.getInstance().getReference();

        Categoria categoria = new Categoria();
        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item, categoria.getCat());

        aa.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);
        cat.setAdapter(aa);

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

    public void onClick(View v){
        if(v.getId() == R.id.imageButton){
            Intent intent = new Intent(Intent.ACTION_PICK);
            intent.setType("image/*");
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivityForResult(intent, REQUEST_IMAGE_GET);
            }
        }
        else if(v.getId() == R.id.btnAddObjLost){
            if (!validateForm()) {
                return;
            }
            else{
                status = "1";
                pd.setMessage("Publishing your lost Object");
                pd.show();

                String m = mAuth.getCurrentUser().getEmail().toString();
                String[]c = m.split("@");
                n = Integer.parseInt(c[0]);

                Log.d(TAG, Integer.toString(nUser));

                objetoPerdido obj = new objetoPerdido(n,date,nome.getText().toString(),cat.getSelectedItem().toString(),desc.getText().toString(),keywords.getText().toString(),location.getText().toString(),dl.toString());
                db.child("objLost").child(key).setValue(obj);
                pd.dismiss();

                Intent gh = new Intent(AddLostObject.this,UserHomeActivity.class);
                startActivity(gh);

            }
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQUEST_IMAGE_GET && resultCode == RESULT_OK){
            uri = data.getData();

            filePath = mStorage.child("Images").child(key);

        }
        filePath.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    @SuppressWarnings("VisibleForTests") Uri downloadUri = taskSnapshot.getDownloadUrl();
                    dl = downloadUri;
                }
        });
    }
}
