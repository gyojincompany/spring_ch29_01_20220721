package com.gyojincompany.ch2901.dao;

import java.util.ArrayList;

import com.gyojincompany.ch2901.dto.ContentDto;

public interface IDao {
	
	public ArrayList<ContentDto> listDao();//리스트 불러오기
	public void writeDao(String mwriter, String mcontent);//글쓰기
	public void deleteDao(String mid);//글삭제

}
