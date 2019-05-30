package com.example.demo.controller;


import com.example.demo.entity.Meterial;
import com.example.demo.service.MeterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/meterial")
@EnableAutoConfiguration
public class MeterialController {
    @Autowired
    private MeterialService meterialService;

    @RequestMapping("/getAllmeterial")
    public List<Meterial> getAllmeterial() {
        return meterialService.getAllmeterial();
    }

    @RequestMapping("/hello")
    public String hello() {
        return meterialService.hello();
    }

    @PostMapping("/insertmerterial")
    public int insertmerterial(@RequestBody Meterial meterial) {
        return meterialService.insertmerterial(meterial);
    }

    @PostMapping("/deletemeterials")
    public int deleteusers(@RequestParam("meterials") String meterials) {
      return meterialService.deleteusers(meterials);
    }

    @PostMapping("/editmeterial")
    public int editmeterial(@RequestBody Meterial meterial) {
        return meterialService.editmeterial(meterial);
    }

    @RequestMapping("/selectbyid")
    public Meterial findbyid(@RequestParam("meterialid") Integer id)
    {
        return meterialService.findbyid(id);
    }


    @RequestMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile file,
                         @RequestParam("meterialtype") String meterialtype,
                         @RequestParam("meterialname") String meterialname,
                         @RequestParam("meterdesc") String meterdesc,
                         @RequestParam("author") String author) {
        return meterialService.upload(file,meterialtype,meterialname,meterdesc,author);
    }

    @RequestMapping("/download")
    public void download(@RequestParam("filepath") String path, HttpServletRequest request, HttpServletResponse response)throws IOException{
        meterialService.download(path,request,response);

    }


}
