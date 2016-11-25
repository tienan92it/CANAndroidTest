package com.antran.canandroidtest.ui.currencies;

import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

/**
 * TODO: document your view class.
 */
public class ListOfCurrenciesView {

    private RecyclerView recyclerView;
    private ListOfCurrenciesViewListener listener;

    public ListOfCurrenciesView(RecyclerView recyclerView) {
        this.recyclerView = recyclerView;
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(recyclerView.getContext());
        recyclerView.setLayoutManager(layoutManager);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                LinearLayout.HORIZONTAL);
        recyclerView.addItemDecoration(dividerItemDecoration);
    }

    public void setAdapter(RecyclerView.Adapter adapter) {
        recyclerView.setAdapter(adapter);
    }

    public void setListener(ListOfCurrenciesViewListener listener) {
        this.listener = listener;
    }

}