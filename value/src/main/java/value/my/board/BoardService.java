package value.my.board;

import java.util.List;

import org.springframework.stereotype.Service;

import value.my.board.infra.BoardRepository;

@Service
public class BoardService {
	
	private BoardRepository boardRepository;
	
	BoardService(BoardRepository boardRepository){
		this.boardRepository = boardRepository;
	}

	public List<BoardDTO> getList(){
		return boardRepository.getList();
	}
	
	public BoardDTO getId(int id){
		return boardRepository.getId(id);
	}
	
	public void createBoard(BoardDTO boardDTO) {
		boardRepository.createBoard(boardDTO);
	}
	
	public void updateBoard(BoardDTO boardDTO) {
		boardRepository.updateBoard(boardDTO);
	}
	
	public void deleteBoard(int id) {
		boardRepository.deleteBoard(id);
	}
}
