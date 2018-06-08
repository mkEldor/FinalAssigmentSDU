package adilbek.finalassigmentsdu;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class FragmentsMaster extends AppCompatActivity {
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragments_master);
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
}
