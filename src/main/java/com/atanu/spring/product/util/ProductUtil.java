/**
 * 
 */
package com.atanu.spring.product.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.atanu.spring.product.constant.ErrorCode;
import com.atanu.spring.product.constant.ProductConstant;
import com.atanu.spring.product.exception.ProductException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Atanu Bhowmick
 *
 */

public class ProductUtil {

	private static final ObjectMapper mapper;
	private static final Logger logger = LoggerFactory.getLogger(ProductUtil.class);

	static {
		mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}

	/**
	 * Default Constructor
	 */
	private ProductUtil() {
	}

	/**
	 * @param <T>
	 * @param jsonString
	 * @param clazz
	 * @return T
	 */
	public static <T> T readValue(String json, Class<T> clazz) {
		T t = null;
		try {
			t = mapper.readValue(json, clazz);
		} catch (JsonProcessingException e) {
			throw new ProductException(ErrorCode.PE006.name(), ErrorCode.PE006.getErrorMsg(), e);
		}
		return t;
	}

	/**
	 * 
	 * @param <T>
	 * @param jsonString
	 * @param typeReference
	 * @return T
	 */
	public static <T> T readValue(String json, TypeReference<T> typeReference) {
		T t = null;
		try {
			t = mapper.readValue(json, typeReference);
		} catch (JsonProcessingException e) {
			throw new ProductException(ErrorCode.PE006.name(), ErrorCode.PE006.getErrorMsg(), e);
		}
		return t;
	}

	/**
	 * Convert object to string using jackson mapper
	 * 
	 * @param object
	 * @return
	 */
	public static String writeValue(Object object) {
		String str = ProductConstant.EMPTY_STRING;
		try {
			str = mapper.writeValueAsString(object);
		} catch (JsonProcessingException e) {
			logger.debug("Error while converting object to string", e);
		}
		return str;
	}

}
