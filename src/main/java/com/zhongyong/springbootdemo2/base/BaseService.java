package com.zhongyong.springbootdemo2.base;

import java.util.List;

public interface BaseService<T> {

    List<T> getAll();

    int insert(T entity);

    /**
     * 添加非空值，null不会被保存，使用数据库默认值
     *
     * @param entity
     * @return
     */
    int insertSelective(T entity);

    int updateByPrimaryKey(T entity);

    int updateByPrimaryKeySelective(T entity);

    int deleteByPrimaryKey(Object primaryKey);

    int deleteByPrimaryKeys(List<Object> primarykeys);

    /**
     * 根据指定字段值删除，判断条件为等号
     *
     * @param field
     * @param value
     * @return
     */
    int deleteByField(String field, String value);

    int deleteByFields(String[] fields, String[] values);

    /**
     * 根据实体中的属性进行查询，只能有一个返回值，有多个结果是抛出异常，查询条件使用等号
     *
     * @param entity
     * @return
     */
    T selectOne(T entity);

    T selectByPrimaryKey(Object primaryKey);

    /**
     * 单表分页查询
     * <p>
     * <pre>
     * selectPage(0,0) return all
     * </pre>
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<T> selectPage(int pageNum, int pageSize);

    /**
     * 根据指定字段值模糊分页查询
     *
     * @param field
     * @param value
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<T> selectByField(String field, String value, int pageNum, int pageSize);

    List<T> selectByFields(String[] fields, String[] values, int pageNum, int pageSize);

    /**
     * 根据指定字段值分页查询
     *
     * @param field
     * @param value
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<T> selectByEqField(String field, String value, int pageNum, int pageSize);

    List<T> selectByEqFields(String[] fields, String[] values, int pageNum, int pageSize);
}