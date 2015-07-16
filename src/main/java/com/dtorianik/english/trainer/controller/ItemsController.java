package com.dtorianik.english.trainer.controller;

import com.dtorianik.english.trainer.dto.AddItemFormDto;
import com.dtorianik.english.trainer.service.LanguageItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by dtorianik on 7/16/2015.
 */
@Controller
@RequestMapping("/items")
public class ItemsController {

    @Autowired
    private LanguageItemService languageItemService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void addItem(@RequestBody AddItemFormDto addItemForm) {
        languageItemService.save(addItemForm);
    }

    @RequestMapping(method = RequestMethod.GET)
    public String showItemsPage(Model model) {
        model.addAttribute("languageItems", languageItemService.find());
        return "items";
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleAppException(Exception ex) {
        return ex.getMessage();
    }
}
