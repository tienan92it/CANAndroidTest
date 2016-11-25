package com.antran.canandroidtest.ui.currencies;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;

import com.antran.canandroidtest.R;
import com.antran.canandroidtest.model.Country;
import com.antran.canandroidtest.ui.currencies.currency.CurrencyItemController;
import com.antran.canandroidtest.ui.currencies.currency.CurrencyItemControllerListener;
import com.antran.canandroidtest.ui.currencies.currency.CurrencyItemView;
import com.antran.canandroidtest.util.Utils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AN TRAN on 26/11/2016.
 */
public class ListOfCurrenciesController extends RecyclerView.Adapter<CurrencyItemController> implements Filterable, ListOfCurrenciesViewListener, CurrencyItemControllerListener {

    private Context context;
    private ListOfCurrenciesView view;
    private ListOfCurrenciesControllerListener listener;
    private List<Country> countries;
    private List<Country> displayedCountries;
    private String currentCurrency = "";

    public ListOfCurrenciesController(Context context, ListOfCurrenciesControllerListener listener, ListOfCurrenciesView view) {
        this.context = context;
        this.listener = listener;
        this.view = view;
        countries = new ArrayList<>();
        displayedCountries = new ArrayList<>();
        loadCountries();
    }


    @Override
    public CurrencyItemController onCreateViewHolder(ViewGroup parent, int viewType) {

        CurrencyItemView currencyItemView = new CurrencyItemView(parent);
        CurrencyItemController currencyItemController = new CurrencyItemController(context, this, currencyItemView);
        currencyItemView.setListener(currencyItemController);

        return currencyItemController;
    }

    @Override
    public void onBindViewHolder(CurrencyItemController holder, int position) {
        if (displayedCountries.get(position).getCurr_cd().compareTo(currentCurrency) == 0)
            holder.bindCurrency(displayedCountries.get(position), true);
        else
            holder.bindCurrency(displayedCountries.get(position), false);
    }

    @Override
    public int getItemCount() {
        return displayedCountries.size();
    }

    private void loadCountries() {
        try {
            JSONArray jsonCountries = new JSONArray(Utils.loadJSONFromAsset(context));

            for (int i = 0; i < jsonCountries.length(); i++) {
                JSONObject jsonCountry = jsonCountries.getJSONObject(i);
                Country country = new Country();
                country.setCtry_cd(jsonCountry.getString(Country.CTRY_CD));
                country.setCtry_kr(jsonCountry.getString(Country.CTRY_KR));
                country.setCtry_en(jsonCountry.getString(Country.CTRY_EN));
                country.setCurr_cd(jsonCountry.getString(Country.CURR_CD));
                country.setCurr_name(jsonCountry.getString(Country.CURR_NAME));
                country.setAp_ican(jsonCountry.getString(Country.AP_ICAN));
                country.setAp_ct_kr(jsonCountry.getString(Country.AP_CT_KR));
                country.setAp_kr(jsonCountry.getString(Country.AP_KR));
                countries.add(country);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        displayedCountries = countries;
    }

    @Override
    public void currencySelected(String curr_cd) {
        currentCurrency = curr_cd;
        for (int i = 0; i < countries.size(); i++) {
            if (countries.get(i).getCurr_cd().compareTo(curr_cd) == 0) {
                listener.currencySelected(countries.get(i));
            }
        }
        notifyDataSetChanged();

    }

    @Override
    public Filter getFilter() {
        Filter filter = new Filter() {

            @SuppressWarnings("unchecked")
            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                displayedCountries = (ArrayList<Country>) results.values;
                notifyDataSetChanged();
            }

            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                FilterResults results = new FilterResults();
                ArrayList<Country> FilteredArrList = new ArrayList<Country>();

                if (countries == null) {
                    countries = new ArrayList<Country>(displayedCountries);
                }

                if (constraint == null || constraint.length() == 0) {
                    results.count = countries.size();
                    results.values = countries;
                } else {
                    constraint = constraint.toString().toLowerCase();
                    for (int i = 0; i < countries.size(); i++) {
                        String data = countries.get(i).getCurr_cd();
                        if (data.toLowerCase().startsWith(constraint.toString())) {
                            FilteredArrList.add(countries.get(i));
                        }
                    }

                    results.count = FilteredArrList.size();
                    results.values = FilteredArrList;
                }
                return results;
            }
        };
        return filter;
    }
}