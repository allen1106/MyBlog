package cn.allen.dreamsanreal.service;

import cn.allen.dreamsanreal.model.Category;
import cn.allen.dreamsanreal.model.User;

public interface BlogService {
    void createBlog(User author, String title, String summary, String content);
    void createBlog(User author, Category category, String title, String summary, String content);
}
