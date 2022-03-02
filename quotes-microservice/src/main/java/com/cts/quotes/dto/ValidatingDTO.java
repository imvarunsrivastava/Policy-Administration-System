package com.cts.quotes.dto;

import org.springframework.stereotype.Component;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;


@ToString
@Component
@Data
public class ValidatingDTO {

	@JsonProperty
	private boolean validStatus;
}
