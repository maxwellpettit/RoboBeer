package osu.cse.robobeer.content;

import com.google.firebase.database.IgnoreExtraProperties;

/**
 * Created by Maxwell on 12/2/2016.
 */

@IgnoreExtraProperties
public class MenuItem {
    public String name;
    public String content;
    public double cost;

    public MenuItem() {

    }

    public MenuItem(String name, String content, double cost) {
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

    public String getContent() {
        return content;
    }

    public double getCost() { return cost; }
}