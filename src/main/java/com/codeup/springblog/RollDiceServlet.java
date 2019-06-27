package com.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Random;

@Controller
public class RollDiceServlet {

    @GetMapping("/roll-dice")
    public String rollDice() {
        return "rollDice";
    }

    @GetMapping("/roll-dice/{n}")
    public String rollDice(@PathVariable int n, Model model){
        Random rand = new Random();
        int roll = rand.nextInt(6)+1;
        model.addAttribute("guess",n);
        model.addAttribute("roll",roll);
        return "rollDice";
    }
}
