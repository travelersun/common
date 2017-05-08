package com.travelersun.schedule.core.biz;


import com.travelersun.schedule.core.biz.model.ReturnT;
import com.travelersun.schedule.core.biz.model.TriggerParam;

/**
 * Created by xuxueli on 17/3/1.
 */
public interface ExecutorBiz {

    /**
     * beat
     * @return
     */
    public ReturnT<String> beat();

    /**
     * kill
     * @param jobId
     * @return
     */
    public ReturnT<String> kill(int jobId);

    /**
     * log
     * @param logDateTim
     * @param logId
     * @return
     */
    public ReturnT<String> log(long logDateTim, int logId);

    /**
     * run
     * @param triggerParam
     * @return
     */
    public ReturnT<String> run(TriggerParam triggerParam);

}
