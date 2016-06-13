package com.hunter.crm.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.hunter.crm.dao.CityDAO;
import com.hunter.crm.domain.CityDO;
import com.hunter.crm.service.CityService;
import com.hunter.crm.exception.DAOException;
import com.hunter.crm.exception.ServiceException;
import com.hunter.crm.util.Page;

@Service(value="cityService")
public class CityServiceImpl  implements CityService{

	private Log logger = LogFactory.getLog(this.getClass());

	@Autowired
	private CityDAO cityDAO;

	@Override
	public Long insert(CityDO cityDO) throws ServiceException {
		try {
			return cityDAO.insert(cityDO);
		}catch(DAOException e){
			logger.error(e);
            throw new ServiceException(e);
		}
	}

//	@Override
//	public int updateById(CityDO cityDO) throws ServiceException {
//		try {
//			return (Integer) cityDAO.updateById(cityDO);
//		}catch(DAOException e){
//			logger.error(e);
//            throw new ServiceException(e);
//		}
//	}

	@Override
	public int update(CityDO cityDO,boolean isAllField) throws ServiceException {
		try {
			if(isAllField){
				return (Integer) cityDAO.update(cityDO);
			}else{
				return (Integer) cityDAO.updateDynamic(cityDO);
			}
		}catch(DAOException e){
			logger.error(e);
            throw new ServiceException(e);
		}
	}

	@Override
	public int deleteById(Long id) throws ServiceException {
		try {
			return (Integer) cityDAO.deleteById(id);
		}catch(DAOException e){
			logger.error(e);
            throw new ServiceException(e);
		}
	}

//	@Override
//	public int updateDynamic(CityDO cityDO) throws ServiceException {
//		try {
//			return (Integer) cityDAO.updateDynamic(cityDO);
//		}catch(DAOException e){
//			logger.error(e);
//            throw new ServiceException(e);
//		}
//	}

	@Override
	public CityDO selectById(Long id) throws ServiceException {
		try {
			return cityDAO.selectById(id);
		}catch(DAOException e){
			logger.error(e);
            throw new ServiceException(e);
		}
	}

	@Override
	public Long selectCountDynamic(CityDO cityDO) throws ServiceException {
		try {
			return cityDAO.selectCountDynamic(cityDO);
		}catch(DAOException e){
			logger.error(e);
            throw new ServiceException(e);
		}
	}

	@Override
	public List<CityDO> selectDynamic(CityDO cityDO) throws ServiceException {
		try {
			return cityDAO.selectDynamic(cityDO);
		}catch(DAOException e){
			logger.error(e);
            throw new ServiceException(e);
		}
	}
	

	private List<CityDO> selectDynamicPageQuery(CityDO cityDO) throws ServiceException {
		try {
			return cityDAO.selectDynamicPageQuery(cityDO);
		}catch(DAOException e){
			logger.error(e);
            throw new ServiceException(e);
		}
	}

	public Page<CityDO> queryPageListByCityDO(CityDO cityDO) {
		if (cityDO != null) {
			Long totalCount = this.selectCountDynamic(cityDO);
			List<CityDO> resultList = this.selectDynamicPageQuery(cityDO);

			Page<CityDO> page = new Page<CityDO>();
			page.setPageNo(cityDO.getStartPage());
			page.setPageSize(cityDO.getPageSize());
			page.setTotalCount(totalCount.intValue());
			page.setList(resultList);
			return page;
		}
		return new Page<CityDO>();
	}

	public Page<CityDO> queryPageListByCityDOAndStartPageSize(CityDO cityDO,int startPage,int pageSize){
		if (cityDO != null && startPage>0 && pageSize>0) {
			cityDO.setStartPage(startPage);
			cityDO.setPageSize(pageSize);
			return this.queryPageListByCityDO(cityDO);
		}
		return new Page<CityDO>();
	}

}
