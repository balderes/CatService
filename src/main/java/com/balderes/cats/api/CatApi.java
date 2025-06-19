package com.balderes.cats.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@SecurityRequirement(name = "Bearer_Authentication")
@Validated
@RequestMapping("/cats")
@Tag(name = "Кот Сервис")
public interface CatApi {

	@Operation(summary = "Получить кота", description = "Получить кота",
			responses = {
					@ApiResponse(responseCode = "200", description = "OK"),
					@ApiResponse(responseCode = "400", description = "BAD_REQUEST")
			}
	)
	@GetMapping("/cat")
	String getCat();


	@Operation(summary = "Добавить кота", description = "Добавить кота",
			parameters = {
					@Parameter(name = "name", in = ParameterIn.QUERY, schema = @Schema(type = "string"), example = "Tom", required = true),
					@Parameter(name = "age", in = ParameterIn.QUERY, schema = @Schema(type = "integer"), example = "1", required = true),
					@Parameter(name = "weight", in = ParameterIn.QUERY, schema = @Schema(type = "double"), example = "1.0", required = true)
			},
			responses = {
					@ApiResponse(responseCode = "200", description = "OK"),
					@ApiResponse(responseCode = "400", description = "BAD_REQUEST")
			}
	)
	@PostMapping ("/cat")
	String addCat(@RequestParam String name, @RequestParam Integer age, @RequestParam Double weight);
}

