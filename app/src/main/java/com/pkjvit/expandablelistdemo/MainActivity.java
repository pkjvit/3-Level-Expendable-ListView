package com.pkjvit.expandablelistdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerview = (RecyclerView) findViewById(R.id.recyclerview);
        recyclerview.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        List<ExpandableListAdapter.Item> data = new ArrayList<>();

        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.HEADER, new MyObject("Fruits")));
        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD_L1, new MyObject("Apple")));
        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD_L2, new MyObject("a1")));
        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD_L2, new MyObject("a2")));
        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD_L1, new MyObject("Orange")));
        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD_L2, new MyObject("o1")));
        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD_L2, new MyObject("o2")));
        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD_L2, new MyObject("o3")));
        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD_L1, new MyObject("Banana")));
        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD_L2, new MyObject("b1")));
        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.HEADER, new MyObject("Cars")));
        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD_L1, new MyObject("Audi")));
        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD_L2, new MyObject("au1")));
        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD_L2, new MyObject("au2")));
        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD_L2, new MyObject("au3")));
        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD_L1, new MyObject("Aston Martin")));
        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD_L2, new MyObject("am1")));
        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD_L2, new MyObject("am2")));
        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD_L1, new MyObject("BMW")));
        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD_L2, new MyObject("b1")));
        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD_L1, new MyObject("Cadillac")));
        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD_L2, new MyObject("c1")));
        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD_L2, new MyObject("c2")));

        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.HEADER, new MyObject("Places")));
        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD_L1, new MyObject("Kerala")));
        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD_L2, new MyObject("k1")));
        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD_L2, new MyObject("k2")));
        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD_L1, new MyObject("Tamil Nadu")));
        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD_L2, new MyObject("t1")));
        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD_L1, new MyObject("Karnataka")));
        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD_L2, new MyObject("kt1")));
        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD_L2, new MyObject("kt2")));
        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD_L2, new MyObject("kt3")));
        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD_L2, new MyObject("kt4")));
        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD_L1, new MyObject("Maharashtra")));
        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD_L2, new MyObject("m1")));
        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD_L2, new MyObject("m2")));
        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD_L2, new MyObject("m3")));


        /*ExpandableListAdapter.Item places = new ExpandableListAdapter.Item(ExpandableListAdapter.HEADER, new MyObject("Places"));
        places.invisibleChildren = new ArrayList<>();
        places.invisibleChildren.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD_L1, new MyObject("Kerala")));
        places.invisibleChildren.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD_L2, new MyObject("k1")));
        places.invisibleChildren.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD_L2, new MyObject("k2")));
        places.invisibleChildren.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD_L1, new MyObject("Tamil Nadu")));
        places.invisibleChildren.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD_L2, new MyObject("t1")));
        places.invisibleChildren.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD_L1, new MyObject("Karnataka")));
        places.invisibleChildren.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD_L2, new MyObject("kt1")));
        places.invisibleChildren.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD_L2, new MyObject("kt2")));
        places.invisibleChildren.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD_L2, new MyObject("kt3")));
        places.invisibleChildren.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD_L2, new MyObject("kt4")));
        places.invisibleChildren.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD_L1, new MyObject("Maharashtra")));
        places.invisibleChildren.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD_L2, new MyObject("m1")));
        places.invisibleChildren.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD_L2, new MyObject("m2")));
        places.invisibleChildren.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD_L2, new MyObject("m3")));

        data.add(places);*/

        recyclerview.setAdapter(new ExpandableListAdapter(makeAllInvisible(data)));
    }

    public List<ExpandableListAdapter.Item> makeAllInvisible(List<ExpandableListAdapter.Item> data){
        ArrayList<ExpandableListAdapter.Item> invisibleData = new ArrayList<>();

        ArrayList<ExpandableListAdapter.Item> headerList = null;
        ArrayList<ExpandableListAdapter.Item> childList = null;
        ExpandableListAdapter.Item headerItem = null;
        ExpandableListAdapter.Item childItem = null;


        for(int index = 0 ; index<data.size() ; index++){
            ExpandableListAdapter.Item item = data.get(index);
            switch (item.type){
                case ExpandableListAdapter.HEADER :
                    if(headerItem!=null){
                        headerItem.invisibleChildren = new ArrayList<>(headerList);
                    }
                    headerItem = item;
                    invisibleData.add(headerItem);
                    headerList = new ArrayList<>();

                    break;

                case ExpandableListAdapter.CHILD_L1 :
                    if(childItem!=null){
                        childItem.invisibleChildren = new ArrayList<>(childList);
                    }
                    childItem = item;
                    headerList.add(childItem);
                    childList = new ArrayList<>();
                    break;

                case ExpandableListAdapter.CHILD_L2 :
                    if(childList!=null)
                        childList.add(item);
                    break;
            }

        }

        if(childItem!=null){
            childItem.invisibleChildren = new ArrayList<>(childList);
        }
        if(headerItem!=null){
            headerItem.invisibleChildren = new ArrayList<>(headerList);
        }

        return invisibleData;
    }
}
