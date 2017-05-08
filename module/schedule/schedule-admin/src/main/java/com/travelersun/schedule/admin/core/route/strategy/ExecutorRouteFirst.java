package com.travelersun.schedule.admin.core.route.strategy;



import com.travelersun.schedule.admin.core.route.ExecutorRouter;

import java.util.ArrayList;

/**
 * Created by xuxueli on 17/3/10.
 */
public class ExecutorRouteFirst extends ExecutorRouter {

    @Override
    public String route(int jobId, ArrayList<String> addressList) {
        return addressList.get(0);
    }

}
