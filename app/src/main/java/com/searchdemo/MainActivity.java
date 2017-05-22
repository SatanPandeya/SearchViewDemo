package com.searchdemo;

import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.recyclerViewId)
    RecyclerView recyclerView;

    private UserAdapter userAdapter;
    private ArrayList<User> userArrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        userArrayList = new ArrayList<>();
        userArrayList.add(new User("Satan", "Pandeya"));
        userArrayList.add(new User("Suman", "Humagain"));
        userArrayList.add(new User("Ishan", "Manandhar"));
        userArrayList.add(new User("Ritish", "Karki"));
        userArrayList.add(new User("Bansaj", "Pradhan"));
        userArrayList.add(new User("Nirajan", "Panthhi"));
        userArrayList.add(new User("Krishna", "Chaudhary"));
        userArrayList.add(new User("Saugat", "Bhattarai"));
        userArrayList.add(new User("Pradip", "Silwal"));
        userArrayList.add(new User("Saran", "Gurung"));
        userArrayList.add(new User("Suman", "Shrestha"));
        userArrayList.add(new User("Manjil", "Rajbhandhari"));
        userArrayList.add(new User("Pratish", "Shrestha"));
        userArrayList.add(new User("Nischal", "Aryal"));
        userArrayList.add(new User("Dipesh", "Bhattarai"));
        userArrayList.add(new User("Bijay", "Basnet"));
        userArrayList.add(new User("Hilson", "Shrestha"));
        userArrayList.add(new User("Rohit", "Shrestha"));
        userArrayList.add(new User("Aatish", "Neupane"));
        userArrayList.add(new User("Dipu", "Dongal"));
        userArrayList.add(new User("Manish", "Gautam"));
        userArrayList.add(new User("Ritesh", "Pundasaini"));
        userArrayList.add(new User("Divesh", "Paudel"));
        userArrayList.add(new User("Ritesh", "Thapa"));
        userArrayList.add(new User("Aaabirbhav", "Pokheral"));
        userArrayList.add(new User("Ramesh", "Tiwari"));
        userArrayList.add(new User("Rabindra", "Lamsal"));
        userArrayList.add(new User("Sunil", "Parajuli"));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        userAdapter = new UserAdapter(this, userArrayList);
        recyclerView.setAdapter(userAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_search, menu);
        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        searchView.setOnQueryTextFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {

            }
        });

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                userAdapter.filter(newText.trim());
                recyclerView.invalidate();
                return true;
            }
        });
        MenuItemCompat.setOnActionExpandListener(searchItem, new MenuItemCompat.OnActionExpandListener() {
            @Override
            public boolean onMenuItemActionExpand(MenuItem item) {
                return true;
            }

            @Override
            public boolean onMenuItemActionCollapse(MenuItem item) {
                return true;
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_search){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
