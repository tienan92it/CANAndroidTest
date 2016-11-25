package com.antran.canandroidtest;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.antran.canandroidtest.model.Country;
import com.antran.canandroidtest.ui.currencies.ListOfCurrenciesController;
import com.antran.canandroidtest.ui.currencies.ListOfCurrenciesControllerListener;
import com.antran.canandroidtest.ui.currencies.ListOfCurrenciesView;
import com.antran.canandroidtest.ui.widget.SearchBar;
import com.antran.canandroidtest.util.Utils;

public class MainActivity extends AppCompatActivity implements ListOfCurrenciesControllerListener {

    //Control properties
    private RelativeLayout mainContent;
    private Toolbar toolbar;
    private SearchBar searchBar;

    //List controller
    private ListOfCurrenciesController listOfCurrenciesController;

    //Current currency properties
    private RelativeLayout currencyContent;
    private ImageView countryFlag;
    private TextView currencyShortName;
    private TextView currencyFullname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //init control properties
        mainContent = (RelativeLayout) findViewById(R.id.activity_main);
        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        searchBar = (SearchBar) findViewById(R.id.search_bar);

        mainContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                searchBar.stopSearch();
            }
        });

        setupListOfCurrencies();

        //init current currency properties
        currencyContent = (RelativeLayout) findViewById(R.id.cur_currency_content);
        countryFlag = (ImageView) findViewById(R.id.country_flag);
        currencyShortName = (TextView) findViewById(R.id.currency_shortname);
        currencyFullname = (TextView) findViewById(R.id.currency_fullname);
    }

    private void setupListOfCurrencies() {
        ListOfCurrenciesView listOfCurrenciesView = new ListOfCurrenciesView((RecyclerView) findViewById(R.id.currency_list));
        listOfCurrenciesController = new ListOfCurrenciesController(this, this, listOfCurrenciesView);
        listOfCurrenciesView.setAdapter(listOfCurrenciesController);
        listOfCurrenciesView.setListener(listOfCurrenciesController);

        searchBar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                listOfCurrenciesController.getFilter().filter(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    @Override
    public void currencySelected(Country country) {

        if (searchBar.isSearching()) {
            searchBar.stopSearch();
        }
        currencyContent.setVisibility(View.VISIBLE);
        String flagPath = "flag/" + country.getCtry_cd().toLowerCase() + ".png";
        countryFlag.setImageBitmap(Utils.loadFlagFromAssets(this, flagPath));
        currencyShortName.setText(country.getCurr_cd());
        currencyFullname.setText(country.getCurr_name());
    }
}
