package com.gzeinnumer.recyclerviewsearchmultiitem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView rv;
    AdapterRV adapterRV;
    //TODO tambah ini gzeinnumer
    Button button;
    ArrayList<DataItem> listPertama;
    ArrayList<String> spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv=findViewById(R.id.rv_search);
        //TODO tambah ini gzeinnumer
        button=findViewById(R.id.btn);

        listPertama = new ArrayList<>();

        //TODO tambah ini gzeinnumer
        spinner = new ArrayList<>();
        spinner.add("Satu");
        spinner.add("dua");
        spinner.add("tiga");

        for (int i=0; i<20; i++){
            //TODO tambah ini gzeinnumer
            if(i==0){
                //TODO tambah ini gzeinnumer
                spinner = new ArrayList<>();
                spinner.add("0");
                spinner.add("0");
                spinner.add("0");
                spinner.add("0");
            } else if(i==1) {
                //TODO tambah ini gzeinnumer
                spinner = new ArrayList<>();
                spinner.add("10");
                spinner.add("3");
                spinner.add("2");
                spinner.add("4");
                spinner.add("4");
                spinner.add("4");
            }
            //TODO tambah ini gzeinnumer
            listPertama.add(new DataItem(i,"No "+i, "Nama "+i, 0, spinner));
        }

        adapterRV = new AdapterRV(this, listPertama, new AdapterRV.CallBack() {
            //TODO tambah ini gzeinnumer
            @Override
            public void checked(boolean isChecked, int index) {
                listPertama.get(index).setCheck(isChecked);
                listPertama.get(index).setSpinnerIndex(0);
            }
        });
        adapterRV.setList(listPertama);
        rv.setAdapter(adapterRV);
        rv.setLayoutManager(new LinearLayoutManager(this));
        //TODO tambah ini gzeinnumer
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<DataItemV2> res = new ArrayList<>();
                for (int i = 0; i < listPertama.size(); i++) {
                    if(listPertama.get(i).isCheck){
                        res.add(new DataItemV2(listPertama.get(i).realIndex, listPertama.get(i).getStrTv1(),listPertama.get(i).getStrTv2(), listPertama.get(i).realIndex, listPertama.get(i).spinners));
                    }
                }
                for (int i = 0; i < res.size(); i++) {
                    Log.d(TAG, "onClick: "+res.get(i).toString());
                    Log.d(TAG, "data yang dipilih: "+res.get(i).getSpinners().get(res.get(i).idSpinner));
                }
            }
        });
    }

    private static final String TAG = "MainAct_ivity";

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);

        filterFunction(menu);

        return true;
    }

    private void filterFunction(Menu menu) {
        MenuItem searchItem = menu.findItem(R.id.showSearchTitle);
        SearchView searchView = (SearchView) searchItem.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                adapterRV.getFilter().filter(s);
                return false;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.showSearchTitle){

        }
        return super.onOptionsItemSelected(item);
    }


}
