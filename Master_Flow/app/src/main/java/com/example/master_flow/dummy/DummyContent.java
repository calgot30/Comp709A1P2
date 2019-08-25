package com.example.master_flow.dummy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Creates the dummy content that is placed within the list on the main_activity screen

 */
public class DummyContent {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<DummyItem> ITEMS = new ArrayList<DummyItem>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, DummyItem> ITEM_MAP = new HashMap<String, DummyItem>();

    //3 items for the list
    static {
        // Add some sample items.
        addItem((new DummyItem("1","Android","https://developer.android.com/")));
        addItem((new DummyItem("2", "Developer Guides", "https://developer.android.com/guide" )));
        addItem((new DummyItem("3", "Sample Code", "https://developer.android.com/samples")));
    }

    //method to add the items into the array, takes DummyItem object as argument
    private static void addItem(DummyItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    private static DummyItem createDummyItem(int position) {
        return new DummyItem(String.valueOf(position), "Item " + position, makeDetails(position));
    }

    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Item: ").append(position);
        for (int i = 0; i < position; i++) {
            builder.append("\nMore details information here.");
        }
        return builder.toString();
    }


    //dummy item class, creates dummyItem objects for the list
    public static class DummyItem {
        public final String id;
        public final String item_name;
        public final String url;


        /**
         * dummy item constructor, has the values needed for the object to add
         * to the list
         */
        public DummyItem(String id, String item_name, String url) {
            this.id = id;
            this.item_name = item_name;
            this.url = url;
        }

        @Override
        public String toString() {
            return item_name;
        }
    }
}
