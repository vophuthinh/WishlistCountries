package com.example.wishlistcountries;

public class Country {
    private String capital;
    private String country;
    private int imageResId;
    private boolean isSelected;
    public Country(String capital, String country, int imageResId) {
        this.capital = capital;
        this.country = country;
        this.imageResId = imageResId;
        this.isSelected = false;
    }
    public String getName() {
        return capital;
    }

    public String getCountry() {
        return country;
    }

    public int getImageResId() {
        return imageResId;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}
