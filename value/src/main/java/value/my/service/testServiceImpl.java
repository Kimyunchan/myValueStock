package value.my.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import value.my.mapper.*;

@Service
public class testServiceImpl implements testService{

	private final testMapper testMapper;
	
	@Autowired
	public testServiceImpl(testMapper testMapper) {
		this.testMapper = testMapper;
	}
		
	public List<Map<?,?>> getList(){
		
		List<Map<?,?>> list = testMapper.selectTable();
		
		return list;
		
	}
}
