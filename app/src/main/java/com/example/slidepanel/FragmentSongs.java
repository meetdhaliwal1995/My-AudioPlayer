package com.example.slidepanel;

import android.app.DownloadManager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FragmentSongs extends Fragment implements GetUrlInterface {
    RecyclerView recyclerView;
    AdapterSongs adapterSongs;
    public List<PhnSongs> _list;
    SongClass songClass;
    private MainActivity getMainActivity;
    FragmentMore fragmentMore;
    String name;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_allsong, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recycle_frag);

        getMainActivity = (MainActivity) getActivity();

        adapterSongs = new AdapterSongs(getContext(), MainActivity._list, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setItemViewCacheSize(500);
        recyclerView.setAdapter(adapterSongs);

        songClass = new SongClass();
//        getMainActivity.setAdapterSongs(adapterSongs);

        Bundle bundle = this.getArguments();

        if (bundle != null) {
            String foo = getArguments().getString("teste");

            Toast.makeText(getActivity().getApplicationContext(), foo, Toast.LENGTH_SHORT).show();
        }
    }

//    public void setFragmentMore(FragmentMore fragmentMore) {
//        this.fragmentMore = fragmentMore;
//    }

    @Override
    public void onItemClick(int position) {
        getMainActivity.songPlay(position);
    }

    @Override
    public void onLongClick(int position) {
        _list.remove(position);
        adapterSongs.notifyItemRemoved(position);

    }

    public void set_list(List<PhnSongs> _list) {
        this._list = _list;
        Log.e("song", String.valueOf(_list.size()));
    }
    public void getString(String str){
        this.name = str;
    }


}


