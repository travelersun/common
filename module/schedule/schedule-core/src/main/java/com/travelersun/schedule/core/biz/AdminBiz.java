package com.travelersun.schedule.core.biz;


import com.travelersun.schedule.core.biz.model.HandleCallbackParam;
import com.travelersun.schedule.core.biz.model.ReturnT;

/**
 * Created by xuxueli on 17/3/1.
 */
public interface AdminBiz {

    public ReturnT<String> callback(HandleCallbackParam handleCallbackParam);

}
