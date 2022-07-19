package com.demo.spring.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.demo.spring.AddressRepository;
import com.demo.spring.ItemRepository;
import com.demo.spring.OrderRepository;
import com.demo.spring.entity.LineItem;
import com.demo.spring.entity.Order;

@RestController
public class OrderRestController {

	@Autowired
	RestTemplate rt;
	
	@Autowired
	OrderRepository repo;
	
	@Autowired
	ItemRepository repo1;
	
	@Autowired
	AddressRepository repo2;
	
	@GetMapping("/order/{id}")
	public ResponseEntity findId(@PathVariable int id) {
		Optional<Order> orderop = repo.findById(id);
		if (orderop.isPresent()) {
			return ResponseEntity.ok(orderop.get());
		} else {
			return ResponseEntity.status(404).body("{\"status\":\"Order with id not found\"}");
		}
	}
	
	@PostMapping(path = "/save",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> addOrder(@RequestBody Order o) {
		if (repo.existsById(o.getOrderId())) {
			return ResponseEntity.ok("{\"status\":\"Order already exists\"}");
		} else {
			repo.save(o);
			return ResponseEntity.ok("{\"status\":\"Order saved\"}");
		}
	}
	
	@GetMapping(path = "/order/get",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Order>> getList() {
		return ResponseEntity.ok(repo.findAll());
	}
	
	@PostMapping(path = "/saveitem/{id}",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> addItem(@RequestBody LineItem item, @PathVariable int id) {
		if (repo.existsById(item.getItemId())) {
			return ResponseEntity.ok("{\"status\":\"Item already exists\"}");
		} else {
			
			  ResponseEntity<Order> resorder = rt.getForEntity("http://localhost:8380/order/"+id, Order.class);
			  System.out.println(resorder.getBody());
			  item.setOrders(resorder.getBody());
			repo1.save(item);
			return ResponseEntity.ok("{\"status\":\"Item saved\"}");
		}
	}
	
	@PutMapping(value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> updateOrder(@RequestBody Order o) {
		if (repo.existsById(o.getOrderId())) {
			repo.save(o);
			return ResponseEntity.ok("{\"status\":\"Order updated\"}");
		} else {
			return ResponseEntity.status(404).body("{\"status\":\"Order with id not found\"}");
		}
	}
	
	@DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity deleteOrder(@PathVariable("id") int id) {
		if (repo.existsById(id)) {
			repo.deleteById(id);
			return ResponseEntity.ok("{\"status\":\"Order deleted\"}");
		} else {
			return ResponseEntity.status(404).body("{\"status\":\"Order with id not found\"}");
		}
	}
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> getException(Exception ex) {
		return ResponseEntity.ok(ex.getMessage());
	}
}
