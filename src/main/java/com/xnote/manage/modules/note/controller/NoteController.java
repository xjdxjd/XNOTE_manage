package com.xnote.manage.modules.note.controller;

import com.xnote.manage.common.constant.load.LoadPathConstant;
import com.xnote.manage.core.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/note")
public class NoteController extends BaseController {

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String noteAddView(){
        return LoadPathConstant.NOTE_ADD_PATH.getValue() + "noteadd";
    }
}
