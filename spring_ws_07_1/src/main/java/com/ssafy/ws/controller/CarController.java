package com.ssafy.ws.controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssafy.ws.model.dto.Car;
import com.ssafy.ws.model.dto.User;
import com.ssafy.ws.model.service.CarService;
import com.ssafy.ws.model.service.UserService;

@Controller
public class CarController {
	private static final Logger logger = LoggerFactory.getLogger(CarController.class);

	/**
	 * CarService를 주입받는다.
	 */
	@Autowired
	CarService cService;
	/**
	 * UserService를 주입받는다.
	 */
	@Autowired
	UserService uService;

	@Autowired
	ResourceLoader resLoader;

	/**
	 * / 또는 /index 요청이 get 방식으로 들어왔을 때 index 로 연결한다.
	 * 
	 * @return
	 */
	@GetMapping({ "/", "/index" })
	public String showRoot() {
		return "index";
	}

	/**
	 * <pre>
	 * /login 요청이 post 방식으로 왔을 때 login 처리한다.
	 * </pre>
	 * 
	 * 사용자의 요청에서 계정 정보를 추출해 로그인 처리한다. 로그인 성공 시 session에 정보를 담고 redirect로 index로
	 * 이동한다. 그렇지 않을 경우는 로그인 실패 메시지를 model에 담고 forward로 index로 이동한다.
	 * 
	 * @param user    전달된 파라미터는 ModelAttribute를 통해서 객체로 받을 수 있다.
	 * @param session 사용자 정보를 세션에 저장하기 위해 사용한다.
	 * @param model   Request scope에 정보를 저장하기 위해서 사용된다.
	 * @return
	 */
	@PostMapping("/login")
	public String doLogin(@ModelAttribute User user, HttpSession session, Model model) {
		// UserService를 통해 사용자 계정을 가져온다.
		 User selected = uService.select(user.getId());
		// 계정이 존재하고 비밀번호가 일치하면 로그인 성공, 그렇지 않다면 실패이다.
		 if (selected != null && user.getPass().equals(selected.getPass())) {
		 	session.setAttribute("loginUser", selected);
		 	return "redirect:/";
		 } else {
		 	model.addAttribute("msg", "로그인 실패");
		 	return "index";
		 }
	}

	/**
	 * <pre>
	 * /logout을 get 방식으로 요청했을 때 session을 만료 시키고 로그아웃 처리한다.
	 * </pre>
	 * 
	 * 다음 경로는 redirect 형태로 /index로 이동한다.
	 * 
	 * @param session
	 * @return
	 */

	@GetMapping("/logout")
	public String doLogout(HttpSession session) {
		session.invalidate();
		return "redirect:/index";
	}

	/**
	 * <pre>
	 * /list를 get 방식으로 요청할 때 자동차 정보를 보여준다.
	 * </pre>
	 * 
	 * @return
	 */
	@GetMapping("/list")
	public String showList(Model model) {
		 List<Car> cars = cService.selectAll();
		 model.addAttribute("cars", cars);
		return "list";
	}

	/**
	 * get 방식의 regist 요청이 오면 regist 페이지를 forward로 연결한다.
	 * 
	 * @return
	 */
	@GetMapping("/regist")
	public String showRegistForm() {
		return "regist";
	}

	/**
	 * post 방식의 regist 요청이 오면 요청으로 전달된 car 객체와 file을 활용한다. 파일의 저장 위치는
	 * resources/upload 아래로 지정한다. 이를 위해 ResourceLoader의 getResource를 사용할 수 있다. 이 이름에
	 * 시간 정보를 추가한 img(저장될 파일 이름)를 만들어 Car 객체에 설정한다. 파일을 저장 후 regist_result에 forward로
	 * 이동한다.
	 * 
	 * @param car
	 * @param file
	 * @return
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	@PostMapping("/regist")
	public String doRegist(@ModelAttribute Car car) throws IllegalStateException, IOException {
		// T.X 처리를 위해 파일 저장에 대한 부분을 service로 이동시킨다.
		 cService.insert(car);
		return "regist_result";
	}

	/**
	 * '/search' 요청이 get 방식으로 들어왔을때 주어진 modelName을 모델명에 포함하는 자동차 리스트를 보여준다.
	 * 
	 * @param modelName
	 * @return
	 */
	@GetMapping("/search")
	public String showSearchModelNameList(Model model, String modelName) {
		 List<Car> list = cService.searchByModelName(modelName);
		 model.addAttribute("cars", list);
		return "list";
	}

}
