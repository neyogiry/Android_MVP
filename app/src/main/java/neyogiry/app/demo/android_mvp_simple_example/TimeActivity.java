package neyogiry.app.demo.android_mvp_simple_example;

import android.content.Context;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class TimeActivity extends AppCompatActivity implements TimeInterfaces.View {

    private TimeInterfaces.Presenter mPresenter;

    private RecyclerView recyclerView;
    private FloatingActionButton fab;
    private TimesAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);
        mPresenter = new TimePresenter(this);

        initialiteUI();
        setupRecyclerView();

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addTime();
            }
        });
    }

    private void initialiteUI() {
        recyclerView = (RecyclerView)findViewById(R.id.rv_time_list);
        fab = (FloatingActionButton)findViewById(R.id.fab_add_time);
    }

    private void setupRecyclerView(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    @Override
    public void showTimes(ArrayList<String> times) {
        mAdapter = new TimesAdapter(times);
        recyclerView.setAdapter(mAdapter);
    }

    @Override
    public void addTime() {
        mPresenter.addTime();
    }

    @Override
    public void showError(String error) {
        Log.e("TimeActivity", error);
    }

    private static class TimesAdapter extends RecyclerView.Adapter<TimesAdapter.ViewHolder>{

        private ArrayList<String> mTimes;

        public TimesAdapter(ArrayList<String> times) {
            this.mTimes = times;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            Context context = parent.getContext();
            LayoutInflater inflater = LayoutInflater.from(context);
            View timeView = inflater.inflate(R.layout.list_time, parent, false);
            return new ViewHolder(timeView);
    }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            String times = mTimes.get(position);
            holder.time.setText(times);
        }

        @Override
        public int getItemCount() {
            return mTimes.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder{
            private TextView time;

            public ViewHolder(View itemView) {
                super(itemView);
                time = (TextView)itemView.findViewById(R.id.txt_Time);
            }
        }

    }
}
