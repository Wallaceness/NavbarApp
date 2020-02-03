package com.example.android.navigationbarapp;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class Birthstones_main extends Fragment {
    private static final String TAG = "Birthstones_main";
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private MainAdapter myAdapter;
    private RecyclerView RecyclerMain;
    public static FragmentManager BirthstoneManager;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Birthstones_main() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Birthstones_main.
     */
    // TODO: Rename and change types and number of parameters
    public static Birthstones_main newInstance(String param1, String param2) {
        Birthstones_main fragment = new Birthstones_main();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.d(TAG, "onAttach: ");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: ");
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Log.d(TAG, "onCreateView: ");
        View rootView = inflater.inflate(R.layout.fragment_birthstones, container, false);
        BirthstoneManager = getChildFragmentManager();
        ArrayList<Birthstone> stoneList = new ArrayList<Birthstone>();
        stoneList.add(new Birthstone(R.drawable.january_garnet, "January Garnet", "The word \"garnet\" comes from the 14th century Middle English word gernet, meaning \"dark red.\" The word is derived from Latin granatum, which means \"seed,\" and is called so because of the gemstone's resemblance to the red seeds of the pomegranate."));
        stoneList.add(new Birthstone(R.drawable.february_amethyst, "February Amethyst", "Amethyst is purple quartz and is a beautiful blend of violet and red that can be found in every corner of the world. The name comes from the Ancient Greek, derived from the word methustos, which means “intoxicated.” Ancient wearers believed the gemstone could protect them from drunkenness."));
        stoneList.add(new Birthstone(R.drawable.march_aquamarine, "March Aquamarine", "You probably already know of the diamond’s toughness. In fact, it’s the hardest gemstone and is made of just one element: carbon.\n" +
                "\n" +
                "Its structure makes it 58 times harder than anything in nature and can only be cut with another diamond."));
        stoneList.add(new Birthstone(R.drawable.may_emerald, "May Emerald", "As the birthstone for May, the emerald, a symbol of rebirth, is believed to grant the owner foresight, good fortune, and youth. Emerald, derived from the word “smaragdus,” means, quite literally, “green” in Greek."));
        stoneList.add(new Birthstone(R.drawable.june_pearl, "June Pearl", "Pearls are the only gemstones made by living creatures. Mollusks produce pearls by depositing layers of calcium carbonate around microscopic irritants that get lodged in their shells, usually not a grain of sand, as commonly believed."));
        stoneList.add(new Birthstone(R.drawable.july_ruby, "July Ruby", "Ruby is the red variety of the mineral corundum, colored by the element chromium. All other colors of gem-quality corundum are called sapphire, which means color is key for this royal stone. Accordingly, the name \"ruby\" comes from rubeus,"));
        stoneList.add(new Birthstone(R.drawable.august_peridot, "August Peridot", "Though peridot is widely recognized by its brilliant lime green glow, the origin of this gemstone’s name is unclear."));
        stoneList.add(new Birthstone(R.drawable.september_sapphire, "September Sapphire", "\n" +
                "Although sapphire typically refers to the rich blue gemstone variety of the mineral corundum, this royal gemstone occurs in a rainbow of hues. Sapphires come in every color except red, which earns the classification of rubies instead."));
        stoneList.add(new Birthstone(R.drawable.october_opal, "October Opal", "The name \"opal\" originates from the Greek word opallios, which meant \"to see a change in color.\""));
        stoneList.add(new Birthstone(R.drawable.november_topaz, "November Topaz", "Through much of history, all yellow gemstones were considered topaz and all topaz was thought to be yellow. Topaz is available in many colors, and it's likely not even related to the stones that first donned its name."));
        stoneList.add(new Birthstone(R.drawable.december_tanzanite, "December Tanzanite", "Tanzanite is the exquisite blue-purple variety of the mineral zoisite that is only found in one part of the world. Named for its limited geographic origin in Tanzania, tanzanite has quickly risen to popularity since its relatively recent discovery."));

        RecyclerMain = rootView.findViewById(R.id.mainrecycle);
        myAdapter = new MainAdapter(stoneList, container.getContext());
        RecyclerMain.setAdapter(myAdapter);
        RecyclerMain.setLayoutManager(new LinearLayoutManager(container.getContext()));
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d(TAG, "onViewCreated: ");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d(TAG, "onActivityCreated: ");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: ");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(TAG, "onDestroyView: ");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(TAG, "onDetach: ");
    }
}
