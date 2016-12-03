package osu.cse.robobeer.content;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import osu.cse.robobeer.content.MenuItem;
/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p/>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class OrderContent {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<MenuItem> ITEMS = new ArrayList<MenuItem>();

    /**
     * A map of sample (dummy) items, by ID.
     */

	private static double mCost = 0.0;

    static {
        //addItem(dummy);
    }

    public static void addItem(MenuItem item) {
        ITEMS.add(item);
        //ITEM_MAP.put(MenuContent.getKey, item);
		
		mCost += item.getCost();
    }

	public static void clearOrder() {
	
		ITEMS.clear();
		mCost = 0.0;
	}

    public static void removeItem(MenuItem item) {
        ITEMS.remove(item);
        mCost -= item.getCost();
    }

    public static double getCost() {
        return mCost;
    }

}
