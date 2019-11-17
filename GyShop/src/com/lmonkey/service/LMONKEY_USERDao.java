package com.lmonkey.service;

import com.lmonkey.dao.Basedao;
import com.lmonkey.entity.LMONKEY_USER;

public class LMONKEY_USERDao {
	
	public static int insert(LMONKEY_USER u){
		String sql = "insert into LMONKEY_USER values(?, ?, ?, ?, DATE_FORMAT(?,'%Y-%m-%d'), ?, ?, ?, ?, ?, )";
	    
		Object[] params={
				u.getUSER_ID(), 
				u.getUSER_NAME(),
				u.getUSER_PASSWORD(),
				u.getUSER_SEX(),
				u.getUSER_BIRTHDAY(),
				u.getUSER_IDENITY_CODE(),
				u.getUSER_EMAIL(),
				u.getUSER_MOBILE(),
				u.getUSER_ADDRESS(),
				u.getUSER_STATUS(),
		};
		return Basedao.exectuIUD(sql, params);
	}

}
