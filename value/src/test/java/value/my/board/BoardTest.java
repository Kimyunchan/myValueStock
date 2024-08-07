package value.my.board;

import java.time.LocalDateTime;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;	
import org.assertj.core.api.*;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/dispatcher-servlet.xml"
		,"file:src/main/resources/value/spring/context-sqlMap.xml"
		,"file:src/main/resources/value/spring/context-dataSource.xml"
		,"file:src/main/resources/value/sqlmap/config/sql-map-config.xml"
})
public class BoardTest {
	
	@Test
	public void 객체_생성_테스트() {
		
		Board board = Board.builder()
				.id(1)
				.content("test")
				.authorId(1)
				.createDatetime(LocalDateTime.now())
				.build();
		
		BoardDTO boardDTO = board.toDto();
		Assertions.assertThat(boardDTO.getId()).isEqualTo(1);
		Assertions.assertThat(boardDTO.getContent()).isEqualTo("test");
		Assertions.assertThat(boardDTO.getAuthorId()).isEqualTo(1);
	}

}
