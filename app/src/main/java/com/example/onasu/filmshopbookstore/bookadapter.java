package com.example.onasu.filmshopbookstore;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

/**
 * Created by onasu on 6/26/2016.
 */
public class bookadapter {

    public class Bookadpter extends BaseAdapter{

        private Context context;
        private String[] nameStrings, priceStrings , coverStrings;

        public Bookadpter(Context context, String[] nameStrings, String[] priceStrings, String[] coverStrings) {
            this.context = context;
            this.nameStrings = nameStrings;
            this.priceStrings = priceStrings;
            this.coverStrings = coverStrings;
        }

        @Override
        public int getCount() {
            return nameStrings.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            return null;
        }
    }

}
