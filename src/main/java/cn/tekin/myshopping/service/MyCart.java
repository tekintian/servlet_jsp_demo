package cn.tekin.myshopping.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import cn.tekin.myshopping.domain.Book;

/**
 * 
 * 这个表示是我的购物车
 *
 */
public class MyCart {
	HashMap<String, Book> hm=new HashMap<String, Book>();
	
	//添加书
	public void addBook(String id){
		if (hm.containsKey(id)) {
			Book book=hm.get(id);
			book.setShoppingNum(book.getShoppingNum()+1);
		}else{
			hm.put(id, new BookService().getBookById(id));
		}
		
	}
		
	//删除书
	public void del(String id){
		hm.remove(id);
	}
	
	//更新书(对于购物车的更新)
	public void updateBook(String id,String nums){
		//取id对应的book
		Book book=hm.get(id);
		book.setShoppingNum(Integer.parseInt(nums));
	}
	
	//显示该购物车中的所有商品信息
	public ArrayList showMyCart(){
		ArrayList al=new ArrayList();
		//遍历Hashmap
		Iterator itertor=hm.keySet().iterator();
		while(itertor.hasNext()){
			//取出Key
			String key=(String) itertor.next();
			//取出book
			Book book=hm.get(key);
			al.add(book);
		}
		
		return al;
	}
	
	
	public float getTotalPrice()
	{
		//得到总价
		float toltalPrice=0.0f;
		Iterator iterator=hm.keySet().iterator();
		while(iterator.hasNext()){
			//取出书号
			String bookid=(String) iterator.next();
			//取出对应的值
			Book book=hm.get(bookid);
			
			toltalPrice+=book.getPrice()*book.getShoppingNum();
		}
		return toltalPrice;
	}
	//清空购物车
	public void clearBook(){
		hm.clear();
	}
	
}
