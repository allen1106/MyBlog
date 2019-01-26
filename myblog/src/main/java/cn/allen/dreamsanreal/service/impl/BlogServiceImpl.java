package cn.allen.dreamsanreal.service.impl;

import cn.allen.dreamsanreal.dao.mapper.BlogMapper;
import cn.allen.dreamsanreal.model.Blog;
import cn.allen.dreamsanreal.model.Category;
import cn.allen.dreamsanreal.model.User;
import cn.allen.dreamsanreal.service.BlogService;
import cn.allen.dreamsanreal.util.HtmlUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service(value = "blogService")
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogMapper blogDao;

    @Override
    public void createBlog(User author, String title, String summary, String content) {
        String uuid = UUID.randomUUID().toString().replace("-", "");
        HtmlUtil.generateHtmlByTemplate(uuid, title, summary, content);

        Blog blog = new Blog(uuid, author.getId(), summary);
        blogDao.insert(blog);
    }

    @Override
    public void createBlog(User author, Category category, String title, String summary, String content) {
        String uuid = UUID.randomUUID().toString().replace("-", "");
        HtmlUtil.generateHtmlByTemplate(uuid, title, summary, content);

        Blog blog = new Blog(uuid, category.getId(), author.getId(), summary);
        blogDao.insert(blog);
    }
}
