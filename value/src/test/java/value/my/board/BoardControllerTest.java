package value.my.board;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/dispatcher-servlet.xml",
		"file:src/main/resources/value/spring/context-sqlMap.xml",
		"file:src/main/resources/value/spring/context-dataSource.xml",
		"file:src/main/resources/value/sqlmap/config/sql-map-config.xml" })
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BoardControllerTest {

	@Autowired
	private BoardController boardController;

	private MockMvc mockMvc;

	@Before
	public void setUp() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(boardController).build(); // test를 위한 MockMvc 객체 생성.
																					// testController 1개만 주입.
//        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context).build();  // test를 위한 MockMvc 객체 생성. 스프링이 로드한 WebApplicationContext의 인스턴스로 작동.(standaloneSetup() 중 택 1)
	}

	@Test
	public void A_빈_로딩_여부() throws Exception {
		assertThat(boardController).isNotNull();
	}

	@Test
	public void B_DB에서_게시판_리스트_조회() throws Exception {

		MvcResult mvcResult = this.mockMvc.perform(get("/board/list")).andDo(print()).andExpect(status().isOk())
				.andReturn();

		List<BoardDTO> listBoardDTO = (List<BoardDTO>) mvcResult.getModelAndView().getModel().get("list");
		BoardDTO boardDTO = listBoardDTO.get(0);

		Assertions.assertThat(boardDTO.id).isEqualTo(1);
		Assertions.assertThat(boardDTO.content).isEqualTo("테스트입니다");
		Assertions.assertThat(boardDTO.authorId).isEqualTo(1);

		System.out.println("boardDTO.id===" + boardDTO.id);
		System.out.println("boardDTO.content===" + boardDTO.content);
		System.out.println("boardDTO.authorId===" + boardDTO.authorId);
	}

	@Test
	public void C_DB에서_게시판_단건_조회() throws Exception {

		MvcResult mvcResult = this.mockMvc.perform(get("/board/list/{id}", 1)).andDo(print()).andExpect(status().isOk())
				.andReturn();

		BoardDTO boardDTO = (BoardDTO) mvcResult.getModelAndView().getModel().get("boardDTO");

		Assertions.assertThat(boardDTO.id).isEqualTo(1);
		Assertions.assertThat(boardDTO.content).isEqualTo("테스트입니다");
		Assertions.assertThat(boardDTO.authorId).isEqualTo(1);

		System.out.println("boardDTO.id===" + boardDTO.id);
		System.out.println("boardDTO.content===" + boardDTO.content);
		System.out.println("boardDTO.authorId===" + boardDTO.authorId);
	}

	@Test
	public void D_게시글_생성() throws Exception {

		BoardDTO boardDTO = new BoardDTO(2, "테스트2", 2);

		System.out.println("boardDTO.id===" + boardDTO.id);
		System.out.println("boardDTO.content===" + boardDTO.content);
		System.out.println("boardDTO.authorId===" + boardDTO.authorId);

		this.mockMvc
				.perform(post("/board/create")
						.contentType(MediaType.APPLICATION_FORM_URLENCODED)
						.param("id", String.valueOf(boardDTO.id))
						.param("content", boardDTO.content)
						.param("authorId", String.valueOf(boardDTO.authorId)))
				.andDo(print())
				.andExpect(status().is3xxRedirection())
				.andReturn();
	}

	
	 @Test 
	 public void E_게시글_수정() throws Exception {
	  
		 BoardDTO boardDTO = new BoardDTO(2, "테스트2222", 2);

		 System.out.println("boardDTO.id===" + boardDTO.id);
		 System.out.println("boardDTO.content===" + boardDTO.content);
		 System.out.println("boardDTO.authorId===" + boardDTO.authorId);

		 this.mockMvc
				 .perform(post("/board/update")
						 .contentType(MediaType.APPLICATION_FORM_URLENCODED)
						 .param("id", String.valueOf(boardDTO.id))
						 .param("content", boardDTO.content)	
				 		 .param("authorId", String.valueOf(boardDTO.authorId)))
				 .andDo(print())
				 .andExpect(status().is3xxRedirection())
				 .andReturn();
		 
	 }
  
	 @Test 
	 public void F_게시글_삭제() throws Exception {
	  
		 this.mockMvc
				 .perform(get("/board/delete/{id}",2)
						 .contentType(MediaType.APPLICATION_FORM_URLENCODED))
				 .andDo(print())
				 .andExpect(status().is3xxRedirection())
				 .andReturn();
		 
	 }
	 

}
