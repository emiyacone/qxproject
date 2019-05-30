package com.example.demo.service;

import com.example.demo.entity.Meterial;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @program: qxproject
 * @description: 材料库服务
 * @author: 唐庆阳
 * @create: 2019-05-26 19:54
 **/

public interface MeterialService {


    public List<Meterial> getAllmeterial();

    public String hello();

    public int insertmerterial(Meterial meterial);

    public int deleteusers(String meterials);

    @PostMapping("/editmeterial")
    public int editmeterial(Meterial meterial);

    @RequestMapping("/selectbyid")
    public Meterial findbyid(Integer id);


    @RequestMapping("/upload")
    public String upload(MultipartFile file, String meterialtype, String meterialname, String meterdesc, String author);

    @RequestMapping("/download")
    public void download(String path, HttpServletRequest request, HttpServletResponse response)throws IOException;
}
