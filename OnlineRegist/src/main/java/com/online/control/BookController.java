package com.online.control;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.online.model.Book;
import com.online.service.BookService;
import com.online.util.DateUtil;
import com.online.util.Message;

/**
 * @author chuankun
 *@2016年5月15日 下午2:56:29
 * email:yichuankun@qq.com
 */
@Controller
@RequestMapping("/book")
public class BookController {
	@Resource
	private BookService bookService;
	
	@RequestMapping("/addBook")
	@ResponseBody
	public Object addBook(Book record){
		if(record.getSchedulingId()==null||record.getUserId()==null){
			return Message.getMessageParmNull();
		}
		if(record.getState()==null){
			record.setState("1");
		}
		record.setBookTime(DateUtil.getDate() );
		int count = bookService.addBook(record);
		if(count==1){
			return Message.getMessage(2, "", "");
		}
		else if(count==2){
			return Message.getMessage(0, "scheduling 表为空！", "");
		}
		return Message.getMessage();
	}
	@RequestMapping("/setBook")
	@ResponseBody
	public Object setBook(Integer bookId,Integer type){ //1取消订单，2支付成功
		if(bookId==null||type==null){
			return Message.getMessageParmNull();
		}
		int count = bookService.setBook(bookId, type);
		if(count==1){
			return Message.getMessage(0, "book表为空！", "");
		}
		return Message.getMessage();
	}
	@RequestMapping("/getBooks")
	@ResponseBody
	public Object getBooks(Integer userId){
		if(userId==null){
			return Message.getMessageParmNull();
		}
		return Message.getMessage(bookService.getBook(userId));
	}

}
