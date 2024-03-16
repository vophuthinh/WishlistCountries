package com.example.wishlistcountries;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Country> countryList;
    private CountryListAdapter countryAdapter;
    private ArrayList<String> selectedCountry;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        countryList = new ArrayList<>();
        countryList.add(new Country("Athens", "Greece", R.drawable.greece));
        countryList.add(new Country("Dubai", "Emirate of Dubai", R.drawable.emirates));
        countryList.add(new Country("Amsterdam", "Netherlands", R.drawable.netherlands));
        countryList.add(new Country("London", "England", R.drawable.england));
        countryList.add(new Country("Tokyo", "Japan", R.drawable.japan));
        countryList.add(new Country("Giza", "Egypt", R.drawable.egypt));
        countryList.add(new Country("Paris", "France", R.drawable.france));
        countryList.add(new Country("Hanoi", "Vietnam", R.drawable.vn));
        countryList.add(new Country("Rome", "Italy", R.drawable.italy));
        countryList.add(new Country("Kuala Lumpur", "Malaysia", R.drawable.malaysia));
        countryList.add(new Country("Berlin", "Germany", R.drawable.germany));
        countryList.add(new Country("Seoul", "Korea", R.drawable.korea));
        countryList.add(new Country("Beijing", "China", R.drawable.china));
        countryList.add(new Country("Wellington", "New Zealand", R.drawable.newzealand));
        countryList.add(new Country("Doha", "Qatar", R.drawable.qatar));
        selectedCountry = new ArrayList<>();

        ListView listViewCountry = findViewById(R.id.listViewCountry);
        Button showSelectedButton = findViewById(R.id.btnViewSelect);

        countryAdapter = new CountryListAdapter(this, countryList);
        listViewCountry.setAdapter(countryAdapter);

        listViewCountry.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                Country country = countryList.get(i);
                country.setSelected(!country.isSelected());
                countryAdapter.notifyDataSetChanged();
            }
        });

        showSelectedButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                showSelectedCountryDialog();
            }
        });
    }
    private void showSelectedCountryDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Your Wishlist");

        StringBuilder selectedCountryText = new StringBuilder();
        for (Country country : countryList) {
            if (country.isSelected()) {
                selectedCountryText.append(country.getName()).append("\n");
                selectedCountry.add(country.getName());
            }
        }

        builder.setMessage(selectedCountryText.toString());
        builder.setPositiveButton("CLOSE", null);
        builder.show();
    }
}
