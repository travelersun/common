package com.travelersun.schedule.admin.dao;



import com.travelersun.schedule.admin.core.model.XxlJobLog;

import java.util.Date;
import java.util.List;

/**
 * job log
 * @author xuxueli 2016-1-12 18:03:06
 */
public interface IXxlJobLogDao {
	
	public List<XxlJobLog> pageList(int offset, int pagesize, int jobGroup, int jobId, Date triggerTimeStart, Date triggerTimeEnd);
	public int pageListCount(int offset, int pagesize, int jobGroup, int jobId, Date triggerTimeStart, Date triggerTimeEnd);
	
	public XxlJobLog load(int id);

	public int save(XxlJobLog xxlJobLog);

	public int updateTriggerInfo(XxlJobLog xxlJobLog);

	public int updateHandleInfo(XxlJobLog xxlJobLog);
	
	public int delete(int jobId);
	
}
