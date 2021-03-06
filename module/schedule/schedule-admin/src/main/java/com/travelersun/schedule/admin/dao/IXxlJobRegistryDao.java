package com.travelersun.schedule.admin.dao;



import com.travelersun.schedule.admin.core.model.XxlJobRegistry;

import java.util.List;

/**
 * Created by xuxueli on 16/9/30.
 */
public interface IXxlJobRegistryDao {
    public int removeDead(int timeout);

    public List<XxlJobRegistry> findAll(int timeout);

    public int registryUpdate(String registryGroup, String registryKey, String registryValue);

    public int registrySave(String registryGroup, String registryKey, String registryValue);

}
