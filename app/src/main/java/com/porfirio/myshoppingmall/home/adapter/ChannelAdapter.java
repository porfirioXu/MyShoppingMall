package com.porfirio.myshoppingmall.home.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.porfirio.myshoppingmall.R;
import com.porfirio.myshoppingmall.home.bean.ResultBeanData;
import com.porfirio.myshoppingmall.utils.Constants;

import java.util.List;

/**
 * Created by Administrator on 2017/3/12.
 */
// 频道的适配器
public class ChannelAdapter extends BaseAdapter {
    private final Context mContext;
    private final List<ResultBeanData.ResultBean.ChannelInfoBean> datas;

    public ChannelAdapter(Context mContext, List<ResultBeanData.ResultBean.ChannelInfoBean> channel_info) {
        this.mContext = mContext;
        this.datas = channel_info;
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView == null) {
            convertView = View.inflate(mContext,R.layout.item_channel,null);
            viewHolder = new ViewHolder();
            viewHolder.iv_channel= (ImageView) convertView.findViewById(R.id.iv_channel);
            viewHolder.tv_channel = (TextView) convertView.findViewById(R.id.tv_channel);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        // 根据位置得到对应的数据
        ResultBeanData.ResultBean.ChannelInfoBean channelInfoBean = datas.get(position);
        Glide.with(mContext).load(Constants.BASE_URL_IMAGE + channelInfoBean.getImage()).into(viewHolder.iv_channel);
        viewHolder.tv_channel.setText(channelInfoBean.getChannel_name());
        return convertView;
    }
    static class ViewHolder{
        ImageView iv_channel;
        TextView tv_channel;
    }
}
