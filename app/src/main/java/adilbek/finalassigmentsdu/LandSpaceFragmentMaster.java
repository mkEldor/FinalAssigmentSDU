package adilbek.finalassigmentsdu;

import android.content.Intent;
import android.content.res.Configuration;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class LandSpaceFragmentMaster extends AppCompatActivity {
    Intent intent;
    FragmentTransaction fragmentTransaction;
    DataBase dataBase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_land_space_fragment_master);
        dataBase = new DataBase();
        setFragmentAtBegin();
    }

    @Override
    public  void onConfigurationChanged(Configuration newConfig)
    {
        super.onConfigurationChanged(newConfig);
        if(newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE)
        {
            intent = new Intent(this, LandSpaceFragmentMaster.class);
            startActivity(intent);
        }

        if(newConfig.orientation == Configuration.ORIENTATION_PORTRAIT)
        {
            intent = new Intent(this, FragmentsMaster.class);
            startActivity(intent);
        }
    }

    public void setFragmentAtBegin() {
        fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragmentConteinerOne, new DefoultFragment());
        fragmentTransaction.commit();
    }
}
