package com.example.demo.controller;

import com.example.demo.entity.Tie;
import com.example.demo.entity.Tiediscuss;
import com.example.demo.service.TieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tie")
@EnableAutoConfiguration
public class TieController {

    @Autowired
    private TieService  tieService;

    @RequestMapping("/getallties")
    public List<Tie> findallties(){
        return tieService.findallties();
    }

    @RequestMapping("/getalltiediscuss")
    public List<Tiediscuss> getalltiediscuss(){
        return tieService.getalltiediscuss();
    }

    @RequestMapping("/getbytieid")
    public Tie getbyid(@RequestParam("tieid") Integer tieid){
        return tieService.getbyid(tieid);
    }

    @RequestMapping("/addtie")
    public int addtie(@RequestParam("tietype") String tietype,
                      @RequestParam("tiename") String tiename,
                      @RequestParam("tiecontent") String tiecontent,
                      @RequestParam("author") String author){
        return tieService.addtie(tietype,tiename,tiecontent,author);
    }

    @PostMapping("/deleteties")
    public int deleteties(@RequestParam("ties") String ties) {
        return tieService.deleteties(ties);
    }

    @RequestMapping("/addtiediscuss")
    public int adddiscuss(@RequestParam("discuss_author") String discuss_author,
                          @RequestParam("discuss_content") String discuss_content,
                          @RequestParam("tieid") Integer tieid){
        return tieService.adddiscuss(discuss_author,discuss_content,tieid);
    }

    @RequestMapping("getalltiediscussbytieid")
    public List<Tiediscuss> getalltiediscussbytieid(@RequestParam("tieid") Integer tieid){
        return tieService.getalltiediscussbytieid(tieid);
    }

}
