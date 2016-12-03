package osu.cse.robobeer;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import osu.cse.robobeer.content.MenuContent;
import osu.cse.robobeer.content.MenuItem;

public class MainActivity extends AppCompatActivity implements android.view.View.OnClickListener {

    private DatabaseReference mDatabase;
    public static boolean init = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button menuButton = (Button) findViewById(R.id.menu_button);
        Button orderButton = (Button) findViewById(R.id.order_button);
        Button storeLocationsButton = (Button) findViewById(R.id.store_locations_button);
        Button companyInfoButton = (Button) findViewById(R.id.company_info_button);

        menuButton.setOnClickListener(this);
        orderButton.setOnClickListener(this);
        storeLocationsButton.setOnClickListener(this);
        companyInfoButton.setOnClickListener(this);

        if (!init) {
            FirebaseDatabase.getInstance().setPersistenceEnabled(true);
        }

        mDatabase = FirebaseDatabase.getInstance().getReference().child("MenuItem");

        if (!init) {
            initialize();
            init = true;
        }

    }

    @Override
    public void onClick (View v) {
        switch (v.getId()) {
            case R.id.menu_button:
                startActivity(new Intent(this, MenuActivity.class));
                break;
            case R.id.order_button:
                startActivity(new Intent(this, OrderActivity.class));
                break;
            case R.id.store_locations_button:
                startActivity(new Intent(this, StoreLocationsActivity.class));
                break;
            case R.id.company_info_button:
                startActivity(new Intent(this, CompanyInfoActivity.class));
                break;
        }
    }


    public void initialize() {
        ChildEventListener childEventListener = new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String previousChildName) {
                // A new comment has been added, add it to the displayed list
                MenuItem item = dataSnapshot.getValue(MenuItem.class);
                String itemKey = dataSnapshot.getKey();

                MenuContent.addItem(itemKey,item);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String previousChildName) {

                MenuItem item = dataSnapshot.getValue(MenuItem.class);
                String itemKey = dataSnapshot.getKey();

                MenuContent.addItem(itemKey,item);
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                MenuItem item = dataSnapshot.getValue(MenuItem.class);
                String itemKey = dataSnapshot.getKey();

                MenuContent.removeItem(itemKey,item);
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String previousChildName) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        };
        mDatabase.addChildEventListener(childEventListener);
    }
}
