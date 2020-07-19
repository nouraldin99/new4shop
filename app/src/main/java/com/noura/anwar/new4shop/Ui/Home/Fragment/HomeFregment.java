package com.noura.anwar.new4shop.Ui.Home.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.noura.anwar.new4shop.Adapter.ItemAdapter;
import com.noura.anwar.new4shop.Moodle.Item;
import com.noura.anwar.new4shop.R;

import java.util.ArrayList;

public class HomeFregment extends Fragment {

   private View view ;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view= inflater.inflate(R.layout.fragment_home,null,false);
        initRecyclerView1();

        return view;
    }
    private void initRecyclerView1() {
        RecyclerView recyclerView1 = view.findViewById(R.id.recyclerView);
        ArrayList<Item> items = new ArrayList<>();
        items.add(new Item("item1",5, R.drawable.item1));
//        items.add(new Item("", R.drawable.ic_course_2));
//        items.add(new Item("", R.drawable.ic_course_3));
//        items.add(new Item("", R.drawable.ic_course_3));
        ItemAdapter itemAdapter = new ItemAdapter(items);


        recyclerView1.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false));
        recyclerView1.setAdapter(itemAdapter);
    }
}
