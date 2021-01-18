package com.github.gn5r.spring.boot.resource;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "エラーリソース", description = "エラーが発生した場合に返却されます")
public class ErrorResource {
    
    @ApiModelProperty(value = "ステータスコード")
    private HttpStatus status;

    @ApiModelProperty(value = "エラーメッセージ")
    private String message;

    @ApiModelProperty(value = "バリデーションエラーリスト")
    private List<FieldError> fieldErrors;
}
