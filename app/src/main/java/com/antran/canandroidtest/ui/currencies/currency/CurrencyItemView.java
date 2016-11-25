package com.antran.canandroidtest.ui.currencies.currency;

import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.antran.canandroidtest.R;

/**
 * TODO: document your view class.
 */
public class CurrencyItemView {

    private View rootView;

    private ImageView countryFlag;
    private TextView currencyShortName;
    private TextView currencyFullName;
    private ImageView blueDot;

    public CurrencyItemView(ViewGroup parent) {
        this.rootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_currency, parent, false);

        countryFlag = (ImageView) rootView.findViewById(R.id.country_flag);
        currencyShortName = (TextView) rootView.findViewById(R.id.currency_shortname);
        currencyFullName = (TextView) rootView.findViewById(R.id.currency_fullname);
        blueDot = (ImageView) rootView.findViewById(R.id.blue_dot);
    }

    public void setListener(final CurrencyItemViewListener listener) {
        rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onCurrencySelected();
            }
        });
    }

    public View getView() {
        return rootView;
    }

    public void setCountryFlag(Bitmap countryFlag) {
        this.countryFlag.setImageBitmap(countryFlag);
    }

    public void setCurrencyShortName(String shortName) {
        currencyShortName.setText(shortName);
    }

    public void setCurrencyFullName(String fullName) {
        currencyFullName.setText(fullName);
    }

    public void showBlueDot() {
        blueDot.setVisibility(View.VISIBLE);
    }

    public void hideBlueDot() {
        blueDot.setVisibility(View.GONE);
    }
}