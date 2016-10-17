package osu.cse.robobeer;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements android.view.View.OnClickListener {

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
                //startActivity(new Intent(this, ChatRoomSelect.class));
                break;
        }
    }


}
