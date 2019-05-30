package com.example.demo.service.impl;

import com.example.demo.dao.TieMapper;
import com.example.demo.dao.TiediscussMapper;
import com.example.demo.entity.Tie;
import com.example.demo.entity.Tiediscuss;
import com.example.demo.service.TieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @program: qxproject
 * @description: tieservice
 * @author: 唐庆阳
 * @create: 2019-05-26 19:52
 **/
@Service
public class TieServiceimpl implements TieService {
    @Autowired
    private TieMapper tieMapper;

    @Autowired
    private TiediscussMapper tiediscussMapper;

    /**
     * @描述 获取所有的贴吧内容
     * @类名 TieService
     * @参数 []
     * @返回值 java.util.List<com.example.demo.entity.Tie>
     * @创建人 唐庆阳
     * @创建时间 2019-05-26
     * @修改人和其它信息
     */
    public List<Tie> findallties() {

        return tieMapper.findallties();
    }

    /**
     * @描述 获取所有的评论
     * @类名 TieService
     * @参数 []
     * @返回值 java.util.List<com.example.demo.entity.Tiediscuss>
     * @创建人 唐庆阳
     * @创建时间 2019-05-26
     * @修改人和其它信息
     */
    public List<Tiediscuss> getalltiediscuss() {

        return tiediscussMapper.findalltiediscuss();
    }

    /**
     * @描述 根据tieid获取贴吧信息
     * @类名 TieService
     * @参数 [tieid]
     * @返回值 com.example.demo.entity.Tie
     * @创建人 唐庆阳
     * @创建时间 2019-05-26
     * @修改人和其它信息
     */
    public Tie getbyid(Integer tieid) {

        return tieMapper.selectByPrimaryKey(tieid);
    }

    /**
     * @描述 添加贴吧
     * @类名 TieService
     * @参数 [tietype, tiename, tiecontent, author]
     * @返回值 int
     * @创建人 唐庆阳
     * @创建时间 2019-05-26
     * @修改人和其它信息
     */
    public int addtie(String tietype, String tiename, String tiecontent, String author) {

        Tie tie = new Tie();
        tie.setAuthor(author);
        tie.setTietype(tietype);
        tie.setTiename(tiename);
        tie.setTiecontent(tiecontent);
        Date date = new Date();
        tie.setPublishtime(date);
        System.out.println(tie);
        return tieMapper.insert(tie);
    }

    /**
     * @描述 删除用户
     * @类名 TieService
     * @参数 [ties]
     * @返回值 int
     * @创建人 唐庆阳
     * @创建时间 2019-05-26
     * @修改人和其它信息
     */
    public int deleteties(String ties) {

        int count = 0;
        System.out.println(ties);
        String ids[] = ties.split(",");
        for (int i = 0; i < ids.length; i++) {
            count = tieMapper.deleteByPrimaryKey(Integer.parseInt(ids[i]));
        }
        return count == 0 ? 0 : 1;
    }

    /**
     * @描述 添加评论
     * @类名 TieService
     * @参数 [discuss_author, discuss_content, tieid]
     * @返回值 int
     * @创建人 唐庆阳
     * @创建时间 2019-05-26
     * @修改人和其它信息
     */
    public int adddiscuss(String discuss_author, String discuss_content, Integer tieid) {

        Tiediscuss tiediscuss = new Tiediscuss();
        tiediscuss.setDiscussAuthor(discuss_author);
        tiediscuss.setDiscussContent(discuss_content);
        Date date = new Date();
        tiediscuss.setDiscussTime(date);
        tiediscuss.setTieid(tieid);
        return tiediscussMapper.insert(tiediscuss);
    }

    /**
     * @描述 通过tieid查询贴吧评论
     * @类名 TieService
     * @参数 [tieid]
     * @返回值 java.util.List<com.example.demo.entity.Tiediscuss>
     * @创建人 唐庆阳
     * @创建时间 2019-05-26
     * @修改人和其它信息
     */
    public List<Tiediscuss> getalltiediscussbytieid(Integer tieid) {

        return tiediscussMapper.selectBytieid(tieid);
    }
}
