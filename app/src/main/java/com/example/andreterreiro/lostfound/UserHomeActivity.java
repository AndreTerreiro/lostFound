package com.example.andreterreiro.lostfound;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

//import android.support.v7.widget.LinearLayoutManager;
//import android.support.v7.widget.RecyclerView;
//import com.firebase.ui.database.FirebaseRecyclerAdapter;
//import com.squareup.picasso.Picasso;

public class UserHomeActivity extends AppCompatActivity implements View.OnClickListener {

    private Button add;
    private String nU;
    private String mail;
    private static final String TAG = "ERRO";

    //private ArrayList<Uri> objImg = new ArrayList<>();
    private ArrayList<String> objName = new ArrayList<>();
    //private ArrayList<String> objDate = new ArrayList<>();
    private String img;
    private String name;
    private String date;
    //private RecyclerView objList;
    private DatabaseReference ref;
    private FirebaseAuth u;
    private ListView list;
    private ArrayAdapter<String> aa;
    private Button adm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_home);
        /**
        objList = (RecyclerView) findViewById(R.id.list);
        objList.setHasFixedSize(true);
        objList.setLayoutManager(new LinearLayoutManager(this));
         **/
        add = (Button) findViewById(R.id.addObject);
        list = (ListView) findViewById(R.id.listView);
        adm = (Button) findViewById(R.id.btnAdm);
        add.setOnClickListener(this);
        adm.setOnClickListener(this);
        u = FirebaseAuth.getInstance();

        if(u.getCurrentUser().getEmail().equals("admin@admin.pt")){
            add.setVisibility(View.GONE);
            adm.setVisibility(View.VISIBLE);
        }else{
            add.setVisibility(View.VISIBLE);
            adm.setVisibility(View.GONE);
        }

        ref = FirebaseDatabase.getInstance().getReference().child("objLost");
        aa = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,objName);
        list.setAdapter(aa);
        //textViewPersons = (TextView) findViewById(R.id.textViewPersons);

        ref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                String name = dataSnapshot.child("nome").getValue(String.class);

                objName.add(name);
                aa.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_logout) {
            logout();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void logout() {
        FirebaseAuth.getInstance().signOut();
        Intent intent = new Intent(this, StartActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }

    /**

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseRecyclerAdapter<objetoPerdido,objViewHolder> firebaseRecyclerAdapter =
                new FirebaseRecyclerAdapter<~>(
                        R.layout.design_row,
                        objViewHolder.class,
                        ref){

                            protected void populateViewHolder(objViewHolder viewHolder){
                                viewHolder.setName(name);
                                viewHolder.setImage(getApplicationContext(),img);
                                viewHolder.setDate(date);

                            }
                    };
        objList.setAdapter(firebaseRecyclerAdapter);
    }
    **/

    public void onClick(View v){
        if(v.getId() == R.id.addObject){
            Intent intent = new Intent(this, AddLostObject.class);
            startActivity(intent);
        }
        else if (v.getId() == R.id.btnAdm){
            Intent intent = new Intent(this, objRelated.class);
            startActivity(intent);
        }
    }
    /**
    public static class objViewHolder extends RecyclerView.ViewHolder{
        View v;
        public objViewHolder(View view){
            super(view);
            v = view;
        }
        public void setName(String name){
            TextView n = (TextView) v.findViewById(R.id.tvNome);
            n.setText(name);
        }
        public void setImage(Context ctx, String image){
            ImageView iv = (ImageView)v.findViewById(R.id.thumbnail);
            Picasso.with(ctx).load(image).into(iv);
        }
         public void setDate(String date){
             TextView d = (TextView) v.findViewById(R.id.tvData);
             d.setText(date);
         }
    }
     **/
}
