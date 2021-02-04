package com.example.tppokemon;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.bumptech.glide.Glide;
import com.example.tppokemon.adapter.PokemonEvolutionsAdapter;
import com.example.tppokemon.model.PokemonDetails;
import com.example.tppokemon.model.PokemonEvolution;
import com.example.tppokemon.repository.Repository;
import com.example.tppokemon.viewmodel.PokemonViewModel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.schedulers.Schedulers;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PokemonEvolutions#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PokemonEvolutions extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public PokemonEvolutions() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PokemonEvolutions.
     */
    // TODO: Rename and change types and number of parameters
    public static PokemonEvolutions newInstance(String param1, String param2) {
        PokemonEvolutions fragment = new PokemonEvolutions();
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
        View view = inflater.inflate(R.layout.fragment_pokemon_evolutions, container, false);

        PokemonViewModel viewModel = new ViewModelProvider(requireActivity()).get(PokemonViewModel.class);

        LottieAnimationView lottieAnimationView = view.findViewById(R.id.evolution_load);



        Bundle bundle = this.getArguments();
        String pokemonName = bundle.getString("pokemon_name");

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.pokemon_evolutions);
        LinearLayoutManager layout = new LinearLayoutManager(getActivity());
        layout.setOrientation(RecyclerView.HORIZONTAL);
        recyclerView.setLayoutManager(layout);

        PokemonEvolutionsAdapter adapter = new PokemonEvolutionsAdapter(getActivity());

        recyclerView.setAdapter(adapter);

        ArrayList<String> urls = new ArrayList<>();




        viewModel.getPokemonEvolutions(pokemonName);

        viewModel.getPokemonEvolutions().observe(getViewLifecycleOwner(), new Observer<List<PokemonEvolution>>() {
            @Override
            public void onChanged(List<PokemonEvolution> pokemonEvolution) {
                List<String> result = pokemonEvolution.get(0).getFamily().getEvolutionLine().stream().filter(pokemon -> !pokemon.toLowerCase().equals(pokemonName))
                        .collect(Collectors.toList());
                result.stream().forEach(pokemon -> {
                    viewModel.getPokemonDetailsId(pokemon.toLowerCase())
                    .subscribe(res -> {
                        urls.add("https://cdn.traction.one/pokedex/pokemon/" + res.getId() +".png");
                        adapter.setEvolutionUrls(urls);
                    });
                    lottieAnimationView.setVisibility(View.GONE);
                });

            }
        });

        return view;
    }
}