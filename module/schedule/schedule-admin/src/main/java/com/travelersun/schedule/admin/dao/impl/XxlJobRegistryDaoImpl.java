package com.travelersun.schedule.admin.dao.impl;


import com.travelersun.schedule.admin.core.model.XxlJobRegistry;
import com.travelersun.schedule.admin.dao.IXxlJobRegistryDao;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xuxueli on 16/9/30.
 */
@Repository
@Transactional
public class XxlJobRegistryDaoImpl implements IXxlJobRegistryDao {

    @Resource
    public SqlSessionTemplate sqlSessionTemplate;

    @Override
    public int removeDead(int timeout) {
        return sqlSessionTemplate.delete("XxlJobRegistryMapper.removeDead", timeout);
    }

    @Override
    public List<XxlJobRegistry> findAll(int timeout) {
        return sqlSessionTemplate.selectList("XxlJobRegistryMapper.findAll", timeout);
    }

    @Override
    public int registryUpdate(String registryGroup, String registryKey, String registryValue) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("registryGroup", registryGroup);
        params.put("registryKey", registryKey);
        params.put("registryValue", registryValue);

        return sqlSessionTemplate.update("XxlJobRegistryMapper.registryUpdate", params);
    }

    @Override
    public int registrySave(String registryGroup, String registryKey, String registryValue) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("registryGroup", registryGroup);
        params.put("registryKey", registryKey);
        params.put("registryValue", registryValue);

        return sqlSessionTemplate.update("XxlJobRegistryMapper.registrySave", params);
    }

}
