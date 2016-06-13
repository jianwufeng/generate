package com.hunter.crm.dao;

import java.util.List;
import com.hunter.crm.domain.CityDO;
import com.hunter.crm.exception.DAOException;


 /**
 *  DAO
 * @author haisheng.Long 2016-06-02 10:49:37
 */
public interface CityDAO {

	/**
	 * 插入  
	 * @param cityDO
	 * @return 主键
	 * @throws DAOException
	 * @author longhaisheng 2016-06-02 10:49:37
	 */
	Long insert(CityDO cityDO) throws DAOException;

	/**
	 * 根据ID更新 全部属性
	 * @param cityDO
	 * @return 更新行数
	 * @throws DAOException
	 * @author longhaisheng 2016-06-02 10:49:37
	 */
	Integer update(CityDO cityDO) throws DAOException;

	/**
	 * 根据ID删除 
	 * @param id
	 * @return 删除行数
	 * @throws DAOException
	 * @author longhaisheng 2016-06-02 10:49:37
	 */
	Integer deleteById(Long id) throws DAOException;

	/**
	 * 动态更新 部分属性，包括全部
	 * @param cityDO
	 * @return 更新行数
	 * @throws DAOException
	 * @author longhaisheng 2016-06-02 10:49:37
	 */
	Integer updateDynamic(CityDO cityDO) throws DAOException;

	/**
	 * 根据ID查询 一个 
	 * @param id
	 * @return CityDO
	 * @throws DAOException
	 * @author longhaisheng 2016-06-02 10:49:37
	 */
	CityDO selectById(Long id) throws DAOException;

	/**
	 * 根据   动态返回记录数
	 * @param cityDO
	 * @return 记录条数
	 * @throws DAOException
	 * @author longhaisheng 2016-06-02 10:49:37
	 */
	Long selectCountDynamic(CityDO cityDO) throws DAOException;

	/**
	 * 根据   动态返回  列表
	 * @param cityDO
	 * @return List<CityDO>
	 * @throws DAOException
	 * @author longhaisheng 2016-06-02 10:49:37
	 */
	List<CityDO> selectDynamic(CityDO cityDO) throws DAOException;

	/**
	 * 根据   动态返回  Limit 列表
	 * @param cityDO start,pageSize属性必须指定
	 * @return List<CityDO>
	 * @throws DAOException
	 * @author longhaisheng 2016-06-02 10:49:37
	 */
	List<CityDO> selectDynamicPageQuery(CityDO cityDO) throws DAOException;
}
