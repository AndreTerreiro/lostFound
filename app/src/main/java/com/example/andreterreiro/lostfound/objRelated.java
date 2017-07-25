package com.example.andreterreiro.lostfound;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class objRelated extends AppCompatActivity implements View.OnClickListener {

    private Button add;
    private ListView list;
    private DatabaseReference ref;
    private int x ;
    private int y;

    private ArrayList<String> oPNum = new ArrayList<>();
    private ArrayList<String> oPKeywords = new ArrayList<>();
    private ArrayList<String> oPLink = new ArrayList<>();
    private ArrayList<String> oPContact = new ArrayList<>();
    private ArrayList<String> oEKeywords = new ArrayList<>();
    private ArrayList<String> userN = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_obj_related);

        list = (ListView) findViewById(R.id.listRelated);
        add = (Button) findViewById(R.id.btnAdd);
        add.setOnClickListener(this);

        CustomAdapter ca = new CustomAdapter();
        list.setAdapter(ca);
        /**
        for(int i = 0; i <= oPKeywords.size();i++ ){
            if(oPKeywords.get(i).equals(oEKeywords.get(i))){
                x = i;
            }
        }
         **/
        for(int j = 0; j <=oPNum.size(); j++)
        {
            if(oPNum.get(j).equals(userN.get(j))){
                y = j ;
            }

        }
        ref.child("objLost").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                String n = dataSnapshot.child("numUser").getValue(String.class);
                String keyw = dataSnapshot.child("keywords").getValue(String.class);
                String img = dataSnapshot.child("img").getValue(String.class);
                oPKeywords.add(keyw);
                oPNum.add(n);
                oPLink.add(img);

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
        ref.child("Users").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                String y = dataSnapshot.child("nUtilizador").getValue(String.class);
                String c = dataSnapshot.child("number").getValue(String.class);
                oPContact.add(c);
                userN.add(y);

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
        ref.child("objFound").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                String keyw = dataSnapshot.child("keywords").getValue(String.class);
                oEKeywords.add(keyw);
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

    public void onClick(View view){
        if(view.getId() == R.id.btnAdd){
            Intent intent = new Intent(this, AddFoundObj.class);
            startActivity(intent);
        }
        else if(view.getId() == R.id.btn){
            call(y);
        }
    }
    class CustomAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            if(oEKeywords.size()>oPKeywords.size()){
                return oEKeywords.size();
            }
            else{
                return oPKeywords.size();
            }

        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = getLayoutInflater().inflate(R.layout.customlayout,null);

            ImageView imageV= (ImageView) convertView.findViewById(R.id.imageView);
            Button btn = (Button) convertView.findViewById(R.id.btn);
            TextView tv = (TextView) convertView.findViewById(R.id.tvName);


            Picasso.with(getApplicationContext()).load(Uri.parse(oPLink.get(x))).into(imageV);
            btn.setOnClickListener(objRelated.this);
            tv.setText(oPNum.get(x));
            return convertView;
        }
    }
    public void call(int j){
        Intent in = new Intent(Intent.ACTION_CALL);
        in.setData(Uri.parse(oPContact.get(j)));
        startActivity(in);
    }

}
