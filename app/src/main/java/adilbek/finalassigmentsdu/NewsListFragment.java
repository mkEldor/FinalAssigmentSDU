package adilbek.finalassigmentsdu;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;


public class NewsListFragment extends Fragment {

    ListView listView;
    DataBase dataBase;

    private final String ICON = "NICON";
    private final String DATE = "NDATE";
    private final String TEXT = "NTEXT";


    public NewsListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.news_list_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        listView = (ListView) getActivity().findViewById(R.id.newslistview);
        dataBase = new DataBase();
        ArrayList<HashMap<String, Object>> list = new ArrayList<>();

        HashMap<String, Object> hm = new HashMap<>();

        hm.put(ICON, R.drawable.news_1);
        hm.put(DATE, "12.43.12");
        hm.put(TEXT, "Success story of Bagdat Musin");
        list.add(hm);

        hm = new HashMap<>();
        hm.put(ICON, R.drawable.news_3);
        hm.put(DATE, "12.45.12");
        hm.put(TEXT, "Orientation Days 2017");
        list.add(hm);


        SimpleAdapter simpleAdapter = new SimpleAdapter(getContext(), list, R.layout.news_list_view_layout, new String[]{ICON, DATE, TEXT},
                new int[] {R.id.newsitemicon, R.id.newsitemdate, R.id.newsitemtext});

        listView.setAdapter(simpleAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT)
                {
                    Intent intent = new Intent(getContext(), VerstDetailFragment.class);
                    dataBase.index2 = i;
                    startActivity(intent);

                } else if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE)
                {
                    Fragment newFragment = new DetailNewsFragment();
                    final FragmentTransaction ft1 = getFragmentManager().beginTransaction();
                    ft1.replace(R.id.fragmentConteinerOne, newFragment);
                    ft1.commit();
                    dataBase.index2 = i;
                }
            }
        });
    }
}
