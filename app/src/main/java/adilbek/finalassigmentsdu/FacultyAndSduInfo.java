package adilbek.finalassigmentsdu;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class FacultyAndSduInfo extends Fragment {

    ViewPager viewPager;
    DataBase dataBase;

    String facultyInfo[] = new String[] {
//ENG
            "    Engineering is the application of mathematics, science, economics, and social and practical knowledge to i" +
                    "nvent, innovate, design, build, maintain, research, and improve structures, machines, tools, systems" +
                    ", components, materials, processes, solutions, and organizations.\n" +
                    "    The discipline of engineering is extremely broad and encompasses a range of more specialized fields o" +
                    "f engineering, each with a more specific emphasis on particular areas of applied science, technology and" +
                    " types of application.\n" +
                    "    The term Engineering is derived from the Latin ingenium, meaning \"cleverness\" and ingeniare, meaning \"t" +
                    "o contrive, devise\"",

//ECO
            "    Economics focuses on the behaviour and interactions of economic agents and how economies work. " +
                    "Microeconomics analyzes basic elements in the economy, including individual agents and markets," +
                    " their interactions, and the outcomes of interactions. Individual agents may include, for example," +
                    " households, firms, buyers, and sellers. Macroeconomics analyzes the entire economy (meaning aggregated" +
                    " production, consumption, savings, and investment) and issues affecting it, including unemployment of resources" +
                    " (labour, capital, and land), inflation, economic growth, and the public policies that address these issues (mo" +
                    "netary, fiscal, and other policies).\n" +
                    "    Other broad distinctions within economics include those between positive economics, describing \"what " +
                    "is\", and normative economics, advocating \"what ought to be\"; between economic theory and applied economics" +
                    "; between rational and behavioural economics; and between mainstream economics and heterodox economics.[4]\n",

//PHIL
            "    Philology is the study of language in written historical sources; it is a combination of " +
                    "literary criticism, history, and linguistics.[1] It is more commonly defined as the " +
                    "study of literary texts and written records, the establishment of their authenticity and " +
                    "their original form, and the determination of their meaning. A person who pursues this kind" +
                    " of study is known as a philologist.\n" +
                    "    In older usage, especially British, philology is more general, covering comparative and historical linguistics.[2][3]\n" +
                    "    Classical philology studies classical languages. Classical philology principally originated from " +
                    "the Library of Pergamum and the Library of Alexandria[4] around the fourth century BCE, continued by Greeks " +
                    "and Romans throughout the Roman/Byzantine Empire, preserved and promoted during the Islamic Golden Age, and eventual" +
                    "ly resumed by European scholars of the Renaissance, where it was soon joined by philologies of other non-Asian (Eur" +
                    "opean) (Germanic, Celtic), Eurasian (Slavistics, etc.) and Asian (Sanskrit, Persian, Arabic, Chinese, etc.) languag" +
                    "es. Indo-European studies involves the comparative philology of all Indo-European languages.\n" +
                    "    Philology, with its focus on historical development (diachronic analysis), is contrasted with li" +
                    "nguistics due to Ferdinand de Saussure's insistence on the importance of synchronic analysis. The c" +
                    "ontrast continued with the emergence of structuralism and Chomskyan linguistics alongside its emphasis on syntax.",

//LAW
            "    The Faculty of Law was established in 1924. The centre is situated in the university's North Campus in Maurice Nagar," +
                    " and is surrounded by a host of other academic institutions such as the Daulat Ram College, Miranda House, St. " +
                    "Stephen's College, Delhi, Hindu College, Delhi School of Economics, and the Faculty of Management Studies. The Fa" +
                    "culty of Law comprises three law centres.",

//SDU
            "    University derives its name from former president of Turkey, Suleyman Demirel. The President of Kazakhstan, " +
                    "Nursultan Nazarbayev, and the former president of Turkey, Suleyman Demirel participated opening ceremo" +
                    "ny.  Nursultan Nazarbayev suggested naming university by Suleyman Demirel.\n" +
                    "    Suleyman Demirel University is a fund-supported, legal entity, a non-profit organization " +
                    "established to provide multidisciplinary educational, social and cultural functions, the activity" +
                    " of which is regulated by the current legislation of the Republic of Kazakhstan. The main activity of " +
                    "the University is the implementation of educational curriculum of undergraduate, graduate education and " +
                    "supplementary education for adults. University programs are focused on the needs of modern society and " +
                    "adapted to rapidly changing social, political and economic situation in the country. The University created " +
                    "the conditions for the availability and quality of education that meets the requirements of international " +
                    "and national legislation, for continuous training of the teaching staff and better management of the University. " +
                    "The faculties of the University conduct research in various fields of knowledge. The University offers a wide" +
                    " range of additional educational services. It is focused on the development and implementation of educational, " +
                    "research and scientific programs in such a way to provide students with the necessary skills for professional " +
                    "growth and personal development. Respect for intellectual potential and dignity of the student as an individual," +
                    " are of paramount importance."
    };

    public FacultyAndSduInfo() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.faculty_and_sdu_info_fragment, null);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        dataBase = new DataBase();
        Intent intent = getActivity().getIntent();
        int index = dataBase.index;

        if(index==4) {
            ((TextView) getActivity().findViewById(R.id.aboutInfoTextView)).setText("About University");
        }

        viewPager = (ViewPager) getActivity().findViewById(R.id.facultyImagesViewPager);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getActivity(), getPicturesByID(index));
        viewPager.setAdapter(adapter);

        TextView facultyName = (TextView) getActivity().findViewById(R.id.faculty_name);
        facultyName.setText(getFacultyNameByID(index));

        TextView facultyInfoTextView = (TextView) getActivity().findViewById(R.id.faculty_info);
        facultyInfoTextView.setText(facultyInfo[index]);

        ImageView facultyIconImageView = (ImageView) getActivity().findViewById(R.id.faculty_icon);
        facultyIconImageView.setImageResource(getFacultyIconByID(index));
    }

    public int getFacultyIconByID(int id) {
        switch (id) {
            case 0:
                return R.drawable.eng_faculty_icon;
            case 1:
                return R.drawable.eco_faculty_icon;
            case 2:
                return R.drawable.phil_faculty_icon;
            case 3:
                return R.drawable.law_faculty_icon;
            case 4:
                return R.drawable.sdu_icon;
        }
        return 0;
    }

    public int[] getPicturesByID(int id) {
        switch (id) {
            case 0:
                return new int[] {R.drawable.sdu_slide_four, R.drawable.sdu_slide_five, R.drawable.sdu_slide_six};
            case 1:
                return new int[] {R.drawable.sdu_slide_one, R.drawable.sdu_slide_two, R.drawable.sdu_slide_three};
            case 2:
                return new int[] {R.drawable.sdu_slide_seven, R.drawable.sdu_silde_eight, R.drawable.sdu_slide_one};
            case 3:
                return new int[] {R.drawable.sdu_slide_five, R.drawable.sdu_slide_six, R.drawable.sdu_slide_four};
            case 4:
                return new int[] {R.drawable.sdu_slide_one, R.drawable.sdu_slide_two, R.drawable.sdu_slide_three};
        }
        return new int[]{};
    }

    public String getFacultyNameByID(int id) {
        switch (id) {
            case 0:
                return "FACULTY OF ENGINEERING AND NATURAL SCIENCE";
            case 1:
                return "FACULTY OF ECONOMICS AND ADMINISTRATIVE SCIENCE";
            case 2:
                return "FACULTY OF PHILOLOGY AND PEDAGOGICAL SCIENCE";
            case 3:
                return "FACULTY OF LAW AND SOCIAL SCIENCE";
            case 4:
                return "SULEYMAN DEMIREL UNIVERSITY";
        }
        return "";

    }

}
