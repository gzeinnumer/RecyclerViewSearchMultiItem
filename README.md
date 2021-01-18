# RecyclerViewSearchMultiItem

- MainActivity
```java
public class MainActivity extends AppCompatActivity {

    RecyclerView rv;
    AdapterRV adapterRV;
    ArrayList<DataItem> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv=findViewById(R.id.rv_search);

        list = new ArrayList<>();

        for (int i=0; i<20; i++){
            list.add(new DataItem("No "+i, "Nama "+i));
        }

        adapterRV = new AdapterRV(this, list);
        rv.setAdapter(adapterRV);
        rv.setLayoutManager(new LinearLayoutManager(this));

    }

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

}
```

- Menu
```xml
<?xml version="1.0" encoding="utf-8"?>
<menu xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto">
    <item
        android:title="Title"
        app:showAsAction="ifRoom"
        android:id="@+id/showSearchTitle"
        android:icon="@drawable/ic_search_black_24dp"
        app:actionViewClass="android.support.v7.widget.SearchView"/>

</menu>
```

- Adapter
```java
public class AdapterRV extends RecyclerView.Adapter<AdapterRV.MyHolder> implements Filterable {

    private Context context;
    private ArrayList<DataItem> list;
    private ArrayList<DataItem> listFilter;

    public AdapterRV(Context context, ArrayList<DataItem> list) {
        this.context = context;
        this.list = list;
        this.listFilter = new ArrayList<>(list);
    }

    ...

    public void setList(ArrayList<DataItem> list) {
        this.list = list;
        this.listFilter = new ArrayList<>(list);
        notifyDataSetChanged();
    }

    ...

    @Override
    public Filter getFilter() {
        return exampleFilter;
    }


    private Filter exampleFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<DataItem> fildteredList = new ArrayList<>();
            if(constraint == null || constraint.length() == 0){
                Collections.sort(listFilter, new Comparator<DataItem>() {
                    @Override
                    public int compare(DataItem o1, DataItem o2) {
                        return o1.getStrTv2().toLowerCase().compareTo(o2.getStrTv2().toLowerCase());
                    }
                });
                fildteredList.addAll(listFilter);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();

                for (DataItem item : listFilter){
                    if( item.getStrTv2().toLowerCase().contains(filterPattern)){
                        fildteredList.add(item);
                    }
                }
            }
            FilterResults results = new FilterResults();
            results.values = fildteredList;
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            list.clear();
            list.addAll((List)results.values);
            notifyDataSetChanged();
        }
    };
}
```
---

```
Copyright 2020 M. Fadli Zein
```
