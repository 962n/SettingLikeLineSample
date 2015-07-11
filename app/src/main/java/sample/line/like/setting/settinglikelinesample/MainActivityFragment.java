package sample.line.like.setting.settinglikelinesample;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.felipecsl.abslistviewhelper.library.AbsListViewHelper;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    private SettingLikeLineAdapter adapter;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        GridView gridView = (GridView) view.findViewById(R.id.gridView);
        gridView.setNumColumns(3);

        LayoutInflater inflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);


        View gridHeader = view.findViewById(R.id.header);
        View gridFooter = view.findViewById(R.id.footer);


        AbsListViewHelper helper = new AbsListViewHelper(gridView,savedInstanceState)
                .setHeaderView(gridHeader)
                .setFooterView(gridFooter);

        this.adapter = new SettingLikeLineAdapter(getActivity());
        gridView.setAdapter(this.adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                SettingLikeLineAdapter.SettingLikeLineItemInfo info = (SettingLikeLineAdapter.SettingLikeLineItemInfo) adapterView.getItemAtPosition(i);
                getActivity().startActivity(new Intent(getActivity(), info.cls));
            }
        });


    }
}
