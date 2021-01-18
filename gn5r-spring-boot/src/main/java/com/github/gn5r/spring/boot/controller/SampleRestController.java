package com.github.gn5r.spring.boot.controller;

import com.github.gn5r.spring.boot.resource.ErrorResource;
import com.github.gn5r.spring.boot.resource.SampleResource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "sample")
@CrossOrigin
@Api(tags = "サンプルRESTコントローラー")
public class SampleRestController {

    @ApiOperation(value = "Hello World", notes = "Hello Worldを返却する")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "正常に取得しました", response = String.class, responseContainer = "Map") })
    @GetMapping("hello")
    public ResponseEntity<?> hello() {
        return new ResponseEntity<String>("Hello World", HttpStatus.OK);
    }

    @ApiOperation(value = "Validation", notes = "バイト数バリデートを実行します")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "正常に取得しました", response = String.class, responseContainer = "Map"),
            @ApiResponse(code = 400, message = "バリデーションエラー", response = ErrorResource.class, responseContainer = "Map") })
    @PostMapping("validate")
    public ResponseEntity<?> validate(@ApiParam(value = "サンプルリソース") @RequestBody @Validated SampleResource form,
            BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            ErrorResource error = new ErrorResource();
            error.setStatus(HttpStatus.BAD_REQUEST);
            error.setMessage("バリデーションエラー");
            error.setFieldErrors(bindingResult.getFieldErrors());
            return new ResponseEntity<ErrorResource>(error, error.getStatus());
        }

        return new ResponseEntity<String>(form.getText(), HttpStatus.OK);
    }
}
