package app.controller.base;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import app.core.deft.DefaultController;
import app.core.deft.DefaultReturn;
import app.service.base.FujianguanliService;

@Controller
@RequestMapping(value="/fujianguanli")
public class FujianguanliController extends DefaultController{

	@Resource(name = "FujianguanliService")
	private FujianguanliService fujianguanliService;

	@RequestMapping(value="index", method = RequestMethod.POST)
	@ResponseBody
	public DefaultReturn index(HttpServletRequest req, HttpServletResponse resp){
		Map map = this.getParameter(req, resp);
		try {
			return this.invoke(fujianguanliService, map); 
		}catch(Exception e){
			return this.exception(e, map);
		} 
	}
	
}
