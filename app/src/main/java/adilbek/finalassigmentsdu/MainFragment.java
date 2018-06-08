package adilbek.finalassigmentsdu;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;


public class MainFragment extends Fragment {

    ListView listView;
    ImageView sduImageView;
    DataBase dataBase;
    LandSpaceFragmentMaster landSpaceFragmentMaster;

    private final String ICON = "ICON";
    private final String TITLE = "TITLE";
    private final String BACKGROUND = "BACKGROUND";

    public MainFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.main_fragment, null);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ScrollView scrollView = (ScrollView) getActivity().findViewById(R.id.scrollView);
        scrollView.smoothScrollTo(0,0);



        landSpaceFragmentMaster = new LandSpaceFragmentMaster();

        listView = (ListView) getActivity().findViewById(R.id.items_list_view);
        sduImageView = (ImageView) getActivity().findViewById(R.id.sdu_background);

        dataBase = new DataBase();

        sduImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT)
                {
                    Intent intent = new Intent(getContext(), VerstFacultyAndSduInfo.class);
                    dataBase.index = 4;
                    startActivity(intent);
                } else if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE)
                {
                    Fragment newFragment = new FacultyAndSduInfo();
                    final FragmentTransaction ft1 = getFragmentManager().beginTransaction();
                    ft1.replace(R.id.fragmentConteinerOne, newFragment);
                    ft1.commit();
                    dataBase.index = 4;
                }
            }
        });

        SimpleAdapter simpleAdapter = getAdapter();

        listView.setAdapter(simpleAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT)
                {
                    if(i==4) {
                        Intent intent = new Intent(getContext(), VerstNewListFragment.class);
                        startActivity(intent);
                    } else if(i==5) {
                        Intent intent = new Intent(getContext(), VerstContactFragment.class);
                        startActivity(intent);
                    } else {
                        Intent intent = new Intent(getContext(), VerstFacultyAndSduInfo.class);
                        dataBase.index = i;
                        startActivity(intent);
                    }
                } else if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE)
                {
                    Log.d("!!!!!!!!!!!!!",i+"...........");
                    if(i==4) {
                        Fragment newFragment = new NewsListFragment();
                        final FragmentTransaction ft1 = getFragmentManager().beginTransaction();
                        ft1.replace(R.id.fragmentConteinerOne, newFragment);
                        ft1.commit();
                    } else if(i==5) {
                        Fragment newFragment = new ContactsFragment();
                        final FragmentTransaction ft1 = getFragmentManager().beginTransaction();
                        ft1.replace(R.id.fragmentConteinerOne, newFragment);
                        ft1.commit();
                    } else {
                        Fragment newFragment = new FacultyAndSduInfo();
                        final FragmentTransaction ft1 = getFragmentManager().beginTransaction();
                        if(!dataBase.done) {
                            ft1.replace(dataBase.id, getFragmentManager().findFragmentById(R.id.fragmentConteinerOne));
                            dataBase.done = false;
                        }
                        ft1.replace(R.id.fragmentConteinerOne, newFragment);
                        ft1.addToBackStack(null);
                        ft1.commit();
                        dataBase.index = i;
                        dataBase.id = newFragment.getId();
                    }

                }
            }
        });

        listView.setClickable(false);
    }

    public SimpleAdapter getAdapter() {

        ArrayList<HashMap<String, Object>> itemsList = new ArrayList<>();

        HashMap<String, Object> hm = new HashMap<>();

        hm.put(BACKGROUND, R.drawable.eng_faculty_background_image);
        hm.put(ICON, R.drawable.eng_faculty_icon);
        hm.put(TITLE, "ENGINEERING");
        itemsList.add(hm);

        hm = new HashMap<>();
        hm.put(BACKGROUND, R.drawable.eco_faculty_background_image);
        hm.put(ICON, R.drawable.eco_faculty_icon);
        hm.put(TITLE, "ECONOMICS");
        itemsList.add(hm);



        hm = new HashMap<>();
        hm.put(BACKGROUND, R.drawable.phil_faculty_background_image);
        hm.put(ICON, R.drawable.phil_faculty_icon);
        hm.put(TITLE, "PHILOLOGY");
        itemsList.add(hm);

        hm = new HashMap<>();

        hm.put(BACKGROUND, R.drawable.law_faculty_background_image);
        hm.put(ICON, R.drawable.law_faculty_icon);
        hm.put(TITLE, "LAW");
        itemsList.add(hm);

        hm = new HashMap<>();

        hm.put(BACKGROUND, R.drawable.news_item_background_image);
        hm.put(ICON, R.drawable.news_item_icon);
        hm.put(TITLE, "NEWS");
        itemsList.add(hm);

        hm = new HashMap<>();

        hm.put(BACKGROUND, R.drawable.contcats_item_background_image);
        hm.put(ICON, R.drawable.contacts_item_icon);
        hm.put(TITLE, "CONTACT US");
        itemsList.add(hm);

        return new SimpleAdapter(getContext(), itemsList, R.layout.list_view_items_constructor, new String[]{BACKGROUND, ICON, TITLE},
                new int[]{R.id.item_background_image, R.id.item_icon, R.id.item_title});
    }
}
