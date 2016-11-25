package com.antran.canandroidtest.ui.currencies.currency;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;

import com.antran.canandroidtest.model.Country;
import com.antran.canandroidtest.util.Utils;

import java.io.IOException;
import java.io.InputStream;

/**
 * TODO: document your controller class.
 */
public class CurrencyItemController extends RecyclerView.ViewHolder implements CurrencyItemViewListener {

    private Context context;
    private CurrencyItemView view;
    private CurrencyItemControllerListener listener;
    private Country country;

    public CurrencyItemController(Context context, CurrencyItemControllerListener listener, CurrencyItemView view) {
        super(view.getView());
        this.context = context;
        this.listener = listener;
        this.view = view;
        country = new Country();
    }


    public void bindCurrency(Country country, boolean isSelected) {
        this.country = country;
        String flagPath = "flag/" + country.getCtry_cd().toLowerCase() + ".png";
        view.setCountryFlag(Utils.loadFlagFromAssets(context, flagPath));
        view.setCurrencyShortName(country.getCurr_cd());
        view.setCurrencyFullName(country.getCurr_name());
        if (isSelected) {
            view.showBlueDot();
        } else {
            view.hideBlueDot();
        }
    }

    @Override
    public void onCurrencySelected() {
        listener.currencySelected(country.getCurr_cd());
    }
}