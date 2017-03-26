package com.example.helloworld.activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.helloworld.R;

import java.util.ArrayList;

public class ActionActivity extends AppCompatActivity {

    ArrayList<String> numList;
    ListView list;
    ActionAdapter adapter;

    MultiChoiceListener mMultiChoiceListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action);

        initView();
    }

    private void initView() {

        numList = new ArrayList<String>();
        numList.add("ONE");
        numList.add("TWO");
        numList.add("THREE");
        numList.add("FOUR");
        numList.add("FIVE");

        list = (ListView) findViewById(R.id.action_list);
        adapter = new ActionAdapter(this, numList);
        list.setAdapter(adapter);

        mMultiChoiceListener = new MultiChoiceListener();

        list.setChoiceMode(AbsListView.CHOICE_MODE_MULTIPLE_MODAL);
        list.setMultiChoiceModeListener(mMultiChoiceListener);
    }

    class MultiChoiceListener implements AbsListView.MultiChoiceModeListener {

        @Override
        public void onItemCheckedStateChanged(ActionMode mode, int position, long id, boolean checked) {
        }

        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return true;
        }

        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            return false;
        }

        @Override
        public void onDestroyActionMode(ActionMode mode) {
        }
    }

    class ActionAdapter extends BaseAdapter {

        LayoutInflater inflater;
        ArrayList<String> list;

        public ActionAdapter(Context context, ArrayList<String> li) {
            inflater = LayoutInflater.from(context);
            this.list = li;
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            ViewHolder holder = null;
            String num = list.get(position);

            if (holder == null) {
                convertView = inflater.inflate(R.layout.item_action_list, null);
                holder = new ViewHolder();
                holder.number = (TextView) convertView.findViewById(R.id.action_number);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            holder.number.setText(num);

            return convertView;
        }

        class ViewHolder {
            TextView number;
        }
    }
}
