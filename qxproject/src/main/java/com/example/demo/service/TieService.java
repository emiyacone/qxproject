package com.example.demo.service;

import com.example.demo.dao.TieMapper;
import com.example.demo.dao.TiediscussMapper;
import com.example.demo.entity.Tie;
import com.example.demo.entity.Tiediscuss;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

/**
 * @program: qxproject
 * @description: tieservice
 * @author: 唐庆阳
 * @create: 2019-05-26 19:52
 **/

public interface TieService {

    /**
     * @描述 获取所有的贴吧内容
     * @类名 TieService
     * @参数 []
     * @返回值 java.util.List<com.example.demo.entity.Tie>
     * @创建人 唐庆阳
     * @创建时间 2019-05-26
     * @修改人和其它信息
     */
    public List<Tie> findallties();

    /**
     * @描述 获取所有的评论
     * @类名 TieService
     * @参数 []
     * @返回值 java.util.List<com.example.demo.entity.Tiediscuss>
     * @创建人 唐庆阳
     * @创建时间 2019-05-26
     * @修改人和其它信息
     */
    public List<Tiediscuss> getalltiediscuss();

    /**
     * @描述 根据tieid获取贴吧信息
     * @类名 TieService
     * @参数 [tieid]
     * @返回值 com.example.demo.entity.Tie
     * @创建人 唐庆阳
     * @创建时间 2019-05-26
     * @修改人和其它信息
     */
    public Tie getbyid(Integer tieid);

    /**
     * @描述 添加贴吧
     * @类名 TieService
     * @参数 [tietype, tiename, tiecontent, author]
     * @返回值 int
     * @创建人 唐庆阳
     * @创建时间 2019-05-26
     * @修改人和其它信息
     */
    public int addtie(String tietype, String tiename, String tiecontent, String author);

    /**
     * @描述 删除用户
     * @类名 TieService
     * @参数 [ties]
     * @返回值 int
     * @创建人 唐庆阳
     * @创建时间 2019-05-26
     * @修改人和其它信息
     */
    public int deleteties(String ties);

    /**
     * @描述 添加评论
     * @类名 TieService
     * @参数 [discuss_author, discuss_content, tieid]
     * @返回值 int
     * @创建人 唐庆阳
     * @创建时间 2019-05-26
     * @修改人和其它信息
     */
    public int adddiscuss(String discuss_author, String discuss_content, Integer tieid);

    /**
     * @描述 通过tieid查询贴吧评论
     * @类名 TieService
     * @参数 [tieid]
     * @返回值 java.util.List<com.example.demo.entity.Tiediscuss>
     * @创建人 唐庆阳
     * @创建时间 2019-05-26
     * @修改人和其它信息
     */
    public List<Tiediscuss> getalltiediscussbytieid(Integer tieid);
}
