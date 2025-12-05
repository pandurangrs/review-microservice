package com.revicemicroservice.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.revicemicroservice.exception.ResourceNotFoundException;

@Component
public class Mapper {

	@Autowired
	private ModelMapper modelMapper;

	public <T> T convert(Object srcObj, Class<T> targetClas) {
		T response = null;

		try {
			response = modelMapper.map(srcObj, targetClas);
		} catch (Exception e) {
			throw new ResourceNotFoundException("entity not convert properly", HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return response;
	}

	public <S, T> List<T> convertToList(List<S> srcObj, Class<T> targetClass) {

		List<T> response = null;
		
		try {
			response = srcObj.stream().map(i -> modelMapper.map(i, targetClass)).collect(Collectors.toList());
		} catch (Exception e) {
			throw new ResourceNotFoundException("List not convert properly", HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return response;
	}
}
