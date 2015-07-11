package sample.line.like.setting.settinglikelinesample;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * アダプタークラス
 */
public class SettingLikeLineAdapter extends BaseAdapter {


    private Context context;
    private ArrayList<SettingLikeLineItemInfo> itemList;
    private LayoutInflater inflater;


    public SettingLikeLineAdapter(Context context) {
        super();
        this.context = context;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.itemList = createSettingItemList();
    }

    private ArrayList<SettingLikeLineItemInfo> createSettingItemList() {
        ArrayList<SettingLikeLineItemInfo> list = new ArrayList<SettingLikeLineItemInfo>();

        for (int i = 0; i < 10; i++) {
            SettingLikeLineItemInfo info = new SettingLikeLineItemInfo(R.string.app_name, R.mipmap.ic_launcher, MainActivity.class);
            list.add(info);
        }

        return list;
    }

    @Override
    public int getCount() {
        return itemList.size();
    }

    @Override
    public Object getItem(int i) {
        return itemList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewHolder holder = null;

        if (view == null) {
            view = inflater.inflate(R.layout.adapter_item_setting_like_line, viewGroup, false);
            holder = new ViewHolder();
            holder.iconImage = (ImageView) view.findViewById(R.id.iconImage);
            holder.titleText = (TextView) view.findViewById(R.id.titleText);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        SettingLikeLineItemInfo info = this.itemList.get(i);
        holder.iconImage.setImageResource(info.iconDrawableId);
        holder.titleText.setText(info.titleTextId);

        return view;
    }

    public class SettingLikeLineItemInfo {
        int titleTextId;
        int iconDrawableId;
        //起動先Activityのクラス
        Class<?> cls;

        public SettingLikeLineItemInfo(int titleTextId, int iconDrawableId, Class<?> cls) {
            this.titleTextId = titleTextId;
            this.iconDrawableId = iconDrawableId;
            this.cls = cls;
        }
    }

    private static class ViewHolder {
        ImageView iconImage;
        TextView titleText;
    }

}
