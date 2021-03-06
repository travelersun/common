package com.travelersun.schedule.core.thread;


import com.travelersun.schedule.core.biz.AdminBiz;
import com.travelersun.schedule.core.biz.model.HandleCallbackParam;
import com.travelersun.schedule.core.biz.model.ReturnT;
import com.travelersun.schedule.core.rpc.netcom.NetComClientProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by xuxueli on 16/7/22.
 */
public class TriggerCallbackThread {
    private static Logger logger = LoggerFactory.getLogger(TriggerCallbackThread.class);

    private static TriggerCallbackThread instance = new TriggerCallbackThread();
    public static TriggerCallbackThread getInstance(){
        return instance;
    }

    private LinkedBlockingQueue<HandleCallbackParam> callBackQueue = new LinkedBlockingQueue<HandleCallbackParam>();

    private Thread triggerCallbackThread;
    private boolean toStop = false;
    public void start() {
        triggerCallbackThread = new Thread(new Runnable() {

            @Override
            public void run() {
                while(!toStop){
                    try {
                        HandleCallbackParam callback = getInstance().callBackQueue.take();
                        if (callback != null) {
                            for (String address : callback.getLogAddress()) {
                                try {
                                    // callback
                                    AdminBiz adminBiz = (AdminBiz) new NetComClientProxy(AdminBiz.class, address).getObject();
                                    ReturnT<String> callbackResult = adminBiz.callback(callback);

                                    logger.info(">>>>>>>>>>> xxl-job callback , CallbackParam:{}, callbackResult:{}", new Object[]{callback.toString(), callbackResult.toString()});
                                    if (ReturnT.SUCCESS_CODE == callbackResult.getCode()) {
                                        break;
                                    }
                                } catch (Exception e) {
                                    logger.error(">>>>>>>>>>> xxl-job TriggerCallbackThread Exception:", e);
                                }
                            }
                        }
                    } catch (Exception e) {
                        logger.error("", e);
                    }
                }
            }
        });
        triggerCallbackThread.setDaemon(true);
        triggerCallbackThread.start();
    }
    public void toStop(){
        toStop = true;
    }

    public static void pushCallBack(HandleCallbackParam callback){
        getInstance().callBackQueue.add(callback);
        logger.debug(">>>>>>>>>>> xxl-job, push callback request, logId:{}", callback.getLogId());
    }

}
