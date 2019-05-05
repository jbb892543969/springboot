package com.jbb.uploaddemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import springfox.documentation.annotations.ApiIgnore;

/**
 * PageController
 *
 * @author jbb
 * @date 19-5-5
 */
@RequestMapping
@Controller
@ApiIgnore
public class PageController {
    @GetMapping
    public String upload() {
        return "upload";
    }
}
