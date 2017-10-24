package com.pisight.everest;


import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.UUID;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.filter.GenericFilterBean;

import com.pisight.everest.dao.EverestDAO;
import com.pisight.everest.dto.AuthenticationRequestWrapper;
import com.pisight.everest.entities.User;
import com.pisight.everest.util.ScriptLogger;
import com.pisight.everest.util.WebUtil;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@Component("JwtFilter")
public class JwtFilter extends GenericFilterBean {

	@Autowired
	private EverestDAO everestDAO = null;

	@Value("${jwt.key}")
	private String secret;

	public void doFilter(final ServletRequest req, final ServletResponse res, final FilterChain chain)
			throws IOException, ServletException {

		//		final HttpServletRequest request = (HttpServletRequest) req;
		final AuthenticationRequestWrapper request = new AuthenticationRequestWrapper((HttpServletRequest) req);
		final HttpServletResponse response = (HttpServletResponse) res;
		final String authHeader = request.getHeader("authorization");

		/*Enumeration<String> h = request.getHeaderNames();

		ScriptLogger.writeInfo("printing headers -->> " + authHeader);
		while(h.hasMoreElements()){
			ScriptLogger.writeInfo(h.nextElement());
		}*/

		String requestURL = request.getRequestURI();
		//		ScriptLogger.writeInfo("Request URI -> " + requestURL);

		if(requestURL.contains("/auth/login")){
			response.setStatus(HttpServletResponse.SC_OK);

			chain.doFilter(req, res);
		}
		else if ("OPTIONS".equals(request.getMethod())) {
			response.setStatus(HttpServletResponse.SC_OK);

			chain.doFilter(req, res);
		} else {

			if (authHeader == null || !authHeader.startsWith("Bearer ")) {
				ScriptLogger.writeError("Failed.>>>>>>>>>.");
				response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
				response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
				//				throw new ServletException("Missing or invalid Authorization header");
			}
			else {

				final String token = authHeader.substring(7);

				//				ScriptLogger.writeInfo("Token in --> " + token);

				try {

					final Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
					StringBuffer jb = new StringBuffer();
					try {
						InputStream is = request.getInputStream();
						InputStreamReader isr = new InputStreamReader(is);
						int i  = isr.read();
						while ( i != -1){
							jb.append((char) i);
							i = isr.read();
						}
					} catch (Exception e) {
						response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
					}

					//					ScriptLogger.writeInfo("jb - > " + jb);
					JSONObject jsonObject = null;
					try {
						jsonObject =  WebUtil.convertToJSONObject(jb.toString());
					} catch (JSONException e) {
						// crash and burn
						throw new IOException("Error parsing JSON request string");
					}

					//					ScriptLogger.writeInfo(jsonObject);
					String userId = (String) jsonObject.get("userId");
					//					ScriptLogger.writeInfo(userId);
					//					ScriptLogger.writeInfo(claims.getExpiration());
					User user = everestDAO.fetchUser(UUID.fromString(userId));
					if(user != null) {
						ScriptLogger.writeInfo("request received for user -> " + user.getUsername());
					}
					if(user == null) {
						ScriptLogger.writeError("user id is not valid");
						response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
						response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized. Invalid User Id");
					}
					else if((!claims.getSubject().equals(userId) && request.getMethod().equals(RequestMethod.POST)) || !token.equals(user.getToken())) {
						ScriptLogger.writeError("Failed............");
						response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
						response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized. Invalid Token for the user");
					}
					if(response.getStatus() == HttpServletResponse.SC_UNAUTHORIZED) {
						ScriptLogger.writeError("Unauthorized.. returning");
						return;
					}
					request.setAttribute("claims", claims);
					try{
						chain.doFilter(request, res);
					}
					catch(Exception e){
						throw e;
					}
				} catch (Exception e) {
					ScriptLogger.writeError("Failed");
					ScriptLogger.writeError("error -> ", e);
					response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
					response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized. Invalid Token");
				}

			}


		}
	}
}
