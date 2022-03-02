package com.cts.policy.dto;

import org.springframework.stereotype.Component;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;



@Component
@ToString
@Data
public class ValidatingDTO {

	@JsonProperty
	private boolean validStatus;
}
