package com.pkjvit.expandablelistdemo;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anandbose on 09/06/15.
 */
public class ExpandableListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final int HEADER = 0;
    public static final int CHILD_L1 = 1;
    public static final int CHILD_L2 = 2;

    private List<Item>      data;
    private RecyclerView    mRecyclerView;

    public ExpandableListAdapter(RecyclerView recyclerView, List<Item> data) {
        this.data = data;
        mRecyclerView = recyclerView;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int type) {
        View view = null;
        Context context = parent.getContext();
        float dp = context.getResources().getDisplayMetrics().density;
        LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        switch (type) {
            case HEADER:
                view = inflater.inflate(R.layout.list_header, parent, false);
                return new ListHeaderViewHolder(view);
            case CHILD_L1:
                view = inflater.inflate(R.layout.list_child_l1, parent, false);
                return new ListHeaderViewHolder(view);

            case CHILD_L2:
                view = inflater.inflate(R.layout.list_child_l2, parent, false);
                return new ListHeaderViewHolder(view);
        }
        return null;
    }

    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final Item item = data.get(position);
        final MyObject myObject = (MyObject)data.get(position).object;
        switch (item.type) {
            case HEADER:
                final ListHeaderViewHolder itemController = (ListHeaderViewHolder) holder;
                itemController.refferalItem = item;
                itemController.header_title.setText(myObject.name);
                if (item.invisibleChildren == null) {
                    itemController.btn_expand_toggle.setImageResource(R.drawable.circle_minus);
                } else {
                    itemController.btn_expand_toggle.setImageResource(R.drawable.circle_plus);
                }
                itemController.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (item.invisibleChildren == null) {
                            item.invisibleChildren = new ArrayList<Item>();
                            int count = 0;
                            int pos = data.indexOf(itemController.refferalItem);
                            Item childItem = null;
                            ArrayList<Item> listInvisibleChild = null;
                            while (data.size() > pos + 1 && (data.get(pos + 1).type == CHILD_L1 || data.get(pos + 1).type == CHILD_L2) ) {

                                if(data.get(pos + 1).type == CHILD_L1){
                                    if(childItem!=null){
                                        if(listInvisibleChild != null){
                                            childItem.invisibleChildren = new ArrayList<Item>(listInvisibleChild);
                                            listInvisibleChild = null;
                                        }
                                    }
                                    childItem = data.get(pos+1);

                                    if(childItem.invisibleChildren == null){
                                        childItem.invisibleChildren = new ArrayList<Item>();
                                    }

                                    item.invisibleChildren.add(data.remove(pos + 1));
                                }else if(data.get(pos + 1).type == CHILD_L2){

                                    if(childItem.invisibleChildren != null){
                                        childItem.invisibleChildren.add(data.remove(pos + 1));
                                    }else{
                                        if(listInvisibleChild == null){
                                            listInvisibleChild = new ArrayList<Item>();
                                        }
                                        listInvisibleChild.add(data.remove(pos + 1));

                                    }
                                }
                                count++;

                                /*item.invisibleChildren.add(data.remove(pos + 1));
                                count++;*/
                            }
                            notifyItemRangeRemoved(pos + 1, count);
                            itemController.btn_expand_toggle.setImageResource(R.drawable.circle_plus);
                        } else {
                            int pos = data.indexOf(itemController.refferalItem);
                            int index = pos + 1;
                            for (Item i : item.invisibleChildren) {
                                data.add(index, i);
                                index++;
                            }
                            notifyItemRangeInserted(pos + 1, index - pos - 1);
                            int lastVisiblePosition = ((LinearLayoutManager)mRecyclerView.getLayoutManager()).findLastVisibleItemPosition();
                            if(lastVisiblePosition-1 <= pos){
                                mRecyclerView.scrollToPosition(index-1);
                            }
                            itemController.btn_expand_toggle.setImageResource(R.drawable.circle_minus);
                            item.invisibleChildren = null;
                        }
                    }
                });
                break;

            case CHILD_L1:
                final ListHeaderViewHolder childItemController = (ListHeaderViewHolder) holder;
                childItemController.refferalItem = item;
                childItemController.header_title.setText(myObject.name);
                if (item.invisibleChildren == null) {
                    childItemController.btn_expand_toggle.setImageResource(R.drawable.ic_arrow_drop_up_black_24dp);
                } else {
                    childItemController.btn_expand_toggle.setImageResource(R.drawable.ic_arrow_drop_down_black_24dp);
                }
                childItemController.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (item.invisibleChildren == null) {
                            item.invisibleChildren = new ArrayList<Item>();
                            int count = 0;
                            int pos = data.indexOf(childItemController.refferalItem);
                            while (data.size() > pos + 1 && data.get(pos + 1).type == CHILD_L2) {
                                item.invisibleChildren.add(data.remove(pos + 1));
                                count++;
                            }
                            notifyItemRangeRemoved(pos + 1, count);
                            childItemController.btn_expand_toggle.setImageResource(R.drawable.ic_arrow_drop_down_black_24dp);
                        } else {
                            int pos = data.indexOf(childItemController.refferalItem);
                            int index = pos + 1;
                            for (Item i : item.invisibleChildren) {
                                data.add(index, i);
                                index++;
                            }
                            notifyItemRangeInserted(pos + 1, index - pos - 1);
                            int lastVisiblePosition = ((LinearLayoutManager)mRecyclerView.getLayoutManager()).findLastVisibleItemPosition();
                            if(lastVisiblePosition-1 <= pos){
                                mRecyclerView.scrollToPosition(index-1);
                            }
                            childItemController.btn_expand_toggle.setImageResource(R.drawable.ic_arrow_drop_up_black_24dp);
                            item.invisibleChildren = null;
                        }
                    }
                });
                break;
            case CHILD_L2:
                final ListHeaderViewHolder childL2ItemController = (ListHeaderViewHolder) holder;
                childL2ItemController.refferalItem = item;
                childL2ItemController.header_title.setText(myObject.name);
                childL2ItemController.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(view.getContext(), myObject.name, Toast.LENGTH_LONG).show();
                    }
                });
                break;
        }
    }

    @Override
    public int getItemViewType(int position) {
        return data.get(position).type;
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    private static class ListHeaderViewHolder extends RecyclerView.ViewHolder {
        public TextView header_title;
        public ImageView btn_expand_toggle;
        public Item refferalItem;

        public ListHeaderViewHolder(View itemView) {
            super(itemView);
            header_title = (TextView) itemView.findViewById(R.id.header_title);
            btn_expand_toggle = (ImageView) itemView.findViewById(R.id.btn_expand_toggle);
        }
    }

    public static class Item {
        public int type;
        public Object object;
        public boolean isExpand;
        public List<Item> invisibleChildren;

        public Item() {
        }

        public Item(int type, Object object) {
            this.type = type;
            this.object = object;
        }
    }
}
