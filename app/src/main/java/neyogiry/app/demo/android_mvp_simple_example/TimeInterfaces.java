package neyogiry.app.demo.android_mvp_simple_example;

import java.util.ArrayList;

/**
 * Created by Neyogiry
 */
public interface TimeInterfaces {

    interface View {
        void showTimes(ArrayList<String> times);
        void addTime();
        void showError(String error);
    }

    interface Presenter {
        void loadTimes(ArrayList<String> timeList);
        void addTime();
    }

    interface Model {
        void onResponse(ArrayList<String> timeList);
        void onError(String error);
    }


}
