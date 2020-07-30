package com.xnote.manage.modules.note.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xnote.manage.common.constant.CommonConstant;
import com.xnote.manage.common.constant.load.LoadPathConstant;
import com.xnote.manage.common.util.NoteUtils;
import com.xnote.manage.core.controller.BaseController;
import com.xnote.manage.core.result.Result;
import com.xnote.manage.modules.note.bean.Note;
import com.xnote.manage.modules.note.bean.NoteCategory;
import com.xnote.manage.modules.note.bean.NoteContent;
import com.xnote.manage.modules.note.bean.NoteStar;
import com.xnote.manage.modules.note.service.NoteCategoryService;
import com.xnote.manage.modules.note.service.NoteService;
import com.xnote.manage.modules.note.service.NoteStarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/note")
public class NoteController extends BaseController
{
    @Autowired
    private NoteService noteService;

    @Autowired
    private NoteCategoryService noteCategoryService;

    @Autowired
    private NoteStarService noteStarService;

    /**
     * 笔记添加页面
     * @return
     */
    @GetMapping("/add")
    public String noteAddView()
    {
        return LoadPathConstant.NOTE_ADD_PATH.getValue() + "noteadd";
    }

    /**
     * 笔记添加
     * @return
     */
    @PutMapping("/addNote")
    @ResponseBody
    public Result noteAdd(@RequestParam("noteData") String noteData) throws JsonProcessingException
    {
        if(StringUtils.isEmpty(noteData))
        {
            return result.failure();
        }

        Note note = new Note();
        NoteContent content = new NoteContent();
        NoteStar star = new NoteStar();
        Map<String, String> noteDataMap = new ObjectMapper().readValue(noteData, Map.class);
        if(CollectionUtils.isEmpty(noteDataMap))
        {
            return result.failure();
        }

        //  组装页面传回数据
        note.setNoteTitle(noteDataMap.get("noteTitle"));
        note.setNoteCate(noteDataMap.get("noteCate"));
        content.setNoteContext(noteDataMap.get("content"));

        note = NoteUtils.assembleNote(note);
        content = NoteUtils.assembleNoteContent(note.getNoteCont(), note.getNoteId(), content);
        star = NoteUtils.assembleNoteStar(note.getNoteId(), star);

        Integer noteRow = noteService.addNote(note);
        if(CommonConstant.STATUS_ZERO.getInt().equals(noteRow))
        {
            return result.failure();
        }

        Integer contentRow = noteService.addNoteContent(content);
        if(CommonConstant.STATUS_ZERO.getInt().equals(contentRow))
        {
            return result.failure();
        }

        Integer starRow = noteStarService.addNoteStar(star);
        if(CommonConstant.STATUS_ZERO.getInt().equals(starRow))
        {
            return result.failure();
        }

        return result.success();
    }

/***********************************************************************************************************************************************************************/
    /**
     * 笔记分类页面
     * @return
     */
    @GetMapping("/cate")
    public String noteCateView()
    {
        return LoadPathConstant.NOTE_CATE_PATH.getValue() + "category";
    }
    /**
     * 获取全部的笔记分类
     * @return
     */
    @GetMapping("/getNoteCategory")
    @ResponseBody
    public Result getNoteCategory()
    {
        List<NoteCategory> cates = noteCategoryService.getNoteCategory();
        if(CollectionUtils.isEmpty(cates))
        {
            return result.failure();
        }

        Map<String, Object> cateMap = new HashMap<>();
        cateMap.put("count", cates.size());
        cateMap.put("data", cates);

        return result.success(cateMap);
    }

    /**
     * 模糊查询
     * @param code
     * @return
     */
    @GetMapping("/search")
    @ResponseBody
    public Result searchCate(@RequestParam(value = "cateCode", required = false) String code)
    {
        if("".equals(code))
        {
            code = null;
        }
        List<NoteCategory> cates = noteCategoryService.searchCate(code);

        Map<String, Object> cateMap = new HashMap<>();
        cateMap.put("count", cates.size());
        cateMap.put("data", cates);

        return result.success(cateMap);
    };

