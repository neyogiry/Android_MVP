package neyogiry.app.demo.android_mvp_simple_example;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by Neyogiry
 */
public class TimePresenter implements TimeInterfaces.Presenter, TimeInterfaces.Model{

    private TimeInterfaces.View mView;
    private TimeModel mModel;



    public TimePresenter(TimeInterfaces.View timeView) {
        this.mView = timeView;
        this.mModel = new TimeModel();
    }


    @Override
    public void loadTimes(ArrayList<String> timeList) {
        mView.showTimes(timeList);
    }

    @Override
    public void addTime() {
        String time = TimeCurrent();
        mModel.saveTime(time, this);
    }

    private String TimeCurrent() {
        String timeCurrent;
        Calendar calendar = Calendar.getInstance();
        timeCurrent = calendar.getTime().toString();
        return timeCurrent;
    }

    @Override
    public void onResponse(ArrayList<String> timeList) {
        loadTimes(timeList);
    }

    @Override
    public void onError(String error) {
        mView.showError(error);
    }
}
