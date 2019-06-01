package com.chirkevich.nikola.stackoverflow.ui.sites_page.adapters.wrappers;

import android.content.Context;
import android.media.Image;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.chirkevich.nikola.domain.models.sites.SiteItem;
import com.chirkevich.nikola.stackoverflow.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SiteItemWrapper {

    @BindView(R.id.icon_iv)
    ImageView iconIv;

    @BindView(R.id.name_tv)
    TextView nameTv;

    private View view;


    public SiteItemWrapper(View view) {
        ButterKnife.bind(this, view);
        this.view = view;
    }

    public void bind(SiteItem siteItem) {
        Glide.with(view).load(siteItem.getIconUrl()).into(iconIv);
        nameTv.setText(siteItem.getName());
    }
}