    /**
     * 笔记分类添加页面
     * @return
     */
    @GetMapping("/addCate")
    public String addCateView() { return LoadPathConstant.NOTE_CATE_PATH.getValue() + "cateadd"; }

    /**
     * 笔记分类添加
     * @param formData
     * @return
     * @throws JsonProcessingException
     */
    @PutMapping("/addCate")
    @ResponseBody
    public Result addCate(@RequestParam("formData") String formData) throws JsonProcessingException
    {
        if(StringUtils.isEmpty(formData))
        {
            return result.failure();
        }

        NoteCategory category = new ObjectMapper().readValue(formData, NoteCategory.class);
        if(ObjectUtils.isEmpty(category))
        {
            return result.failure();
        }

        if(StringUtils.isEmpty(category.getCateCode()) || StringUtils.isEmpty(category.getCateName()) || StringUtils.isEmpty(category.getCateSort()))
        {
            return result.failure();
        }

        NoteCategory cate = noteCategoryService.getCategoryByCode(category.getCateCode());
        if(!ObjectUtils.isEmpty(cate))
        {
            return result.failure();
        }

        category = NoteUtils.assembleNoteCate(category);
        Integer row = noteCategoryService.addCate(category);
        if(CommonConstant.STATUS_ZERO.equals(row))
        {
            return result.failure();
        }
        return result.success();
    }

    /**
     * 笔记分类编辑页面
     * @return
     */
    @GetMapping("/editCate/{id}")
    public String editCateView(@PathVariable("id") String id, Model model)
    {
        if(StringUtils.isEmpty(id))
        {
            return "redirect: error/5xx";
        }

        NoteCategory category = noteCategoryService.getCategoryById(id);
        if(ObjectUtils.isEmpty(category))
        {
            return "redirect: error/5xx";
        }

        model.addAttribute("cate", category);
        return LoadPathConstant.NOTE_CATE_PATH.getValue() + "cateedit";
    }

    /**
     * 笔记分类更新
     * @return
     */
    @PostMapping("/editCate")
    @ResponseBody
    public Result editCate(@RequestParam("formData") String formData) throws JsonProcessingException
    {
        if(StringUtils.isEmpty(formData))
        {
            return result.failure();
        }

        NoteCategory category = new ObjectMapper().readValue(formData, NoteCategory.class);
        if(ObjectUtils.isEmpty(category))
        {
            return result.failure();
        }

        NoteCategory cate = noteCategoryService.getCategoryById(category.getCateId());
        if(ObjectUtils.isEmpty(cate))
        {
            return result.failure();
        }

        Integer row = noteCategoryService.updateCate(category);
        if(CommonConstant.STATUS_ZERO.equals(row))
        {
            return result.failure();
        }

        return result.success();
    }

    /**
     * 根据ID删除笔记分类
     * @param cateId
     * @return
     */
    @DeleteMapping("/delCate/{id}")
    @ResponseBody
    public Result delCate(@PathVariable("id") String cateId)
    {
        if(StringUtils.isEmpty(cateId))
        {
            return result.failure();
        }

        NoteCategory category = noteCategoryService.getCategoryById(cateId);
        if(ObjectUtils.isEmpty(category))
        {
            return result.failure();
        }

        Integer row = noteCategoryService.delCateById(cateId);
        if(CommonConstant.STATUS_ZERO.equals(row))
        {
            return result.failure();
        }

        return result.success();
    }

    @DeleteMapping("/batchesDelCate")
    @ResponseBody
    public Result batchesDelCate(@RequestParam("ids") String ids) throws JsonProcessingException {
        if (StringUtils.isEmpty(ids))
        {
            return result.failure();
        }
        List<String> delIds = new ObjectMapper().readValue(ids, ArrayList.class);
        if (CollectionUtils.isEmpty(delIds))
        {
            return result.failure();
        }
        Integer row = noteCategoryService.batchesDelCate(delIds);
        if(CommonConstant.STATUS_ZERO.equals(row))
        {
            return result.failure();
        }
        return result.success();
    }

/***********************************************************************************************************************************************************************/

}
