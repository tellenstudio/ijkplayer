/*
 * Copyright (C) 2015 Bilibili
 * Copyright (C) 2015 Zhang Rui <bbcallen@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package tv.danmaku.ijk.media.example.fragments;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import tv.danmaku.ijk.media.example.R;
import tv.danmaku.ijk.media.example.activities.VideoActivity;

public class SampleMediaListFragment extends Fragment {
    private ListView mFileListView;
    private SampleMediaAdapter mAdapter;

    public static SampleMediaListFragment newInstance() {
        SampleMediaListFragment f = new SampleMediaListFragment();
        return f;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup viewGroup = (ViewGroup) inflater.inflate(R.layout.fragment_file_list, container, false);
        mFileListView = (ListView) viewGroup.findViewById(R.id.file_list_view);
        return viewGroup;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        final Activity activity = getActivity();

        mAdapter = new SampleMediaAdapter(activity);
        mFileListView.setAdapter(mAdapter);
        mFileListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, final long id) {
                SampleMediaItem item = mAdapter.getItem(position);
                String name = item.mName;
                String url = item.mUrl;
                VideoActivity.intentTo(activity, url, name);
            }
        });

        String manifest_string =
                "{\n" +
                "    \"version\": \"1.0.0\",\n" +
                "    \"adaptationSet\": [\n" +
                "        {\n" +
                "            \"duration\": 1000,\n" +
                "            \"id\": 1,\n" +
                "            \"representation\": [\n" +
                "                {\n" +
                "                    \"id\": 1,\n" +
                "                    \"codec\": \"avc1.64001e,mp4a.40.5\",\n" +
                "                    \"url\": \"http://las-tech.org.cn/kwai/las-test_ld500d.flv\",\n" +
                "                    \"backupUrl\": [],\n" +
                "                    \"host\": \"las-tech.org.cn\",\n" +
                "                    \"maxBitrate\": 700,\n" +
                "                    \"width\": 640,\n" +
                "                    \"height\": 360,\n" +
                "                    \"frameRate\": 25,\n" +
                "                    \"qualityType\": \"SMOOTH\",\n" +
                "                    \"qualityTypeName\": \"流畅\",\n" +
                "                    \"hidden\": false,\n" +
                "                    \"disabledFromAdaptive\": false,\n" +
                "                    \"defaultSelected\": false\n" +
                "                },\n" +
                "                {\n" +
                "                    \"id\": 2,\n" +
                "                    \"codec\": \"avc1.64001f,mp4a.40.5\",\n" +
                "                    \"url\": \"http://las-tech.org.cn/kwai/las-test_sd1000d.flv\",\n" +
                "                    \"backupUrl\": [],\n" +
                "                    \"host\": \"las-tech.org.cn\",\n" +
                "                    \"maxBitrate\": 1300,\n" +
                "                    \"width\": 960,\n" +
                "                    \"height\": 540,\n" +
                "                    \"frameRate\": 25,\n" +
                "                    \"qualityType\": \"STANDARD\",\n" +
                "                    \"qualityTypeName\": \"标清\",\n" +
                "                    \"hidden\": false,\n" +
                "                    \"disabledFromAdaptive\": false,\n" +
                "                    \"defaultSelected\": true\n" +
                "                },\n" +
                "                {\n" +
                "                    \"id\": 3,\n" +
                "                    \"codec\": \"avc1.64001f,mp4a.40.5\",\n" +
                "                    \"url\": \"http://las-tech.org.cn/kwai/las-test.flv\",\n" +
                "                    \"backupUrl\": [],\n" +
                "                    \"host\": \"las-tech.org.cn\",\n" +
                "                    \"maxBitrate\": 2300,\n" +
                "                    \"width\": 1280,\n" +
                "                    \"height\": 720,\n" +
                "                    \"frameRate\": 30,\n" +
                "                    \"qualityType\": \"HIGH\",\n" +
                "                    \"qualityTypeName\": \"高清\",\n" +
                "                    \"hidden\": false,\n" +
                "                    \"disabledFromAdaptive\": false,\n" +
                "                    \"defaultSelected\": false\n" +
                "                }\n" +
                "            ]\n" +
                "        }\n" +
                "    ]\n" +
                "}";

//        mAdapter.addItem(manifest_string, "las test");
//        mAdapter.addItem("http://devimages.apple.com.edgekey.net/streaming/examples/bipbop_4x3/bipbop_4x3_variant.m3u8", "bipbop basic master playlist");
//        mAdapter.addItem("http://devimages.apple.com.edgekey.net/streaming/examples/bipbop_4x3/gear1/prog_index.m3u8", "bipbop basic 400x300 @ 232 kbps");
//        mAdapter.addItem("http://devimages.apple.com.edgekey.net/streaming/examples/bipbop_4x3/gear2/prog_index.m3u8", "bipbop basic 640x480 @ 650 kbps");
//        mAdapter.addItem("http://devimages.apple.com.edgekey.net/streaming/examples/bipbop_4x3/gear3/prog_index.m3u8", "bipbop basic 640x480 @ 1 Mbps");
//        mAdapter.addItem("http://devimages.apple.com.edgekey.net/streaming/examples/bipbop_4x3/gear4/prog_index.m3u8", "bipbop basic 960x720 @ 2 Mbps");
//        mAdapter.addItem("http://devimages.apple.com.edgekey.net/streaming/examples/bipbop_4x3/gear0/prog_index.m3u8", "bipbop basic 22.050Hz stereo @ 40 kbps");
//        mAdapter.addItem("http://devimages.apple.com.edgekey.net/streaming/examples/bipbop_16x9/bipbop_16x9_variant.m3u8", "bipbop advanced master playlist");
//        mAdapter.addItem("http://devimages.apple.com.edgekey.net/streaming/examples/bipbop_16x9/gear1/prog_index.m3u8", "bipbop advanced 416x234 @ 265 kbps");
//        mAdapter.addItem("http://devimages.apple.com.edgekey.net/streaming/examples/bipbop_16x9/gear2/prog_index.m3u8", "bipbop advanced 640x360 @ 580 kbps");
//        mAdapter.addItem("http://devimages.apple.com.edgekey.net/streaming/examples/bipbop_16x9/gear3/prog_index.m3u8", "bipbop advanced 960x540 @ 910 kbps");
//        mAdapter.addItem("http://devimages.apple.com.edgekey.net/streaming/examples/bipbop_16x9/gear4/prog_index.m3u8", "bipbop advanced 1289x720 @ 1 Mbps");
//        mAdapter.addItem("http://devimages.apple.com.edgekey.net/streaming/examples/bipbop_16x9/gear5/prog_index.m3u8", "bipbop advanced 1920x1080 @ 2 Mbps");
//        mAdapter.addItem("http://devimages.apple.com.edgekey.net/streaming/examples/bipbop_16x9/gear0/prog_index.m3u8", "bipbop advanced 22.050Hz stereo @ 40 kbps");

        mAdapter.addItem("http://cctvalih5ca.v.myalicdn.com/live/cctv1_2/index.m3u8", "CCTV1");
        mAdapter.addItem("cronet://cctvalih5ca.v.myalicdn.com/live/cctv1_2/index.m3u8", "CCTV1");
        mAdapter.addItem("http://ivi.bupt.edu.cn/hls/cctv1hd.m3u8", "CCTV1-HD");
        mAdapter.addItem("cronet://ivi.bupt.edu.cn/hls/cctv1hd.m3u8", "CCTV1-HD");
        mAdapter.addItem("http://cctvalih5ca.v.myalicdn.com/live/cctv2_2/index.m3u8", "CCTV2");
        mAdapter.addItem("cronet://cctvalih5ca.v.myalicdn.com/live/cctv2_2/index.m3u8", "CCTV2");
        mAdapter.addItem("http://cctvalih5ca.v.myalicdn.com/live/cctv3_2/index.m3u8", "CCTV3");
        mAdapter.addItem("cronet://cctvalih5ca.v.myalicdn.com/live/cctv3_2/index.m3u8", "CCTV3");
        mAdapter.addItem("http://ivi.bupt.edu.cn/hls/cctv3hd.m3u8", "CCTV3-HD");
        mAdapter.addItem("cronet://ivi.bupt.edu.cn/hls/cctv3hd.m3u8", "CCTV3-HD");
        mAdapter.addItem("http://cctvalih5ca.v.myalicdn.com/live/cctv4_2/index.m3u8", "CCTV4");
        mAdapter.addItem("cronet://cctvalih5ca.v.myalicdn.com/live/cctv4_2/index.m3u8", "CCTV4");
        mAdapter.addItem("http://cctvalih5ca.v.myalicdn.com/live/cctv5_2/index.m3u8", "CCTV5");
        mAdapter.addItem("cronet://cctvalih5ca.v.myalicdn.com/live/cctv5_2/index.m3u8", "CCTV5");
        mAdapter.addItem("http://ivi.bupt.edu.cn/hls/cctv5phd.m3u8", "CCTV5+-HD");
        mAdapter.addItem("cronet://ivi.bupt.edu.cn/hls/cctv5phd.m3u8", "CCTV5+-HD");
        mAdapter.addItem("http://cctvalih5ca.v.myalicdn.com/live/cctv6_2/index.m3u8", "CCTV6");
        mAdapter.addItem("cronet://cctvalih5ca.v.myalicdn.com/live/cctv6_2/index.m3u8", "CCTV6");
        mAdapter.addItem("http://ivi.bupt.edu.cn/hls/cctv6hd.m3u8", "CCTV6-HD");
        mAdapter.addItem("cronet://ivi.bupt.edu.cn/hls/cctv6hd.m3u8", "CCTV6-HD");
        mAdapter.addItem("http://cctvalih5ca.v.myalicdn.com/live/cctv8_2/index.m3u8", "CCTV8");
        mAdapter.addItem("cronet://cctvalih5ca.v.myalicdn.com/live/cctv8_2/index.m3u8", "CCTV8");
        mAdapter.addItem("http://ivi.bupt.edu.cn/hls/cctv8hd.m3u8", "CCTV8-HD");
        mAdapter.addItem("cronet://ivi.bupt.edu.cn/hls/cctv8hd.m3u8", "CCTV8-HD");
        mAdapter.addItem("http://cctvalih5ca.v.myalicdn.com/live/cctv13_2/index.m3u8", "CCTV13");
        mAdapter.addItem("cronet://cctvalih5ca.v.myalicdn.com/live/cctv13_2/index.m3u8", "CCTV13");
        mAdapter.addItem("http://ivi.bupt.edu.cn/hls/chchd.m3u8", "CHC-HD电影");
        mAdapter.addItem("cronet://ivi.bupt.edu.cn/hls/chchd.m3u8", "CHC-HD电影");
        mAdapter.addItem("http://ivi.bupt.edu.cn/hls/btv1hd.m3u8", "北京卫视-HD");
        mAdapter.addItem("cronet://ivi.bupt.edu.cn/hls/btv1hd.m3u8", "北京卫视-HD");
        mAdapter.addItem("http://ivi.bupt.edu.cn/hls/btv2hd.m3u8", "北京文艺-HD");
        mAdapter.addItem("cronet://ivi.bupt.edu.cn/hls/btv2hd.m3u8", "北京文艺-HD");
        mAdapter.addItem("http://ivi.bupt.edu.cn/hls/btv11hd.m3u8", "北京体育-HD");
        mAdapter.addItem("cronet://ivi.bupt.edu.cn/hls/btv11hd.m3u8", "北京体育-HD");
        mAdapter.addItem("http://ivi.bupt.edu.cn/hls/hunanhd.m3u8", "湖南卫视-HD");
        mAdapter.addItem("cronet://ivi.bupt.edu.cn/hls/hunanhd.m3u8", "湖南卫视-HD");
        mAdapter.addItem("http://ivi.bupt.edu.cn/hls/zjhd.m3u8", "浙江卫视-HD");
        mAdapter.addItem("cronet://ivi.bupt.edu.cn/hls/zjhd.m3u8", "浙江卫视-HD");
        mAdapter.addItem("http://ivi.bupt.edu.cn/hls/jshd.m3u8", "江苏卫视-HD");
        mAdapter.addItem("cronet://ivi.bupt.edu.cn/hls/jshd.m3u8", "江苏卫视-HD");
        mAdapter.addItem("http://ivi.bupt.edu.cn/hls/dfhd.m3u8", "东方卫视-HD");
        mAdapter.addItem("cronet://ivi.bupt.edu.cn/hls/dfhd.m3u8", "东方卫视-HD");
        mAdapter.addItem("http://ivi.bupt.edu.cn/hls/ahhd.m3u8", "安徽卫视-HD");
        mAdapter.addItem("cronet://ivi.bupt.edu.cn/hls/ahhd.m3u8", "安徽卫视-HD");
        mAdapter.addItem("http://ivi.bupt.edu.cn/hls/hljhd.m3u8", "黑龙江卫视-HD");
        mAdapter.addItem("cronet://ivi.bupt.edu.cn/hls/hljhd.m3u8", "黑龙江卫视-HD");
        mAdapter.addItem("http://ivi.bupt.edu.cn/hls/lnhd.m3u8", "辽宁卫视-HD");
        mAdapter.addItem("cronet://ivi.bupt.edu.cn/hls/lnhd.m3u8", "辽宁卫视-HD");
        mAdapter.addItem("http://ivi.bupt.edu.cn/hls/szhd.m3u8", "深圳卫视-HD");
        mAdapter.addItem("cronet://ivi.bupt.edu.cn/hls/szhd.m3u8", "深圳卫视-HD");
        mAdapter.addItem("http://ivi.bupt.edu.cn/hls/gdhd.m3u8", "广东卫视-HD");
        mAdapter.addItem("cronet://ivi.bupt.edu.cn/hls/gdhd.m3u8", "广东卫视-HD");
        mAdapter.addItem("http://ivi.bupt.edu.cn/hls/tjhd.m3u8", "天津卫视-HD");
        mAdapter.addItem("cronet://ivi.bupt.edu.cn/hls/tjhd.m3u8", "天津卫视-HD");
        mAdapter.addItem("http://ivi.bupt.edu.cn/hls/hbhd.m3u8", "湖北卫视-HD");
        mAdapter.addItem("cronet://ivi.bupt.edu.cn/hls/hbhd.m3u8", "湖北卫视-HD");
        mAdapter.addItem("http://ivi.bupt.edu.cn/hls/sdhd.m3u8", "山东卫视-HD");
        mAdapter.addItem("cronet://ivi.bupt.edu.cn/hls/sdhd.m3u8", "山东卫视-HD");
        mAdapter.addItem("http://vfx.mtime.cn/Video/2019/02/04/mp4/190204084208765161.mp4", "驯龙高手");
        mAdapter.addItem("cronet://vfx.mtime.cn/Video/2019/02/04/mp4/190204084208765161.mp4", "驯龙高手");
        mAdapter.addItem("http://vfx.mtime.cn/Video/2019/03/19/mp4/190319222227698228.mp4", "紧急救援");
        mAdapter.addItem("cronet://vfx.mtime.cn/Video/2019/03/19/mp4/190319222227698228.mp4", "紧急救援");
        mAdapter.addItem("http://vfx.mtime.cn/Video/2019/03/19/mp4/190319212559089721.mp4", "玩具总动员");
        mAdapter.addItem("cronet://vfx.mtime.cn/Video/2019/03/19/mp4/190319212559089721.mp4", "玩具总动员");
        mAdapter.addItem("http://vfx.mtime.cn/Video/2019/03/18/mp4/190318231014076505.mp4", "叶问4预告片");
        mAdapter.addItem("cronet://vfx.mtime.cn/Video/2019/03/18/mp4/190318231014076505.mp4", "叶问4预告片");
        mAdapter.addItem("http://devimages.apple.com.edgekey.net/streaming/examples/bipbop_4x3/bipbop_4x3_variant.m3u8", "bipbop basic master playlist");
        mAdapter.addItem("cronet://devimages.apple.com.edgekey.net/streaming/examples/bipbop_4x3/bipbop_4x3_variant.m3u8", "bipbop basic master playlist");
        mAdapter.addItem("http://devimages.apple.com.edgekey.net/streaming/examples/bipbop_4x3/gear1/prog_index.m3u8", "bipbop basic 400x300 @ 232 kbps");
        mAdapter.addItem("cronet://devimages.apple.com.edgekey.net/streaming/examples/bipbop_4x3/gear1/prog_index.m3u8", "bipbop basic 400x300 @ 232 kbps");
        mAdapter.addItem("http://devimages.apple.com.edgekey.net/streaming/examples/bipbop_4x3/gear2/prog_index.m3u8", "bipbop basic 640x480 @ 650 kbps");
        mAdapter.addItem("cronet://devimages.apple.com.edgekey.net/streaming/examples/bipbop_4x3/gear2/prog_index.m3u8", "bipbop basic 640x480 @ 650 kbps");
        mAdapter.addItem("http://devimages.apple.com.edgekey.net/streaming/examples/bipbop_4x3/gear3/prog_index.m3u8", "bipbop basic 640x480 @ 1 Mbps");
        mAdapter.addItem("cronet://devimages.apple.com.edgekey.net/streaming/examples/bipbop_4x3/gear3/prog_index.m3u8", "bipbop basic 640x480 @ 1 Mbps");
        mAdapter.addItem("http://devimages.apple.com.edgekey.net/streaming/examples/bipbop_4x3/gear4/prog_index.m3u8", "bipbop basic 960x720 @ 2 Mbps");
        mAdapter.addItem("cronet://devimages.apple.com.edgekey.net/streaming/examples/bipbop_4x3/gear4/prog_index.m3u8", "bipbop basic 960x720 @ 2 Mbps");
        mAdapter.addItem("http://devimages.apple.com.edgekey.net/streaming/examples/bipbop_4x3/gear0/prog_index.m3u8", "bipbop basic 22.050Hz stereo @ 40 kbps");
        mAdapter.addItem("cronet://devimages.apple.com.edgekey.net/streaming/examples/bipbop_4x3/gear0/prog_index.m3u8", "bipbop basic 22.050Hz stereo @ 40 kbps");
        mAdapter.addItem("http://devimages.apple.com.edgekey.net/streaming/examples/bipbop_16x9/bipbop_16x9_variant.m3u8", "bipbop advanced master playlist");
        mAdapter.addItem("cronet://devimages.apple.com.edgekey.net/streaming/examples/bipbop_16x9/bipbop_16x9_variant.m3u8", "bipbop advanced master playlist");
        mAdapter.addItem("http://devimages.apple.com.edgekey.net/streaming/examples/bipbop_16x9/gear1/prog_index.m3u8", "bipbop advanced 416x234 @ 265 kbps");
        mAdapter.addItem("cronet://devimages.apple.com.edgekey.net/streaming/examples/bipbop_16x9/gear1/prog_index.m3u8", "bipbop advanced 416x234 @ 265 kbps");
        mAdapter.addItem("http://devimages.apple.com.edgekey.net/streaming/examples/bipbop_16x9/gear2/prog_index.m3u8", "bipbop advanced 640x360 @ 580 kbps");
        mAdapter.addItem("cronet://devimages.apple.com.edgekey.net/streaming/examples/bipbop_16x9/gear2/prog_index.m3u8", "bipbop advanced 640x360 @ 580 kbps");
        mAdapter.addItem("http://devimages.apple.com.edgekey.net/streaming/examples/bipbop_16x9/gear3/prog_index.m3u8", "bipbop advanced 960x540 @ 910 kbps");
        mAdapter.addItem("cronet://devimages.apple.com.edgekey.net/streaming/examples/bipbop_16x9/gear3/prog_index.m3u8", "bipbop advanced 960x540 @ 910 kbps");
        mAdapter.addItem("http://devimages.apple.com.edgekey.net/streaming/examples/bipbop_16x9/gear4/prog_index.m3u8", "bipbop advanced 1289x720 @ 1 Mbps");
        mAdapter.addItem("cronet://devimages.apple.com.edgekey.net/streaming/examples/bipbop_16x9/gear4/prog_index.m3u8", "bipbop advanced 1289x720 @ 1 Mbps");
        mAdapter.addItem("http://devimages.apple.com.edgekey.net/streaming/examples/bipbop_16x9/gear5/prog_index.m3u8", "bipbop advanced 1920x1080 @ 2 Mbps");
        mAdapter.addItem("cronet://devimages.apple.com.edgekey.net/streaming/examples/bipbop_16x9/gear5/prog_index.m3u8", "bipbop advanced 1920x1080 @ 2 Mbps");
        mAdapter.addItem("http://devimages.apple.com.edgekey.net/streaming/examples/bipbop_16x9/gear0/prog_index.m3u8", "bipbop advanced 22.050Hz stereo @ 40 kbps");
        mAdapter.addItem("cronet://devimages.apple.com.edgekey.net/streaming/examples/bipbop_16x9/gear0/prog_index.m3u8", "bipbop advanced 22.050Hz stereo @ 40 kbps");
        mAdapter.addItem("http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4", "big_buck_bunny.mp4");
        mAdapter.addItem("cronet://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4", "big_buck_bunny.mp4");
        mAdapter.addItem("http://vjs.zencdn.net/v/oceans.mp4", "oceans.mp4");
        mAdapter.addItem("cronet://vjs.zencdn.net/v/oceans.mp4", "oceans.mp4");

    }

    final class SampleMediaItem {
        String mUrl;
        String mName;

        public SampleMediaItem(String url, String name) {
            mUrl = url;
            mName = name;
        }
    }

    final class SampleMediaAdapter extends ArrayAdapter<SampleMediaItem> {
        public SampleMediaAdapter(Context context) {
            super(context, android.R.layout.simple_list_item_2);
        }

        public void addItem(String url, String name) {
            add(new SampleMediaItem(url, name));
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = convertView;
            if (view == null) {
                LayoutInflater inflater = LayoutInflater.from(parent.getContext());
                view = inflater.inflate(android.R.layout.simple_list_item_2, parent, false);
            }

            ViewHolder viewHolder = (ViewHolder) view.getTag();
            if (viewHolder == null) {
                viewHolder = new ViewHolder();
                viewHolder.mNameTextView = (TextView) view.findViewById(android.R.id.text1);
                viewHolder.mUrlTextView = (TextView) view.findViewById(android.R.id.text2);
            }

            SampleMediaItem item = getItem(position);
            viewHolder.mNameTextView.setText(item.mName);
//            viewHolder.mUrlTextView.setText(item.mUrl);

            String strText = item.mUrl.substring(0, item.mUrl.indexOf("://"));
            strText = "<" + strText + ">";
//            viewHolder.mUrlTextView.setText(item.mUrl);
            viewHolder.mUrlTextView.setText(strText);

            return view;
        }

        final class ViewHolder {
            public TextView mNameTextView;
            public TextView mUrlTextView;
        }
    }
}
