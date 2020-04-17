package com.internetbanking.app.customer.transaction.controller;

import javax.inject.Inject;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.internetbanking.app.customer.constant.InternateBankingAppConstant;
import com.internetbanking.app.customer.exception.TransactionHistoryNotFoundException;
import com.internetbanking.app.customer.service.CustomerService;
import com.internetbanking.app.customer.transaction.model.TransactionDetail;
import com.mongodb.lang.NonNull;

import static com.internetbanking.app.customer.constant.InternateBankingAppConstant.*;

import java.util.Optional;

@RestController
@RequestMapping(InternateBankingAppConstant.ROOT_APP_PATH)
public class TransactionHistoryController {
	@Inject
	CustomerService customerService;

	@GetMapping(TRANSACTION)
	public TransactionDetail getCustTransactionHistory(@NonNull @RequestParam("customerId") String customerId) {
		Optional<TransactionDetail> transactionDetail = Optional
				.of(customerService.getCustomerTransactionHistory(customerId));

		if (transactionDetail.isPresent()) {
			return transactionDetail.get();
		}
		throw new TransactionHistoryNotFoundException();
	}

	@PostMapping(TRANSACTION)
	public TransactionDetail creatTransactionHistory(@NonNull @RequestBody TransactionDetail transactionDetail) {
		Optional<TransactionDetail> transactionDetailRes = Optional
				.of(customerService.createCustomerTransactionHistory(transactionDetail));
		return transactionDetailRes.get();
	}

}
