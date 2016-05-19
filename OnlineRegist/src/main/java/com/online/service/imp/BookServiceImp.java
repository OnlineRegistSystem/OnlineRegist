package com.online.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.online.dao.BookMapper;
import com.online.dao.SchedulingMapper;
import com.online.model.Book;
import com.online.model.Scheduling;
import com.online.service.BookService;

/**
 * @author chuankun
 *@2016年5月15日 下午2:38:06
 * email:yichuankun@qq.com
 */
@Service
public class BookServiceImp implements BookService{
	
	@Resource
	private BookMapper bookMapper;
	@Resource
	private SchedulingMapper schedulingMapper;

	public int addBook(Book record) {
		// TODO Auto-generated method stub
		Scheduling sche = schedulingMapper.selectByPrimaryKey(record.getSchedulingId());
		if(sche!=null){
			if(sche.getState().equalsIgnoreCase("1")){ //可预约
			int count = bookMapper.selectNumberOfScheduling(record.getSchedulingId());
			bookMapper.insert(record);
			if(count==	Integer.valueOf(sche.getNumber())-1){//刚好只剩最后一个名额
				sche.setState("2");
				schedulingMapper.updateByPrimaryKey(sche);
			} 
			return 0;
			}
			else{ //已满
				return 1;
			}
			}else{ //scheduling 表没有数据
				return 2;
			}
		
		
	}

	/* (non-Javadoc)
	 * 改变订单状态，type 1 取消，2 支付成功
	 * @see com.online.service.BookService#setBook(java.lang.Integer, int)
	 */
	public int setBook(Integer bookId, int type) {
		// TODO Auto-generated method stub
		
		Book record = bookMapper.selectByPrimaryKey(bookId);
		if(record!=null){
			record.setState(type+"");
			bookMapper.updateByPrimaryKey(record); 
			if(type==1){
				Scheduling sche = schedulingMapper.selectByPrimaryKey(record.getSchedulingId());
				if(sche.getState().equalsIgnoreCase("2")){
					sche.setState("1");
					schedulingMapper.updateByPrimaryKey(sche);
				}
			}
			return 0;
		}
		return 1;
	}

	public List getBook(Integer userId) {
		// TODO Auto-generated method stub
		return bookMapper.selectByUserId(userId);
	}

}
