package com.llg.chatweather.viewmodel;

import android.databinding.ObservableField;

import com.llg.chatweather.BaseActivity;
import com.llg.chatweather.bean.BaseBean;
import com.llg.chatweather.bean.NowResultsBean;
import com.llg.chatweather.model.WeatherDataInterface;
import com.llg.chatweather.model.WeatherModel;

/**
 * create by loogen on 2019-3-28
 */
public class WeatherViewModel implements WeatherDataInterface {
    public final ObservableField<String> city = new ObservableField<>("-- --");
    public final ObservableField<String> temperature = new ObservableField<>("NaN");
    private WeatherModel model;

    private BaseActivity mActivity;

    public WeatherViewModel(BaseActivity activity){
        mActivity = activity;
        model = new WeatherModel(mActivity);
        model.setmWeatherDataInterface(this);
        requestData();
    }

    private void requestData() {
        model.getNowWeatherData("zhuhai","en","");
    }

    @Override
    public void showNowWeatherData(BaseBean<NowResultsBean> bean) {
        city.set(bean.getResults().get(0).getLocation().getName());
        temperature.set(bean.getResults().get(0).getNow().getTemperature());
    }

    @Override
    public void refreshError(String msg) {

    }
}