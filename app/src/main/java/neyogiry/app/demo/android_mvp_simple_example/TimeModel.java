package neyogiry.app.demo.android_mvp_simple_example;

import java.util.ArrayList;

/**
 * Created by Neyogiry
 */
public class TimeModel{

    ArrayList<String> mTimes = new ArrayList<>();

    public TimeModel() {
    }

    public void saveTime(String time, TimeInterfaces.Model timeCallback) {
        try{
            mTimes.add(time);
            onSucces(timeCallback);
        }catch (Exception e){
            onError(timeCallback, e.toString());
        }
    }

    public void onSucces(TimeInterfaces.Model timeCallback) {
        timeCallback.onResponse(mTimes);
    }

    public void onError(TimeInterfaces.Model timeCallback, String error) {
        timeCallback.onError(error);
    }

}
