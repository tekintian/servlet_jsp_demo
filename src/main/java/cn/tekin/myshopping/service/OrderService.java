package cn.tekin.myshopping.service;

import java.sql.*;
import java.util.ArrayList;

import cn.tekin.myshopping.domain.Book;
import cn.tekin.myshopping.domain.Users;
import cn.tekin.myshopping.utils.*;

//处理与订单相关的业务逻辑
public class OrderService {
	
	private Connection ct=null;
	private PreparedStatement ps=null;
	private ResultSet rs=null;
	
	
	//下单涉及到两张表
	public void submitOrder(MyCart myCart,Users user){
		
		String sql="insert into orders values(order_seq.nextval,?,?,sysdate)";
		//因为添加订单很复杂，因此我们不使用SQLHelper,而是专门针对下订单写对数据库的操作
		try {
			ct=DBUtil.getCon();
			//为了保证我们的订单号是稳定的，所以将我们的事务隔离级别升级（可串行）
			ct.setAutoCommit(false);
			ct.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
			
			ps=ct.prepareStatement(sql);
			ps.setInt(1, user.getId());
			ps.setFloat(2, myCart.getTotalPrice());
			ps.executeUpdate();
			//如何得到刚刚插入的订单记录的订单号	
			sql="select order_seq.currval from orders";//选择刚刚用的序列
			ps=ct.prepareStatement(sql);
			rs=ps.executeQuery();
			int orderId=0;
			if(rs.next()){
				
				
				//取出刚刚生成的订单号
				orderId=rs.getInt(1);
			}
				//把订单细节表生成（批量提交！！）
				ArrayList al=myCart.showMyCart();
				for(int i=0;i<al.size();i++){
					Book book=(Book)al.get(i);
					sql="insert into orderitem values(orderitem_seq.nextval,?,?,?)";
					ps=ct.prepareStatement(sql);
					ps.setInt(1, orderId);
					ps.setInt(2, book.getId());
					ps.setInt(3, book.getShoppingNum());
					ps.executeUpdate();
			}
			//整体提交
			ct.commit();
			
			
		} catch (Exception e) {
			
			//若失败，则回滚
			try {
				ct.rollback();
			} catch (SQLException e1) {
				// TODO 自动生成的 catch 块
				e1.printStackTrace();
				throw new RuntimeException(e.getMessage());
			}
			e.printStackTrace();
			// TODO: handle exception
		}finally{
			DBUtil.close(rs, ps, ct);
		}
		
		
		
	}
}
