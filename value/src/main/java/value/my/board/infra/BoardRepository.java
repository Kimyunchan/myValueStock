package value.my.board.infra;

import java.util.List;

import value.my.board.BoardDTO;

public interface BoardRepository {

	List<BoardDTO> getList();
	
	BoardDTO getId(int id);
	
	void createBoard(BoardDTO boardDTO);
	
	void updateBoard(BoardDTO boardDTO);
	
	void deleteBoard(int id);
}
