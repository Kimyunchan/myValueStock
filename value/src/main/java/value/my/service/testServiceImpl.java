package value.my.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import value.my.mapper.*;

@Service
public class testServiceImpl implements testService{

	private final valueMapper valueMapper;
	
	@Autowired
	public testServiceImpl(valueMapper valueMapper) {
		this.valueMapper = valueMapper;
	}
		
	public List<Map<?,?>> getList(){
		
		List<Map<?,?>> list = valueMapper.selectTable();
		
		return list;
		
	}
}
