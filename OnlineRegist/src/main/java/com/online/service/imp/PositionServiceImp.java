package com.online.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.online.dao.PositionMapper;
import com.online.service.PositionService;

/**
 * @author chuankun   email:yichuankun@qq.com
 * 2016年4月22日 下午3:41:03
 *	TODO
 */
@Service
public class PositionServiceImp implements PositionService{

	@Resource
	private PositionMapper positionMapper;
	public List getPosition() {
		// TODO Auto-generated method stub
		return positionMapper.selectAll();
	}

}
