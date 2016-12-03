package osu.cse.robobeer;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import osu.cse.robobeer.content.MenuItem;
import osu.cse.robobeer.ItemFragment.OnMenuListFragmentInteractionListener;


public class MenuActivity extends AppCompatActivity implements OnMenuListFragmentInteractionListener {

    public static Activity mLastActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_menu);

        Toolbar toolbar = (Toolbar) findViewById(R.id.menu_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



    }

    public void onItemListFragmentInteraction(MenuItem item) {
        System.out.println("Item: " + item.getName());
        ItemDetailsActivity.setItem(item);

        startActivity(new Intent(this, ItemDetailsActivity.class));
    }


    public boolean onOptionsItemSelected(android.view.MenuItem item){
        Intent myIntent = new Intent(getApplicationContext(), MainActivity.class);
        startActivityForResult(myIntent, 0);
        return true;

    }
}
