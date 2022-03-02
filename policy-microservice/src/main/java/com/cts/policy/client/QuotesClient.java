package com.cts.policy.client;

import javax.validation.Valid;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.cts.policy.payload.request.QuotesRequest;

@FeignClient(name="QUOTES-MICROSERVICE")
public interface QuotesClient {

	@PostMapping("/getQuotesForPolicy")
	public String getQuotesForPolicy(@Valid @RequestBody QuotesRequest quotesRequest);
}
