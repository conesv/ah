package com.cbs.banking.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.cbs.banking.model.OrderInfo;

public interface OrderRepository extends JpaRepository<OrderInfo, Long> {

	@Query("select o from OrderInfo o where upper(o.status)=upper(?1)")
	List<OrderInfo> fetchOrdersByStatus(String string);

	@Modifying
	@Transactional
	@Query("update OrderInfo o set o.status=?2 where o.id=?1")
	void changeStatus(long orderId, String string);

}
