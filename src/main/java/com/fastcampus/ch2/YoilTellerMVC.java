package com.fastcampus.ch2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

@Controller
public class YoilTellerMVC {
    @RequestMapping("/getYoilMVC") // http://localhost:8080/getYoil?year=2021&month=10&day=1
    	public ModelAndView main(int year, int month, int day, Model model) throws IOException {

    	ModelAndView mv = new ModelAndView();
    	
    		// 1. ��ȿ�� �˻�
//    		if(!isValid(year, month, day))
//    			return "yoilError";
//    		
    		// 2. ���� ���
    		char yoil = getYoil(year, month, day);
    		
    		// 3. ����� �� -> Model
    		mv.addObject("year", year);
    		mv.addObject("month", month);
    		mv.addObject("day", day);
    		mv.addObject("yoil", yoil);
    		
    		// 4. ����� ������ view�� ����
    		
    		mv.setViewName("yoil");
    		
    		return mv; // /WEB-INF/views/yoil.jsp
    }
    
    private boolean isValid(int year, int month, int day) {
		return true;
	}

	private char getYoil(int year, int month, int day) {
        Calendar cal = Calendar.getInstance();
        cal.set(year, month - 1, day);

        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        return " �Ͽ�ȭ�������".charAt(dayOfWeek);
    }
}