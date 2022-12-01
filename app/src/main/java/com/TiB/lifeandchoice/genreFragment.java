package com.TiB.lifeandchoice;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link genreFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class genreFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public genreFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment genreFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static genreFragment newInstance(String param1, String param2) {
        genreFragment fragment = new genreFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_genre, container, false);
        ImageButton cerita = v.findViewById(R.id.ceritamalih);
        TextView jdl = v.findViewById(R.id.judul_txt);
        ImageButton cerita2 = v.findViewById(R.id.cerita2);
        TextView jdl2 = v.findViewById(R.id.judul_txt2);
        ImageButton cerita3 = v.findViewById(R.id.cerita_3);
        TextView jdl3 = v.findViewById(R.id.judul_txt3);
        ImageButton cerita4 = v.findViewById(R.id.cerita_4);
        TextView judul4 = v.findViewById(R.id.judul_txt4);

        cerita.setImageResource(R.drawable.cerita1);
        cerita2.setImageResource(R.drawable.cerita2);
        cerita3.setImageResource(R.drawable.cerita3);
        cerita4.setImageResource(R.drawable.cerita4);

        jdl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), malihdandompet.class));
                getActivity().onBackPressed();
            }
        });

        cerita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), malihdandompet.class));
                getActivity().onBackPressed();
            }
        });

        jdl2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), BajuLebaranAsep.class));
                getActivity().onBackPressed();
            }
        });

        cerita2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), BajuLebaranAsep.class));
                getActivity().onBackPressed();
            }
        });

        jdl3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), valentineday.class);
                startActivity(i);
                getActivity().onBackPressed();
            }
        });

        cerita3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), valentineday.class);
                startActivity(i);
                getActivity().onBackPressed();
            }
        });

        judul4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), kosthorror.class);
                startActivity(i);
                getActivity().onBackPressed();
            }
        });

        cerita4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), kosthorror.class);
                startActivity(i);
                getActivity().onBackPressed();
            }
        });

        return v;
    }
}