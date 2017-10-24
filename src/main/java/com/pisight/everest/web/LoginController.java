package com.pisight.everest.web;

import java.util.Date;
import java.util.UUID;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pisight.everest.constants.Constants;
import com.pisight.everest.dao.EverestDAO;
import com.pisight.everest.dto.LoginRequest;
import com.pisight.everest.entities.User;
import com.pisight.everest.service.EverestServiceImpl;
import com.pisight.everest.util.ScriptLogger;
import com.pisight.everest.util.WebUtil;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@CrossOrigin(origins = "*", maxAge = 3600000)
@RestController
@RequestMapping("/auth")
public class LoginController {

	@Autowired
	private EverestServiceImpl everestServiceImpl = null;
	
	@Autowired
	private EverestDAO everestDAO = null;
	
	@Value("${jwt.key}")
	private String secret;

	/**
	 * Login Method using username/email and password
	 * 
	 * @param login
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public JSONObject login(@RequestBody LoginRequest login) throws Exception {

		ScriptLogger.writeInfo("login called");
		
		String jwtToken = "";

		JSONObject response = new JSONObject();
		int errorCode = 401;
		String responseStatus = Constants.FAILED;
		String responseMessage = "";

		boolean loginSuccess = false;

		if (login.getUserId() == null || login.getPassword() == null) {
			responseMessage = "userId or password is null";
			response = WebUtil.getResponse(errorCode, responseStatus, responseMessage);
			response.put("token", null);
		} 

		String userId = login.getUserId();
		String password = login.getPassword();

		User user = everestDAO.fetchUserByUsername(userId);

		if(user == null) {
			user = everestDAO.fetchUserByEmail(userId);
		}

		if(user != null) {

			String pwd = user.getPassword();
			if(password.equals(pwd)) {
				loginSuccess = true;
				userId = user.getUsername();
			}
		}

		if(loginSuccess) {

			jwtToken = Jwts.builder().setSubject(userId).claim("roles", "user").setIssuedAt(new Date())
					.setExpiration(new Date(System.currentTimeMillis() + 1800000000 ))
					.signWith(SignatureAlgorithm.HS256, secret).compact();


//			ScriptLogger.writeInfo("token out ---> " + jwtToken);
			errorCode = 0;
			responseStatus = Constants.SUCCESS;
			responseMessage = "Logged in successfully";
			response = WebUtil.getResponse(errorCode, responseStatus, responseMessage);
			response.put("token", jwtToken);
			response.put("userId", user.getId());
			response.put("username", user.getUsername());
			response.put("role", user.getUserRole());

			user.setToken(jwtToken);
			everestDAO.saveUser(user);

		}
		else {
			responseMessage = "Invalid userId or Password";
			response = WebUtil.getResponse(errorCode, responseStatus, responseMessage);
			response.put("token", null);
		}


		return response;
	}

	
	/**
	 * Logout Method using userId
	 * 
	 * @param login
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public JSONObject logout(@RequestBody LoginRequest login) throws Exception {

		ScriptLogger.writeInfo("logout called");
		
		JSONObject response = new JSONObject();
		int errorCode = 401;
		String responseStatus = Constants.FAILED;
		String responseMessage = "";

		try {
			String userId = login.getUserId();
	
			User user = everestDAO.fetchUser(UUID.fromString(userId));
	
			if(user != null) {
				user.setToken(null);
				everestDAO.saveUser(user);
			}
			else {
				throw new Exception("Invalid User id");
			}
			
			responseStatus = Constants.SUCCESS;
			errorCode = 0;
			responseMessage = "logged out successfully";
			
		}catch(Exception e) {
			responseMessage = "Invalid userId or Password";
		}
		
		response = WebUtil.getResponse(errorCode, responseStatus, responseMessage);

		return response;
	}

	@RequestMapping(value = "/aurbatao", method = RequestMethod.GET)
	public String hello() throws Exception{
		ScriptLogger.writeInfo("Test api called");
		return "Sab Badhiya, Tum Batao.";
	}

	@RequestMapping(value = "/testconfig", method = RequestMethod.GET)
	public String testConfig(@RequestParam(value="key", required=false, defaultValue="ENVIRONMENT_NAME") String name) throws Exception{

		String result = "Result from Configuration Table :: key is " + name + " and value is " + everestServiceImpl.getConfigurationValue("ENVIRONMENT", name) ;

		return result;
	}
	
}
