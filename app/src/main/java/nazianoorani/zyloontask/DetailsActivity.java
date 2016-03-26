package nazianoorani.zyloontask;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import nazianoorani.zyloontask.dto.ItemDetailDto;

/**
 * Created by nazianoorani on 26/03/16.
 */

public class DetailsActivity extends AppCompatActivity {
    @InjectView(R.id.img_back_drop)
    ImageView imageBackDrop;
    @InjectView(R.id.collapsing_toolbar)
    CollapsingToolbarLayout collapsingToolbarLayout;
    @InjectView(R.id.toolbar)
    Toolbar toolbar;
    ItemDetailDto itemDetailDto;

    @InjectView(R.id.text_first)
    TextView textViewFirst;
    @InjectView(R.id.text_sec)
    TextView textViewSec;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        ButterKnife.inject(this);
        if (getIntent().hasExtra("itemDto")) {
            itemDetailDto = getIntent().getParcelableExtra("itemDto");
        }
        initView();
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    void initView(){
        textViewFirst.setText("User ratings "+itemDetailDto.getItemRating());
        imageBackDrop.setImageResource(itemDetailDto.getItemImage());
        collapsingToolbarLayout.setTitle(itemDetailDto.getItemName());

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case android.R.id.home:
                onBackPressed();
                break;
        }
        return true;
    }
}
