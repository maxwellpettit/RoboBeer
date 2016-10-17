package osu.cse.robobeer;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import osu.cse.robobeer.content.MenuContent.MenuItem;
import osu.cse.robobeer.content.OrderContent;

public class ItemDetailsActivity extends AppCompatActivity {

    private static MenuItem mItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TextView nameText = (TextView) findViewById(R.id.item_details_name);
        TextView descriptionText = (TextView) findViewById(R.id.item_details_description);
        TextView costText = (TextView) findViewById(R.id.item_details_cost);

        nameText.setText(mItem.getName());
        descriptionText.setText(mItem.getContent());
        costText.setText("$" + mItem.getCost());


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.add_to_order_fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OrderContent.addItem(mItem);
                startActivity(new Intent(getApplicationContext(), MenuActivity.class));
            }
        });
    }

    public static void setItem (MenuItem item) {
        mItem = item;
    }

}
