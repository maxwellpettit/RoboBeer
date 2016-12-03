package osu.cse.robobeer.content;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.IgnoreExtraProperties;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p/>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class MenuContent {

    public static DatabaseReference mDatabase;
    /**
     * An array of sample (dummy) items.
     */
    public static final List<MenuItem> ITEMS = new ArrayList<MenuItem>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, MenuItem> ITEM_MAP = new HashMap<String, MenuItem>();

    public static void addItem(String key, MenuItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(key,item);
    }

    public static void removeItem(String key, MenuItem item) {
        ITEMS.remove(item);
        ITEM_MAP.remove(key);
    }

    /**
     * A dummy item representing a piece of content.
     */

}
