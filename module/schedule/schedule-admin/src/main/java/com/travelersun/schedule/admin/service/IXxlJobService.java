package com.travelersun.schedule.admin.service;




import com.travelersun.schedule.admin.core.model.XxlJobInfo;
import com.travelersun.schedule.core.biz.model.ReturnT;

import java.util.Map;

/**
 * core job action for xxl-job
 * 
 * @author xuxueli 2016-5-28 15:30:33
 */
public interface IXxlJobService {
	
	public Map<String, Object> pageList(int start, int length, int jobGroup, String executorHandler, String filterTime);
	
	public ReturnT<String> add(XxlJobInfo jobInfo);
	
	public ReturnT<String> reschedule(XxlJobInfo jobInfo);
	
	public ReturnT<String> remove(int id);
	
	public ReturnT<String> pause(int id);
	
	public ReturnT<String> resume(int id);
	
	public ReturnT<String> triggerJob(int id);
	
}
