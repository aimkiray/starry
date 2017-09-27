package com.starry.service.Implement;

import com.starry.dao.PostMapper;
import com.starry.domain.Post;
import com.starry.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ━━━━━━神兽出没━━━━━━
 *      ┏┓   ┏┓
 *     ┏┛┻━━━┛┻┓
 *     ┃       ┃
 *     ┃   ━   ┃
 *     ┃ ┳┛ ┗┳ ┃
 *     ┃       ┃
 *     ┃   ┻   ┃ Created by nekuata.
 *     ┃       ┃
 *     ┗━┓   ┏━┛ Code is far away from bug with
 *       ┃   ┃   the alpaca protecting.
 *       ┃   ┃   神兽保佑,代码无bug.💊💊💊
 *       ┃   ┗━━━┓
 *       ┃       ┣┓
 *       ┃       ┏┛
 *       ┗┓┓┏━┳┓┏┛
 *        ┃┫┫ ┃┫┫
 *        ┗┻┛ ┗┻┛
 *
 * ━━━━━━感觉萌萌哒━━━━━━
 */

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostMapper postMapper;

    /**
     * 通用文章获取功能，包含搜索&分页，参数可选，不需要的话传入0或null
     * @param start 查询开始位置
     * @param length 查询几条
     * @param searchParam 搜索条件
     */
    @Override
    public List<Post> searchPost(int start, int length, String searchParam) {
        Map<String, Object> map = new HashMap<>();
        map.put("start", start);
        map.put("limit", length);
//        判断是否为搜索
        if (searchParam != null) {
            map.put("searchParam", searchParam);
        }
//        剩下的交给xml判断
        List<Post> posts = postMapper.selectBySearch(map);

        return posts;
    }

    /**
     * 通用文章展示功能，包含搜索&分页，参数可选，不需要的话传入0或null
     * @param pageNumber 当前页数
     * @param pageSize 每页条目数
     * @param searchParam 搜索条件
     */
    @Override
    public List<Post> findPost(int pageNumber, int pageSize, String searchParam) {
        Map<String, Object> map = new HashMap<>();
//        定义limit起始和结束位置，默认查询全部
        int start = 0;
        int limit = -1;
//        开启分页
        if (pageNumber != 0 && pageSize != 0) {
            start = (pageNumber - 1) * pageSize;
            limit = pageSize;
        }
        map.put("start", start);
        map.put("limit", limit);
//        判断是否为搜索
        if (searchParam != null) {
            map.put("searchParam", searchParam);
        }
//        交给mybatis xml处理
        List<Post> posts = postMapper.selectBySearch(map);

        return posts;
    }

    /**
     * 通过标题查找文章
     *
     * @param postTitle 文章标题
     */
    @Override
    public Post findPostByTitle(String postTitle) {
        return null;
    }

    /**
     * 通过Id查找文章
     *
     * @param postId 文章Id
     */
    @Override
    public Post findPostById(int postId) {
        return postMapper.selectByPrimaryKey(postId);
    }

    /**
     * 根据id删除文章
     *
     * @param postId 文章Id
     */
    @Override
    public int deletePost(int postId) {
        return postMapper.deleteByPrimaryKey(postId);
    }

    /**
     * 添加文章
     *
     * @param post
     */
    @Override
    public int insertPost(Post post) {
        int result = 0;
        if (post != null) {
            result = postMapper.insert(post);
        }
        return result;
    }

    /**
     * 修改文章
     *
     * @param post
     */
    @Override
    public int updatePost(Post post) {
        int result = 0;
        if (post != null && post.getPostId() != null) {
            result = postMapper.updateByPrimaryKeyWithBLOBs(post);
        }
        return result;
    }

    @Override
    public int queryPostNum() {
        return postMapper.count();
    }
}
