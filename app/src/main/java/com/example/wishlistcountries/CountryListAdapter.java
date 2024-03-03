package com.example.wishlistcountries;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CountryListAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Country> countryList;
    private boolean[] checkedItems;
    public CountryListAdapter(Context context, ArrayList<Country> countryList) {
        this.context = context;
        this.countryList = countryList;
        this.checkedItems = new boolean[countryList.size()];
    }

    @Override
    public int getCount() {
        return countryList.size();
    }

    @Override
    public Object getItem(int i) {
        return countryList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup parent) {
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.custom_list_layout, parent, false);
        }
        Country capital = (Country) getItem(i);

        ImageView flagImageView = view.findViewById(R.id.image);
        TextView capitalNameTextView = view.findViewById(R.id.capitalName);
        TextView countryTextView = view.findViewById(R.id.country);
        CheckBox cityCheckBox = view.findViewById(R.id.checkBox);

        flagImageView.setImageResource(capital.getImageResId());
        capitalNameTextView.setText(capital.getName());
        countryTextView.setText(capital.getCountry());
        cityCheckBox.setChecked(capital.isSelected());
        cityCheckBox.setTag(i);

        cityCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = (int) v.getTag();
                countryList.get(pos).setSelected(((CheckBox) v).isChecked());
            }
        });

        return view;
    }
}

