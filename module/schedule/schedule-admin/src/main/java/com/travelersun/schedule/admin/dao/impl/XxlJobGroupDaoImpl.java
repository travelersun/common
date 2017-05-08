package com.travelersun.schedule.admin.dao.impl;


import com.travelersun.schedule.admin.core.model.XxlJobGroup;
import com.travelersun.schedule.admin.dao.IXxlJobGroupDao;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by xuxueli on 16/9/30.
 */
@Repository
@Transactional
public class XxlJobGroupDaoImpl implements IXxlJobGroupDao {

    @Resource
    public SqlSessionTemplate sqlSessionTemplate;

    @Override
    public List<XxlJobGroup> findAll() {
        return sqlSessionTemplate.selectList("XxlJobGroupMapper.findAll");
    }

    @Override
    public int save(XxlJobGroup xxlJobGroup) {
        return sqlSessionTemplate.update("XxlJobGroupMapper.save", xxlJobGroup);
    }

    @Override
    public int update(XxlJobGroup xxlJobGroup) {
        return sqlSessionTemplate.update("XxlJobGroupMapper.update", xxlJobGroup);
    }

    @Override
    public int remove(int id) {
        return sqlSessionTemplate.delete("XxlJobGroupMapper.remove", id);
    }

    @Override
    public XxlJobGroup load(int id) {
        return sqlSessionTemplate.selectOne("XxlJobGroupMapper.load", id);
    }


}
