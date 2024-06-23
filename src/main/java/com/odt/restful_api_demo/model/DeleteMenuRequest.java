package com.odt.restful_api_demo.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DeleteMenuRequest {
    List<String> codeList;
}
