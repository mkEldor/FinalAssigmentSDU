package adilbek.finalassigmentsdu;


import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;



public class DetailNewsFragment extends Fragment {

    TextView newsText;
    TextView newsTitle;
    ViewPager newsImages;
    DataBase dataBase;

    String[] listTitle = new String[] {
            "Success story of Bagdat Musin",
            "Orientation Days 2017"
    };
    String[] listText = new String[] {
            "    SDU is famous for its graduates, who with dignity occupy the leading positions of both " +
                    "domestic and foreign companies. Today we are proud to say that our university is a " +
                    "forge of training personnel in various sectors and with high competitiveness is not" +
                    " inferior to the leading positions in international and national ratings. One such " +
                    "talented person is Bagdat Musin, SDU alunmi.\n" +
                    "Today he heads the Committee on Legal Statistics and Special Accounts of the Prosecut" +
                    "or General's Office of the Republic of Kazakhstan.\n" +
                    "- This is really the person who makes a huge contribution to development, moderniza" +
                    "tion, to the forced innovation of the state apparatus. I think that it is a kind of" +
                    " almamatra for the current generation of students and has something to share with i" +
                    "t,\" - said Rector of SDU Kanat Kozhahmet.\n" +
                    "\n" +
                    "During the meeting, the speaker shared with the students a personal success story, " +
                    "told about life experiences, various stages of development on the career ladder, an" +
                    "d about the main priorities.\n" +
                    "Bagdat Musin differs creativity and ability to generate ideas. The speaker inspired " +
                    "the SDU students with their innovation and ability to explain complex things easily " +
                    "and simply. In turn, students with interest launched a discussion with the interlocu" +
                    "tor and voiced a number of exciting issues.\n" +
                    "The meeting was held in a warm informal atmosphere, and the main thing was to charge " +
                    "the children to conquer new peaks.\n" +
                    "It should be noted that holding similar meetings in the SDU will become a good tradit" +
                    "ion.",


            "   \"Orientation Days 2017\" program was held at the university from 24 to 26 August .\n" +
                    "The purpose of these three days was to introduce the first-year students the soc" +
                    "ial and administrative life of the university.\n"+
                    "\"Orientation Days\" began on the morning of 24 August with registration, which " +
                    "was attended by about 500 students. After a meeting with the rector and the admi" +
                    "nistration of the university in the concert hall, a tour of the campus was held," +
                    " where they were shown a scientific library, a student's house, laboratories, e" +
                    "tc. After lunch, the students met with faculty representatives and group curators" +
                    ". The day ended with an entertainment program at the students' home.\n" +
                    "The second day of the orientation week began with seminars from specially trained " +
                    "speakers. It was recorded 90% of attendance among new students. The seminars conti" +
                    "nued until evening. After dinner, another entertaining program was held for first-year students.\n" +
                    "The last day was completely devoted to all kinds of entertainment, like tennis, paint" +
                    "ball, relay races, etc. Also there were trips to the Charyn canyon and the Issyk lake.\n" +
                    "In general, the program \"Orientation Days 2017\" was successful. The new students we" +
                    "re satisfied, and they are ready to study hard."
    };

    public DetailNewsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.detail_news_fragment, null);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        dataBase = new DataBase();

        newsText = (TextView) getActivity().findViewById(R.id.textfornews);
        newsImages = (ViewPager) getActivity().findViewById(R.id.detailnewsviewpager);
        newsTitle = (TextView) getActivity().findViewById(R.id.detailnewstitle);

        int i = dataBase.index2;

        newsText.setText(listText[i]);
        newsTitle.setText(listTitle[i]);

        ViewPagerAdapter adapter = new ViewPagerAdapter(getActivity(), getPicturesByID(i));

        newsImages.setAdapter(adapter);
    }

    public int[] getPicturesByID(int id) {
        switch (id) {
            case 0:
                return new int[] {R.drawable.news_1, R.drawable.news_2};
            case 1:
                return new int[] {R.drawable.news_3, R.drawable.news_4, R.drawable.news_5};
        }
        return new int[]{};
    }

}
