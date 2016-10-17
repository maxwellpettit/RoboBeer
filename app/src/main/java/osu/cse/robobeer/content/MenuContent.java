package osu.cse.robobeer.content;

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

    /**
     * An array of sample (dummy) items.
     */
    public static final List<MenuItem> ITEMS = new ArrayList<MenuItem>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, MenuItem> ITEM_MAP = new HashMap<String, MenuItem>();

    static {

        MenuItem item1 = new MenuItem("1", "RoboBeer", "Classic RoboBeer Micro Brew", "4.00");
        MenuItem item2 = new MenuItem("2", "RoboBeer Lite", "Low Calorie RoboBeer Micro Brew", "4.00");
        MenuItem item3 = new MenuItem("3", "RIPA", "RoboBeer's IPA Micro Brew", "6.00");
        MenuItem item4 = new MenuItem("4", "Artificial Int-ALE-ignece", "RoboBeer's Premium Ale", "5.00");
        MenuItem item5 = new MenuItem("5", "Citric Circuit", "RoboBeer's Original Citrus Brew", "6.00");
        MenuItem item6 = new MenuItem("6", "Nuts and Bolts", "RoboBeer's Signature Trail Mix", "3.00");

        addItem(item1);
        addItem(item2);
        addItem(item3);
        addItem(item4);
        addItem(item5);
        addItem(item6);
    }

    private static void addItem(MenuItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class MenuItem {
        private final String id;
        private final String name;
        private final String content;
        private final String cost;

        public MenuItem(String id, String name, String content, String cost) {
            this.id = id;
            this.name = name;
            this.content = content;
            this.cost = cost;
        }

        @Override
        public String toString() {
            return content;
        }

        public String getName() {
            return name;
        }

        public String getId() {
            return id;
        }

        public String getContent() {
            return content;
        }

        public String getCost() { return cost; }
    }
}
