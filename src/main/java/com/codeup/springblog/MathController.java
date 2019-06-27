package com.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MathController {
    @GetMapping("/add/{three}/and/{four}")
    @ResponseBody
    public String add(@PathVariable int three, @PathVariable int four) {
        return "" + (three + four);
    }

    @GetMapping("/subtract/{three}/from/{ten}")
    @ResponseBody
    public String subtract(@PathVariable int three, @PathVariable int ten) {
        return "" + (ten - three);
    }

    @GetMapping("/multiply/{four}/and/{five}")
    @ResponseBody
    public String multiply(@PathVariable int four, @PathVariable int five) {
        return "" + (four * five);
    }

    @GetMapping("/divide/{six}/by/{three}")
    @ResponseBody
    public String divide(@PathVariable int six, @PathVariable int three) {
        return "" + (six / three);
    }
}
