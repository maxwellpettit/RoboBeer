package osu.cse.robobeer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.DecimalFormat;

import osu.cse.robobeer.content.MenuItem;
import osu.cse.robobeer.OrderItemFragment.OnOrderListFragmentInteractionListener;
import osu.cse.robobeer.content.OrderContent;

public class OrderActivity extends AppCompatActivity implements OnOrderListFragmentInteractionListener {

    public static Activity mLastActivity;
    private static DecimalFormat df2 = new DecimalFormat("0.00");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        Toolbar toolbar = (Toolbar) findViewById(R.id.order_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TextView totalText = (TextView) findViewById(R.id.total_cost);
        totalText.setText(String.format("$" + df2.format(OrderContent.getCost())));

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.submit_order_fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Order Sent.", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                OrderContent.clearOrder();


                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        Intent myIntent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivityForResult(myIntent, 0);
                    }
                }, 2000);

            }
        });
    }

    public boolean onOptionsItemSelected(android.view.MenuItem item){
        Intent myIntent = new Intent(getApplicationContext(), MainActivity.class);
        startActivityForResult(myIntent, 0);
        return true;

    }

    public void onOrderListFragmentInteraction(MenuItem item) {
        System.out.println("Item: " + item.getName());
    }
}
