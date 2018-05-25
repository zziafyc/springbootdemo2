package com.zhongyong.springbootdemo2.base;

import com.github.pagehelper.PageHelper;

import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

/**
 * baseMapper被封装到了service层，他是继承Mapper的
 *
 * @param <T>
 */
public class BaseServiceImpl<T> implements BaseService<T> {
    @Autowired
    protected Mapper<T> baseMapper;

    private Class<?> clazz = null;

    protected Class<?> getEntityClass() {
        if (clazz == null) {
            clazz = (Class<?>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        }
        return clazz;
    }

    @Override
    public List<T> getAll() {
        return baseMapper.selectAll();
    }

    @Override
    public int insert(T entity) {
        return baseMapper.insert(entity);
    }

    @Override
    public int insertSelective(T entity) {
        return baseMapper.insertSelective(entity);
    }

    @Override
    public int updateByPrimaryKey(T entity) {
        return baseMapper.updateByPrimaryKey(entity);
    }

    @Override
    public int updateByPrimaryKeySelective(T entity) {
        return baseMapper.updateByPrimaryKeySelective(entity);
    }

    @Override
    public int deleteByPrimaryKey(Object primaryKey) {
        return baseMapper.deleteByPrimaryKey(primaryKey);
    }

    @Override
    public int deleteByPrimaryKeys(List<Object> primaryKeys) {
        int result = 0;
        for (Object primaryKey : primaryKeys) {
            result += baseMapper.deleteByPrimaryKey(primaryKey);
        }
        return result;
    }

    @Override
    public int deleteByField(String field, String value) {
        return deleteByFields(new String[]{field}, new String[]{value});
    }

    @Override
    public int deleteByFields(String[] fields, String[] values) {
        if (null == fields || null == values || fields.length == 0 || fields.length != values.length) {
            return 0;
        }
        Example example = new Example(getEntityClass());
        Criteria criteria = example.createCriteria();
        for (int i = 0; i < fields.length; i++) {
            criteria.andEqualTo(fields[i], values[i]);
        }
        return baseMapper.deleteByExample(example);
    }

    @Override
    public T selectOne(T entity) {
        return baseMapper.selectOne(entity);
    }

    @Override
    public T selectByPrimaryKey(Object primaryKey) {
        return baseMapper.selectByPrimaryKey(primaryKey);
    }

    @Override
    public List<T> selectPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return baseMapper.selectAll();
    }

    @Override
    public List<T> selectByField(String field, String value, int pageNum, int pageSize) {
        return selectByFields(new String[]{field}, new String[]{value}, pageNum, pageSize);
    }

    @Override
    public List<T> selectByFields(String[] fields, String[] values, int pageNum, int pageSize) {
        if (null == fields || null == values || fields.length == 0 || fields.length != values.length) {
            return null;
        }
        Example example = new Example(getEntityClass());
        for (int i = 0; i < fields.length; i++) {
            // String keyword = StringUtil.keywords(values[i]);
            example.or().andLike(fields[i], values[i]);
        }
        PageHelper.startPage(pageNum, pageSize);
        return baseMapper.selectByExample(example);
    }

    @Override
    public List<T> selectByEqField(String field, String value, int pageNum, int pageSize) {
        return selectByEqFields(new String[]{field}, new String[]{value}, pageNum, pageSize);
    }

    @Override
    public List<T> selectByEqFields(String[] fields, String[] values, int pageNum, int pageSize) {
        if (null == fields || null == values || fields.length == 0 || fields.length != values.length) {
            return null;
        }
        Example example = new Example(getEntityClass());
        Criteria criteria = example.createCriteria();
        for (int i = 0; i < fields.length; i++) {
            criteria.andEqualTo(fields[i], values[i]);
        }
        PageHelper.startPage(pageNum, pageSize);
        return baseMapper.selectByExample(example);
    }
}