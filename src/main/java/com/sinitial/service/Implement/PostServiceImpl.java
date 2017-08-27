package com.sinitial.service.Implement;

import com.sinitial.dao.PostMapper;
import com.sinitial.domain.Post;
import com.sinitial.service.PostService;
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
     * @param pageNumber 当前页数
     * @param pageSize 每页条目数
     * @param searchParam 搜索条件
     */
    @Override
    public List<Post> searchPost(int pageNumber, int pageSize, String searchParam) {
        Map<String, Object> map = new HashMap<>();
//        定义limit起始和结束位置，默认查询全部
        int start = 0;
        int stop = -1;
//        开启分页
        if (pageNumber != 0 && pageSize != 0) {
            start = (pageNumber - 1) * pageSize;
//            stop = pageNumber * pageSize;
        }
        map.put("start", start);
        map.put("limit", pageSize);
//        判断是否为搜索
        if (searchParam != null) {
            map.put("searchParam", searchParam);
        }
//        剩下的交给xml判断
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
        return null;
    }

    /**
     * 根据id删除文章
     *
     * @param postId 文章Id
     */
    @Override
    public int deletePost(int postId) {
        return 0;
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
        return 0;
    }
}
