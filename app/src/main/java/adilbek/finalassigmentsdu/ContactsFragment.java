package adilbek.finalassigmentsdu;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by adilbek on 03.10.17.
 */

public class ContactsFragment extends Fragment {

    String contactsInfo[] = new String[] {
            "Тел: +7 727 307 95 60/65 (220, 231, 455)\n" +
                    "Моб: + 7 702 000 11 33 (whatsapp)\n" +
                    "Факс: +7 727 307 95 58\n" +
                    "e-mail: info@sdu.edu.kz",
            "ул. Абылай хана 1/1\n" +
                    "Алматинская обл., Карасайский р-н"
    };

    public ContactsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.contacts_info_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        TextView contacts = (TextView) getActivity().findViewById(R.id.contactstextview);
        TextView locaction = (TextView) getActivity().findViewById(R.id.locationtextview);

        contacts.setText(contactsInfo[0]);
        locaction.setText(contactsInfo[1]);
    }
}
