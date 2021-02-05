package com.blog.cms.web.controller.bm;

import com.blog.cms.common.JsonResult;
import com.blog.cms.dao.b.bm.ArticleMapper;
import com.blog.cms.domain.bm.Article;
import com.blog.cms.web.utils.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ArticleController {
    @Autowired
    private ArticleMapper articleMapper;
    @RequestMapping(value = "article/page",method = RequestMethod.POST)
    public Map<String,Object> getPageList(HttpServletRequest request){
        String currentPage=request.getParameter("currentPage");
        String pageSize=request.getParameter("pageSize");
        String fullText=request.getParameter("fullText");
        Map<String,Object> condition= PageHelper.getPageMap(Integer.parseInt(currentPage),Integer.parseInt(pageSize));
        if (StringUtils.isNotEmpty(fullText))
            condition.put("fullText",fullText);
        List<Article> articles= articleMapper.selectColumnsPage(condition);
        int total=articleMapper.selectCount(condition);
        Map<String,Object> map=new HashMap<>();
        map.put("data",articles);
        map.put("total",total);
        return  map;
    }
}
