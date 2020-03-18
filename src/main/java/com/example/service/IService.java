package com.example.service;

import com.example.service.dto.request.Request;
import com.example.service.dto.response.Response;

public interface IService {
	
	Response play (Request req);
}
