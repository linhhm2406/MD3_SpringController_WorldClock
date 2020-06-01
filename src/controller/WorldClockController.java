package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.TimeZone;

@Controller
@RequestMapping("/")
public class WorldClockController {

    @GetMapping("/showMain")
    public ModelAndView showMain() {
        return new ModelAndView("showMain");
    }

    @GetMapping("taketime")
    public ModelAndView takeTime(@RequestParam String area) {
        Date date = new Date();
        TimeZone defaultTimeZoneTime = TimeZone.getDefault();
        TimeZone thisAreaTime = TimeZone.getTimeZone(area);

        long locale_time = date.getTime() + (thisAreaTime.getRawOffset() - defaultTimeZoneTime.getRawOffset());
        date.setTime(locale_time);

        ModelAndView modelAndView = new ModelAndView("showMain");
        modelAndView.addObject("area", area);
        modelAndView.addObject("date", date);
        return modelAndView;
    }
}
