package com.berliana.news_api.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Fade;
import android.transition.Slide;
import android.transition.TransitionInflater;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.berliana.news_api.R;
import com.berliana.news_api.model.Article;
import com.flaviofaria.kenburnsview.KenBurnsView;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by berlianalina on 5/14/18.
 */

public class DetailNewsActivity extends AppCompatActivity {

    @BindView(R.id.backdrop)
    KenBurnsView backdrop;
    @BindView(R.id.tv_date)
    TextView tv_date;
    @BindView(R.id.tv_title)
    TextView tv_title;
    @BindView(R.id.tv_source)
    TextView tv_source;
    @BindView(R.id.tv_description)
    TextView tv_description;
    @BindView(R.id.img_back)
    ImageView img_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_news);
        setUI();
    }

    private void setUI() {
        ButterKnife.bind(this);
        getExtrasFromIntent();
    }

    private void getExtrasFromIntent() {
        Article article = (Article) getIntent().getSerializableExtra("article");
        Picasso.get()
                .load(article.getUrlToImage())
                .into(backdrop);

        tv_date.setText(article.getPublishedAt());
        tv_source.setText(article.getSource().getName());
        tv_title.setText(article.getTitle());
        tv_description.setText(article.getDescription());
    }

    @OnClick(R.id.img_back)
    public void back() {
        onBackPressed();
    }
}
