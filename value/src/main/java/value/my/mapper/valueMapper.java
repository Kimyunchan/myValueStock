package value.my.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository(value = "valueMapper")
public interface valueMapper {

	List<Map<?,?>> selectTable();
}	
		