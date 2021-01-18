package com.github.gn5r.spring.boot.resource;

import com.github.gn5r.spring.boot.validation.annotation.ByteSize;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "サンプルリソース", description = "サンプルリソースです")
public class SampleResource {

    @ByteSize(min = 0, max = 10)
    @ApiModelProperty(value = "テキスト")
    private String text;
}
