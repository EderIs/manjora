package com.manjora.project.manjora.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.SecurityContextPersistenceFilter;
import org.springframework.web.filter.GenericFilterBean;

import com.manjora.project.manjora.security.jwt.JwtProvider;
import com.manjora.project.manjora.service.EmailService;

public class SecurityFilter extends GenericFilterBean {
	 
	@Autowired
	private EmailService emailSerivice;
	
	Dictionary<String, String> usersNames = new Hashtable<String, String>();
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request1 = (HttpServletRequest) request;
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
          if(auth!=null) {
        	  System.out.print("\nHOts entrante: "+
        	  request1.getRemoteHost()+"\n");
    	   findUserActive(auth.getName(),request1.getRemoteAddr().toString());
          }
        chain.doFilter(request, response);
		
	}

	public void findUserActive(String name, String address) {
	
		if(usersNames.get(name)!=null) {
			
			if(usersNames.get(name) != address) {
				System.out.print("Direccion reciente: "+usersNames.get(name)+"\nDireccion entrante: "+address+"\n");
				
			}	
		}else {
			usersNames.put(name,address);
		}
	}
	
	
}
