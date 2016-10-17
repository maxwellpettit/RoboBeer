package osu.cse.robobeer.content;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import osu.cse.robobeer.content.MenuContent.MenuItem;
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
    public static final List<MenuItem> ITEMS = new ArrayList<MenuContent.MenuItem>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, MenuItem> ITEM_MAP = new HashMap<String, MenuContent.MenuItem>();

	private static double mCost = 0.0;
	
    static {
        MenuItem dummy = new MenuItem("1", "Dummy", "Nothing", "0.00");
        //addItem(dummy);
    }

    public static void addItem(MenuItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.getId(), item);
		
		mCost += Double.parseDouble(item.getCost());
    }

	public static void clearOrder() {
	
		ITEMS.clear();
		ITEM_MAP.clear();
		mCost = 0.0;
	}

    public static double getCost() {
        return mCost;
    }

}
