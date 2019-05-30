package com.example.demo.service.impl;

import com.example.demo.Utils.Fileutil;
import com.example.demo.dao.MeterialMapper;
import com.example.demo.entity.Meterial;
import com.example.demo.service.MeterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @program: qxproject
 * @description: 材料库服务
 * @author: 唐庆阳
 * @create: 2019-05-26 19:54
 **/
@Service
public class MeterialServiceimpl implements MeterialService {
    @Autowired
    private MeterialMapper meterialMapper;

    public List<Meterial> getAllmeterial() {
        List<Meterial> list = new ArrayList<>();
        list = meterialMapper.findallmenus();
        return list;
    }
    public String hello() {
        return "Helloworld";
    }


    public int insertmerterial(Meterial meterial) {
        return meterialMapper.insert(meterial);
    }


    public int deleteusers(String meterials) {
        int count = 0;
        System.out.println(meterials);
        String ids[] = meterials.split(",");
        for (int i = 0; i < ids.length; i++) {
            count = meterialMapper.deleteByPrimaryKey(Integer.parseInt(ids[i]));
        }
        return count == 0 ? 0 : 1;
    }


    public int editmeterial(@RequestBody Meterial meterial) {
        int count = meterialMapper.updateByPrimaryKey(meterial);
        return count == 0 ? 0 : 1;
    }

    public Meterial findbyid(Integer id)
    {
        return meterialMapper.selectByPrimaryKey(id);
    }


    public String upload(MultipartFile file, String meterialtype,
                          String meterialname, String meterdesc,
                          String author) {
        Meterial meterial=new Meterial();
        meterial.setMeterialitype(meterialtype);
        meterial.setMeterialname(meterialname);
        meterial.setMeterdesc(meterdesc);
        meterial.setAuthor(author);
        meterial.setMeterialsize(Fileutil.getPrintSize(file.getSize()));
        if (file.isEmpty()) {
            return "上传失败，请选择文件";
        }
        String fileName = file.getOriginalFilename();
        System.out.println(fileName);
        String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
        String filePath = "D:/upload/";
        File dest = new File(filePath + fileName);
        try {
            file.transferTo(dest);
            System.out.print("上传成功");
            meterial.setMeterialurl(filePath + fileName);
            Date date=new Date();
            meterial.setDatetime(date);
            meterialMapper.insert(meterial);
            return "1";
        } catch (IOException e) {
            System.out.println(e.toString() + e);
        }
        return "0";
    }

    public void download(String path, HttpServletRequest request, HttpServletResponse response)throws IOException{
        File file = new File(path);
        String filename=file.getName();
        if (!file.exists()) {
            response.setContentType("text/回头ml; charset=UTF-8");//注意text/回头ml，和application/回头ml
            response.getWriter().print("<html><body><script type='text/javascript'>alert('您要下载的资源已被删除！');</script></body></回头ml>");
            response.getWriter().close();
            System.out.println("您要下载的资源已被删除！！");
            return;
        }
        //转码，免得文件名中文乱码
        filename = URLEncoder.encode(filename,"UTF-8");
        //解决中文显示乱码
        response.addHeader("Content-Disposition", "attachment;filename=" + filename);
        //设置响应的类型
        response.setContentType("multipart/form-data");
        // 读取要下载的文件，保存到文件输入流
        FileInputStream in = new FileInputStream(path);
        // 创建输出流
        OutputStream out = response.getOutputStream();
        // 创建缓冲区
        byte buffer[] = new byte[1024]; // 缓冲区的大小设置是个迷  我也没搞明白
        int len = 0;
        //循环将输入流中的内容读取到缓冲区当中
        while((len = in.read(buffer)) > 0){
            out.write(buffer, 0, len);
        }
        //关闭文件输入流
        in.close();
        // 关闭输出流
        out.close();

    }
}
