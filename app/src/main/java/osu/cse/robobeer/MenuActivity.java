package osu.cse.robobeer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import osu.cse.robobeer.content.MenuContent.MenuItem;


public class MenuActivity extends AppCompatActivity implements ItemFragment.OnItemListFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void onListFragmentInteraction(MenuItem item) {
        System.out.println("Item: " + item.getName());
        ItemDetailsActivity.setItem(item);

        startActivity(new Intent(this, ItemDetailsActivity.class));
    }
}
